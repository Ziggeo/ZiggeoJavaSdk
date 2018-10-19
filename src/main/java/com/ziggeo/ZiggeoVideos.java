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

    public JSONObject get(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + tokenOrKey + "", null);
    }

    @Deprecated
    public JSONArray get_bulk(JSONObject data) throws IOException, JSONException {
        return getBulk(data);
    }

    public JSONArray getBulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/get_bulk", data, null);
    }

    @Deprecated
    public JSONArray stats_bulk(JSONObject data) throws IOException, JSONException {
        return statsBulk(data);
    }

    public JSONArray statsBulk(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSONArray("/v1/videos/stats_bulk", data, null);
    }

    @Deprecated
    public InputStream download_video(String tokenOrKey) throws IOException, JSONException {
        return downloadVideo(tokenOrKey);
    }

    public InputStream downloadVideo(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + tokenOrKey + "/video", null);
    }

    @Deprecated
    public InputStream download_image(String tokenOrKey) throws IOException, JSONException {
        return downloadImage(tokenOrKey);
    }

    public InputStream downloadImage(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + tokenOrKey + "/image", null);
    }

    @Deprecated
    public JSONObject get_stats(String tokenOrKey) throws IOException, JSONException {
        return getStats(tokenOrKey);
    }

    public JSONObject getStats(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + tokenOrKey + "/stats", null);
    }

    @Deprecated
    public JSONObject push_to_service(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return pushToService(tokenOrKey, data);
    }

    public JSONObject pushToService(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/push", data, null);
    }

    @Deprecated
    public JSONObject apply_effect(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return applyEffect(tokenOrKey, data);
    }

    public JSONObject applyEffect(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/effect", data, null);
    }

    @Deprecated
    public JSONObject apply_meta(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return applyMeta(tokenOrKey, data);
    }

    public JSONObject applyMeta(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "/metaprofile", data, null);
    }

    public JSONObject update(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + tokenOrKey + "", data, null);
    }

    @Deprecated
    public JSONArray update_bulk(JSONObject data) throws IOException, JSONException {
        return updateBulk(data);
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

