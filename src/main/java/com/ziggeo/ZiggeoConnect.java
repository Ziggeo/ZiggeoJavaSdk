package com.ziggeo;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZiggeoConnect {
    private static final int SERVER_ERROR = 500;

    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";

    private final Ziggeo application;
    private final String baseUri;
    private ZiggeoConfig config;

    public ZiggeoConnect(Ziggeo application, String baseUri) {
        this.application = application;
        this.baseUri = baseUri;
        this.config = new ZiggeoConfig();
    }

    public ZiggeoConnect(Ziggeo application, String baseUri, ZiggeoConfig config) {
        this.application = application;
        this.baseUri = baseUri;
        this.config = config;
    }

    public InputStream request(String method, String path, JSONObject data,
                               File file) throws IOException, JSONException {
        HttpResponse response = null;
        for (int i = 0; i < config.getResilienceFactor(); i++) {
            try {
                response = singleRequest(method, path, data, file);
                if (response.getStatusLine().getStatusCode() < SERVER_ERROR) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        InputStream is = null;
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            is = resEntity.getContent();
        }
        return is;
    }

    private HttpResponse singleRequest(String method, String path, JSONObject data,
                                       File file) throws IOException, JSONException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpRequestBase request;

        List<NameValuePair> nvps = new LinkedList<>();
        String encodedStr = "";
        if (data != null) {
            Iterator<String> keys = data.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = data.get(key).toString();
                nvps.add(new BasicNameValuePair(key, value));
                encodedStr += key + "=" +
                        URLEncoder.encode(value, "UTF-8") + "&";
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
        try {
            request.addHeader(new BasicScheme(StandardCharsets.UTF_8).authenticate(new
                    UsernamePasswordCredentials(this.application.getToken(), this
                    .application.getPrivateKey()), request, null));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Could not create auth header!", e);
        }

        if (file != null && POST.equalsIgnoreCase(method)) {
            MultipartEntityBuilder mpBuilder = MultipartEntityBuilder.create();
            for (NameValuePair nv : nvps)
                mpBuilder.addPart(nv.getName(), new StringBody(nv.getValue(),
                        ContentType.TEXT_PLAIN));
            ContentBody cbFile = new FileBody(file, ContentType.create
                    ("video", StandardCharsets.UTF_8), file.getName());
            mpBuilder.addPart("file", cbFile);
            ((HttpPost) request).setEntity(mpBuilder.build());
        } else if (POST.equalsIgnoreCase(method)) {
            ((HttpPost) request).setEntity(encoded);
        }

        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(application.config().getSocketTimeout())
                .setConnectTimeout(application.config().getConnectionTimeout())
                .build();
        request.setConfig(config);
        return httpClient.execute(request);
    }

    public String requestString(String method, String path, JSONObject data,
                                File file) throws IOException, JSONException {
        InputStream inputStream = this.request(method, path, data, file);

        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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

    public JSONObject postUploadJSON(String path, String scope, JSONObject data, File file, String typeKey)
            throws IOException {
        if (typeKey != null) {
            data.put(typeKey, FilenameUtils.getExtension(file.getName()));
        }
        JSONObject resp = this.postJSON(path, data);
        JSONObject ret = resp.getJSONObject(scope);
        JSONObject urlData = resp.getJSONObject("url_data").getJSONObject("fields");
        this.request(POST, resp.getJSONObject("url_data").getString("url"), urlData, file);
        return ret;
    }

    public JSONObject postJSON(String path)
            throws IOException, JSONException {
        return this.requestJSON(POST, path, null, null);
    }

    public JSONObject postJSON(String path, JSONObject data)
            throws IOException, JSONException {
        return this.requestJSON(POST, path, data, null);
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
