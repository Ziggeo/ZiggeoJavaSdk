package com.ziggeo;

import org.json.*;
import java.io.*;
import java.util.*;
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
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(
				CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

		HttpRequestBase request = null;
		
		List<NameValuePair> nvps = new LinkedList<NameValuePair>();
		if (data != null) {
			Iterator<String> keys = data.keys();
			while (keys.hasNext()) {
				String key = keys.next();
				nvps.add(new BasicNameValuePair(key, data.getString(key)));
			}
		}
		UrlEncodedFormEntity encoded = new UrlEncodedFormEntity(nvps, Consts.UTF_8);

		if (method.toUpperCase() == "GET")
			request = new HttpGet(this.application.config().server_api_url
					+ "/v1" + path + "?" + encoded.toString());
		else if (method.toUpperCase() == "POST")
			request = new HttpPost(this.application.config().server_api_url
					+ "/v1" + path);
		else
			request = new HttpDelete(this.application.config().server_api_url
					+ "/v1" + path + "?" + encoded.toString());

		HttpRequestInterceptor preemptiveAuth = new HttpRequestInterceptor() {
			public void process(final HttpRequest request,
					final HttpContext context) throws HttpException,
					IOException {
				AuthState authState = (AuthState) context
						.getAttribute(ClientContext.TARGET_AUTH_STATE);
				CredentialsProvider credsProvider = (CredentialsProvider) context
						.getAttribute(ClientContext.CREDS_PROVIDER);
				HttpHost targetHost = (HttpHost) context
						.getAttribute(ExecutionContext.HTTP_TARGET_HOST);

				if (authState.getAuthScheme() == null) {
					AuthScope authScope = new AuthScope(
							targetHost.getHostName(), targetHost.getPort());
					Credentials creds = credsProvider.getCredentials(authScope);
					if (creds != null) {
						authState.setAuthScheme(new BasicScheme());
						authState.setCredentials(creds);
					}
				}
			}
		};

		httpclient.addRequestInterceptor(preemptiveAuth, 0);
		Credentials defaultcreds = new UsernamePasswordCredentials(
				this.application.token, this.application.private_key);
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope("ziggeo.com", 443, AuthScope.ANY_REALM),
				defaultcreds);

		if (file != null && method.toUpperCase() == "POST") {
			MultipartEntity mpEntity = new MultipartEntity();
			for (NameValuePair nv: nvps)
				mpEntity.addPart(nv.getName(), new StringBody(nv.getValue()));
			ContentBody cbFile = new FileBody(file, "video");
			mpEntity.addPart("file", cbFile);
			((HttpPost) request).setEntity(mpEntity);
		} else if (method.toUpperCase() == "POST") {
			((HttpPost) request).setEntity(encoded);
		}

		HttpResponse response = httpclient.execute(request);
		HttpEntity resEntity = response.getEntity();

		httpclient.getConnectionManager().shutdown();
		return resEntity.getContent();
	}

	public JSONObject requestJSON(String method, String path, JSONObject data,
			File file) throws IOException, JSONException {
		return new JSONObject(this.request(method, path, data, file));
	}

	public InputStream get(String path, JSONObject data) throws IOException, JSONException {
		return this.request("GET", path, data, null);
	}

	public JSONObject getJSON(String path, JSONObject data) throws IOException, JSONException {
		return this.requestJSON("GET", path, data, null);
	}

	public InputStream post(String path, JSONObject data, File file)
			throws IOException, JSONException {
		return this.request("POST", path, data, file);
	}

	public JSONObject postJSON(String path, JSONObject data, File file)
			throws IOException, JSONException {
		return this.requestJSON("POST", path, data, file);
	}

	public InputStream delete(String path, JSONObject data) throws IOException, JSONException {
		return this.request("DELETE", path, data, null);
	}

	public JSONObject deleteJSON(String path, JSONObject data)
			throws IOException, JSONException {
		return this.requestJSON("DELETE", path, data, null);
	}

}