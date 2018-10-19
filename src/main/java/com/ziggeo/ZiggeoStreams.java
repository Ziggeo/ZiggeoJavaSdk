package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoStreams {

    private Ziggeo application;

    public ZiggeoStreams(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String videoTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/videos/" + videoTokenOrKey + "/streams", data);
    }

    public JSONObject get(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "", null);
    }

    @Deprecated
    public InputStream download_video(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return downloadVideo(videoTokenOrKey, tokenOrKey);
    }

    public InputStream downloadVideo(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", null);
    }

    @Deprecated
    public InputStream download_image(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return downloadImage(videoTokenOrKey, tokenOrKey);
    }

    public InputStream downloadImage(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", null);
    }

    @Deprecated
    public JSONObject push_to_service(String videoTokenOrKey, String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return pushToService(videoTokenOrKey, tokenOrKey, data);
    }

    public JSONObject pushToService(String videoTokenOrKey, String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/push", data, null);
    }

    public InputStream delete(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "", null);
    }

    public JSONObject create(String videoTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams", data, file);
    }

    @Deprecated
    public JSONObject attach_image(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return attachImage(videoTokenOrKey, tokenOrKey, data, file);
    }

    public JSONObject attachImage(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", data, file);
    }

    @Deprecated
    public JSONObject attach_video(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return attachVideo(videoTokenOrKey, tokenOrKey, data, file);
    }

    public JSONObject attachVideo(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", data, file);
    }

    public JSONObject bind(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/bind", null, null);
    }

}

