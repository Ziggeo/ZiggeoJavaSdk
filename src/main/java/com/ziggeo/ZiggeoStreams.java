package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoStreams {

    private final Ziggeo application;

    public ZiggeoStreams(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String videoTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/videos/" + videoTokenOrKey + "/streams", data);
    }

    public JSONObject get(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "", null);
    }

    public InputStream downloadVideo(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.cdnConnect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", null);
    }

    public InputStream downloadImage(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.cdnConnect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", null);
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

    public JSONObject attachImage(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", data, file);
    }

    public JSONObject attachVideo(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", data, file);
    }

    public JSONObject attachSubtitle(String videoTokenOrKey, String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/subtitle", data, null);
    }

    public JSONObject bind(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/bind", null, null);
    }

}

