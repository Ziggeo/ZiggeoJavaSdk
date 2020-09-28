package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoVideos {

    private final Ziggeo application;

    public ZiggeoVideos(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/videos/", data);
    }

    public JSONObject count(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/count", data);
    }

    public JSONObject get(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + tokenOrKey + "", null);
    }

    public JSONArray getBulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/get_bulk", data, null);
    }

    public JSONArray statsBulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/stats_bulk", data, null);
    }

    public InputStream downloadVideo(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + tokenOrKey + "/video", null);
    }

    public InputStream downloadImage(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + tokenOrKey + "/image", null);
    }

    public JSONObject getStats(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + tokenOrKey + "/stats", null);
    }

    public JSONObject pushToService(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/push", data, null);
    }

    public JSONObject applyEffect(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/effect", data, null);
    }

    public JSONObject applyMeta(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/metaprofile", data, null);
    }

    public JSONObject update(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "", data, null);
    }

    public JSONArray updateBulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/update_bulk", data, null);
    }

    public InputStream delete(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/videos/" + tokenOrKey + "", null);
    }

    public JSONObject create(JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/", data, file);
    }

    public JSONArray analytics(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/" + tokenOrKey + "/analytics", data, null);
    }

}

