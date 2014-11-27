package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoVideos {

    private Ziggeo application;

    public ZiggeoVideos(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/videos/", data);
    }

    public JSONObject get(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/videos/" + token_or_key + "", null);
    }

    public InputStream download_video(String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/videos/" + token_or_key + "/video", null);
    }

    public InputStream download_image(String token_or_key) throws IOException, JSONException {
        return this.application.connect().get("/videos/" + token_or_key + "/image", null);
    }

    public JSONObject update(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/videos/" + token_or_key + "", data, null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/videos/" + token_or_key + "", null);
    }

    public JSONObject create(JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/videos/", data, file);
    }

}

