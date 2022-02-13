package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoAudios {

    private Ziggeo application;

    public ZiggeoAudios(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSONArray("/server/v1/audios/", data);
    }

    public JSONObject count(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/audios/count", data);
    }

    public JSONObject get(String tokenOrKey) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/audios/bytoken/" + tokenOrKey + "", null);
    }

    public JSONArray getBulk(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().postJSONArray("/server/v1/audios/get-bulk", data);
    }

    public InputStream downloadAudio(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().get("/v1/server/v1/audios/bytoken/" + tokenOrKey + "/video", null);
    }

    public JSONObject update(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().postJSON("/server/v1/audios/bytoken/" + tokenOrKey + "", data);
    }

    public JSONArray updateBulk(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().postJSONArray("/server/v1/audios/update-bulk", data);
    }

    public InputStream delete(String tokenOrKey) throws IOException, JSONException {
        return this.application.apiConnect().delete("/server/v1/audios/bytoken/" + tokenOrKey + "", null);
    }

    public JSONObject create(JSONObject data, File file) throws IOException, JSONException {
    if (file != null) {
        JSONObject result = this.application.connect().postUploadJSON("/server/v1/audios/audios-upload-url", "audio", data, file, "audio_type");
        result.put("default_stream", this.application.connect().postJSON("/server/v1/audios/" + result.get("token") + "/streams/" + result.getJSONObject("default_stream").getString("token") + "/confirm-audio"));
        return result;
    } else
            return this.application.apiConnect().postJSON("/server/v1/audios/", data);
    }

}

