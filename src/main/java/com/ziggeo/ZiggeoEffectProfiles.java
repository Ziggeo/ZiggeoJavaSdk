package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoEffectProfiles {

    private Ziggeo application;

    public ZiggeoEffectProfiles(Ziggeo application) {
        this.application = application;
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/", data, null);
    }

    public JSONObject index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/", data);
    }

    public JSONObject get(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/" + token_or_key + "", null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/v1/effects/" + token_or_key + "", null);
    }

    public JSONObject update(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + token_or_key + "", data, null);
    }

}

