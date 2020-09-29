package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoEffectProfiles {

    private final Ziggeo application;

    public ZiggeoEffectProfiles(Ziggeo application) {
        this.application = application;
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/", data);
    }

    public JSONObject index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/", data);
    }

    public JSONObject get(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/effects/" + tokenOrKey, null);
    }

    public InputStream delete(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/effects/" + tokenOrKey, null);
    }

    public JSONObject update(String tokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/effects/" + tokenOrKey, data);
    }

}

