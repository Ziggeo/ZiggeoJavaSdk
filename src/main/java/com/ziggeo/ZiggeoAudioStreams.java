package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoAudioStreams {

    private Ziggeo application;

    public ZiggeoAudioStreams(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String audioTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSONArray("/server/v1/audios/bytoken/" + audioTokenOrKey + "/streams", data);
    }

    public JSONObject get(String audioTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/audios/bytoken/" + audioTokenOrKey + "/streams/bytoken/" + tokenOrKey + "", null);
    }

    public InputStream downloadAudio(String audioTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/server/v1/audios/bytoken/" + audioTokenOrKey + "/streams/bytoken/" + tokenOrKey + "/audio", null);
    }

    public InputStream delete(String audioTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.apiConnect().delete("/server/v1/audios/bytoken/" + audioTokenOrKey + "/streams/bytoken/" + tokenOrKey + "", null);
    }

    public JSONObject create(String audioTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
    if (file != null) {
        JSONObject result = this.application.connect().postUploadJSON("/server/v1/audios/" + audioTokenOrKey + "/streams-upload-url", "stream", data, file, "audio_type");
        result = this.application.connect().postJSON("/server/v1/audios/" + audioTokenOrKey + "/streams/" + result.get("token") + "/confirm-video");
        return result;
    } else
            return this.application.apiConnect().postJSON("/server/v1/audios/bytoken/" + audioTokenOrKey + "/streams", data);
    }

}

