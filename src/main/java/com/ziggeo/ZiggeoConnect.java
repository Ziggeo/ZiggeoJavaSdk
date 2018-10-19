package com.ziggeo;

import org.apache.http.*;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZiggeoConnect {
    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";

    private Ziggeo application;
    private String baseUri;

    public ZiggeoConnect(Ziggeo application, String baseUri) {
        this.application = application;
        this.baseUri = baseUri;
    }

    public InputStream request(String method, String path, JSONObject data,
                               File file) throws IOException, JSONException {
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

        if (GET.equalsIgnoreCase(method)) {
            request = new HttpGet(baseUri + path + "?" + encodedStr);
        } else if (POST.equalsIgnoreCase(method)) {
            request = new HttpPost(baseUri + path);
        } else {
            request = new HttpDelete(baseUri + path + "?" + encodedStr);
        }
        request.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials(this.application.getToken(), this.application.getPrivateKey()), "UTF-8", false));

        if (file != null && POST.equalsIgnoreCase(method)) {
            MultipartEntity mpEntity = new MultipartEntity();
            for (NameValuePair nv : nvps)
                mpEntity.addPart(nv.getName(), new StringBody(nv.getValue()));
            ContentBody cbFile = new FileBody(file, "video");
            mpEntity.addPart("file", cbFile);
            ((HttpPost) request).setEntity(mpEntity);
        } else if (POST.equalsIgnoreCase(method)) {
            ((HttpPost) request).setEntity(encoded);
        }

        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(application.config().getSocketTimeout())
                .setConnectTimeout(application.config().getConnectionTimeout())
                .build();
        request.setConfig(config);

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
        return this.request(GET, path, data, null);
    }

    public JSONObject getJSON(String path, JSONObject data) throws IOException,
            JSONException {
        return this.requestJSON(GET, path, data, null);
    }

    public JSONArray getJSONArray(String path, JSONObject data) throws IOException,
            JSONException {
        return this.requestJSONArray(GET, path, data, null);
    }

    public JSONArray postJSONArray(String path, JSONObject data, File file) throws IOException,
            JSONException {
        return this.requestJSONArray(GET, path, data, file);
    }

    public InputStream post(String path, JSONObject data, File file)
            throws IOException, JSONException {
        return this.request(POST, path, data, file);
    }

    public JSONObject postJSON(String path, JSONObject data, File file)
            throws IOException, JSONException {
        return this.requestJSON(POST, path, data, file);
    }

    public InputStream delete(String path, JSONObject data) throws IOException,
            JSONException {
        return this.request(DELETE, path, data, null);
    }

    public JSONObject deleteJSON(String path, JSONObject data)
            throws IOException, JSONException {
        return this.requestJSON(DELETE, path, data, null);
    }

}
