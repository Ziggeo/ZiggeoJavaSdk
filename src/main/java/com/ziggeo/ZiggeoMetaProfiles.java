package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoMetaProfiles {

    private final Ziggeo application;

    public ZiggeoMetaProfiles(Ziggeo application) {
        this.application = application;
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/metaprofiles/", data);
    }

    public JSONObject index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/metaprofiles/", data);
    }

    public JSONObject get(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/metaprofiles/" + tokenOrKey, null);
    }

    public InputStream delete(String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/metaprofiles/" + tokenOrKey, null);
    }

}

