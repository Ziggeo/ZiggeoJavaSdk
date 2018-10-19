package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoEffectProfileProcess {

    private Ziggeo application;

    public ZiggeoEffectProfileProcess(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String effectTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/effects/" + effectTokenOrKey + "/process", data);
    }

    public JSONObject get(String effectTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey + "", null);
    }

    public InputStream delete(String effectTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/effects/" + effectTokenOrKey + "/process/" + tokenOrKey + "", null);
    }

    @Deprecated
    public JSONObject create_filter_process(String effectTokenOrKey, JSONObject data) throws IOException, JSONException {
        return createFilterProcess(effectTokenOrKey, data);
    }

    public JSONObject createFilterProcess(String effectTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/filter", data, null);
    }

    @Deprecated
    public JSONObject create_watermark_process(String effectTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return createWatermarkProcess(effectTokenOrKey, data, file);
    }

    public JSONObject createWatermarkProcess(String effectTokenOrKey, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + effectTokenOrKey + "/process/watermark", data, file);
    }

}

