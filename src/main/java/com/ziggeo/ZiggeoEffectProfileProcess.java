package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoEffectProfileProcess {

    private final Ziggeo application;

    public ZiggeoEffectProfileProcess(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String effectTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/effects/" + effectTokenOrKey + "/process", data);
    }

    public JSONObject get(String effectTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey, null);
    }

    public InputStream delete(String effectTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey, null);
    }

    public JSONObject createFilterProcess(String effectTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/filter", data);
    }

    public JSONObject createWatermarkProcess(String effectTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        if (file != null) {
            JSONObject result = this.application.connect().postUploadJSON("/v1/effects/" + effectTokenOrKey + "/process/watermark-upload-url", "effect_process", data, file, null);
            final String videoToken = result.getString("token");
            result = this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/" + videoToken + "/confirm-watermark");
            return result;
        } else {
            return this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/watermark", data);
        }
    }

    public JSONObject editWatermarkProcess(String effectTokenOrKey, String tokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        if (file != null) {
            this.application.connect().postUploadJSON("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey + "/watermark-upload-url", "effect_process", data, file, null);
            JSONObject result = this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey + "/confirm-watermark");
            return result;
        } else {
            return this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/watermark/" + tokenOrKey, data);
        }
    }

}

