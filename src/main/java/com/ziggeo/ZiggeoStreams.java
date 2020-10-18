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

    public InputStream downloadVideo(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.cdnConnect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", null);
    }

    public InputStream downloadImage(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.cdnConnect().get("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", null);
    }

    public JSONObject pushToService(String videoTokenOrKey, String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/push", data);
    }

    public InputStream delete(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "", null);
    }

    public JSONObject create(String videoTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
    if (file != null) {
        JSONObject result = this.application.connect().postUploadJSON("/v1/videos/" + videoTokenOrKey + "/streams-upload-url", "stream", data, file, "video_type");
        result = this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + result.get("token") + "/confirm-video");
        return result;
    } else
            return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams", data);
    }

    public JSONObject attachImage(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
    if (file != null) {
        JSONObject result = this.application.connect().postUploadJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image-upload-url", "stream", data, file, null);
        result = this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/confirm-image");
        return result;
    } else
            return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/image", data);
    }

    public JSONObject attachVideo(String videoTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
    if (file != null) {
        JSONObject result = this.application.connect().postUploadJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video-upload-url", "stream", data, file, "video_type");
        result = this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/confirm-video");
        return result;
    } else
            return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/video", data);
    }

    public JSONObject attachSubtitle(String videoTokenOrKey, String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/subtitle", data);
    }

    public JSONObject bind(String videoTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/videos/" + videoTokenOrKey + "/streams/" + tokenOrKey + "/bind", null);
    }

}

