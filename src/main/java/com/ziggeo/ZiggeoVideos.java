package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoVideos {

    private Ziggeo application;

    public ZiggeoVideos(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/videos/", data);
    }

    public JSONObject count(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/count", data);
    }

    public JSONObject get(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + token_or_key + "", null);
    }

    public JSONArray get_bulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/get_bulk", data, null);
    }

    public JSONArray stats_bulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/stats_bulk", data, null);
    }

    public InputStream download_video(String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + token_or_key + "/video", null);
    }

    public InputStream download_image(String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + token_or_key + "/image", null);
    }

    public JSONObject get_stats(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + token_or_key + "/stats", null);
    }

    public JSONObject push_to_service(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + token_or_key + "/push", data, null);
    }

    public JSONObject apply_effect(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + token_or_key + "/effect", data, null);
    }

    public JSONObject apply_meta(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + token_or_key + "/metaprofile", data, null);
    }

    public JSONObject update(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + token_or_key + "", data, null);
    }

    public JSONArray update_bulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/update_bulk", data, null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/v1/videos/" + token_or_key + "", null);
    }

    public JSONObject create(JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/", data, file);
    }

    public JSONArray analytics(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/" + token_or_key + "/analytics", data, null);
    }

}

