package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoAuthtokens {

    private Ziggeo application;

    public ZiggeoAuthtokens(Ziggeo application) {
        this.application = application;
    }

    public JSONObject get(String token) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/authtokens/" + token + "", null);
    }

    public JSONObject update(String token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/authtokens/" + token_or_key + "", data, null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/v1/authtokens/" + token_or_key + "", null);
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/authtokens/", data, null);
    }

}

