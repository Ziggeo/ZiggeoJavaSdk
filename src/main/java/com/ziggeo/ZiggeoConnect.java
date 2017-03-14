package com.ziggeo;

import org.json.*;
import java.io.*;
import java.util.*;
import java.net.*;
import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.impl.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.mime.*;
import org.apache.http.entity.mime.content.*;
import org.apache.http.impl.client.*;
import org.apache.http.params.*;
import org.apache.http.util.*;
import org.apache.http.protocol.*;
import org.apache.http.client.protocol.*;
import org.apache.http.message.*;
import org.apache.http.client.entity.*;

public class ZiggeoConnect {

	private Ziggeo application;

	public ZiggeoConnect(Ziggeo application) {
		this.application = application;
	}

	public InputStream request(String method, String path, JSONObject data,
			File file) throws IOException, JSONException {
		String server_api_url = application.config().server_api_url;
		for (Map.Entry<String, String> entry : application.config().regions.entrySet()) {
		    if (this.application.token.startsWith(entry.getKey()))
		        server_api_url = entry.getValue();
        }

		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(
				CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

		HttpRequestBase request = null;

		List<NameValuePair> nvps = new LinkedList<NameValuePair>();
		String encodedStr = "";
		if (data != null) {
			Iterator<String> keys = data.keys();
			while (keys.hasNext()) {
                                String key = keys.next();
                                String value = data.get(key).toString();
                                nvps.add(new BasicNameValuePair(key, value));
                                encodedStr += key + "=" +
                                        URLEncoder.encode(value) + "&";
			}
		}
		UrlEncodedFormEntity encoded = new UrlEncodedFormEntity(nvps,
				Consts.UTF_8);

		if (method.toUpperCase() == "GET")
			request = new HttpGet(server_api_url
					+ "/v1" + path + "?" + encodedStr);
		else if (method.toUpperCase() == "POST")
			request = new HttpPost(server_api_url
					+ "/v1" + path);
		else
			request = new HttpDelete(server_api_url
					+ "/v1" + path + "?" + encodedStr);

		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(
						new URL(server_api_url).getHost(),
						AuthScope.ANY_PORT),
				new UsernamePasswordCredentials(this.application.token,
						this.application.private_key));

		if (file != null && method.toUpperCase() == "POST") {
			MultipartEntity mpEntity = new MultipartEntity();
			for (NameValuePair nv : nvps)
				mpEntity.addPart(nv.getName(), new StringBody(nv.getValue()));
			ContentBody cbFile = new FileBody(file, "video");
			mpEntity.addPart("file", cbFile);
			((HttpPost) request).setEntity(mpEntity);
		} else if (method.toUpperCase() == "POST") {
			((HttpPost) request).setEntity(encoded);
		}

		HttpResponse response = httpclient.execute(request);
		HttpEntity resEntity = response.getEntity();

		// httpclient.getConnectionManager().shutdown();
		return resEntity.getContent();
	}

	public String requestString(String method, String path, JSONObject data,
			File file) throws IOException, JSONException {
		InputStream inputStream = this.request(method, path, data, file);

		StringBuilder inputStringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream, "UTF-8"));
		String line = bufferedReader.readLine();
		while (line != null) {
			inputStringBuilder.append(line);
			inputStringBuilder.append('\n');
			line = bufferedReader.readLine();
		}

		return inputStringBuilder.toString();
	}

	public JSONObject requestJSON(String method, String path, JSONObject data,
			File file) throws IOException, JSONException {
		return new JSONObject(this.requestString(method, path, data, file));
	}

	public JSONArray requestJSONArray(String method, String path, JSONObject data,
			File file) throws IOException, JSONException {
		return new JSONArray(this.requestString(method, path, data, file));
	}

	public InputStream get(String path, JSONObject data) throws IOException,
			JSONException {
		return this.request("GET", path, data, null);
	}

	public JSONObject getJSON(String path, JSONObject data) throws IOException,
			JSONException {
		return this.requestJSON("GET", path, data, null);
	}

	public JSONArray getJSONArray(String path, JSONObject data) throws IOException,
			JSONException {
		return this.requestJSONArray("GET", path, data, null);
	}

	public InputStream post(String path, JSONObject data, File file)
			throws IOException, JSONException {
		return this.request("POST", path, data, file);
	}

	public JSONObject postJSON(String path, JSONObject data, File file)
			throws IOException, JSONException {
		return this.requestJSON("POST", path, data, file);
	}

	public InputStream delete(String path, JSONObject data) throws IOException,
			JSONException {
		return this.request("DELETE", path, data, null);
	}

	public JSONObject deleteJSON(String path, JSONObject data)
			throws IOException, JSONException {
		return this.requestJSON("DELETE", path, data, null);
	}

}
