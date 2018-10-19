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

    public JSONArray index(String video_token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/videos/" + video_token_or_key + "/streams", data);
    }

    public JSONObject get(String video_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "", null);
    }

    public InputStream download_video(String video_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/video", null);
    }

    public InputStream download_image(String video_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/image", null);
    }

    public JSONObject push_to_service(String video_token_or_key, String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/push", data, null);
    }

    public InputStream delete(String video_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "", null);
    }

    public JSONObject create(String video_token_or_key, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + video_token_or_key + "/streams", data, file);
    }

    public JSONObject attach_image(String video_token_or_key, String token_or_key, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/image", data, file);
    }

    public JSONObject attach_video(String video_token_or_key, String token_or_key, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/video", data, file);
    }

    public JSONObject bind(String video_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + video_token_or_key + "/streams/" + token_or_key + "/bind", null, null);
    }

}

