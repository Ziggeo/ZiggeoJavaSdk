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

    public JSONArray index(String effect_token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/effects/" + effect_token_or_key + "/process", data);
    }

    public JSONObject get(String effect_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/" + effect_token_or_key + "/process/" + token_or_key + "", null);
    }

    public InputStream delete(String effect_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/v1/effects/" + effect_token_or_key + "/process/" + token_or_key + "", null);
    }

    public JSONObject create_filter_process(String effect_token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + effect_token_or_key + "/process/filter", data, null);
    }

    public JSONObject create_watermark_process(String effect_token_or_key, JSONObject data, File file) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + effect_token_or_key + "/process/watermark", data, file);
    }

}

