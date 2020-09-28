package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoWebhooks {

    private Ziggeo application;

    public ZiggeoWebhooks(Ziggeo application) {
        this.application = application;
    }

    public InputStream create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().post("/v1/api/hook", data, null);
    }

    public InputStream confirm(JSONObject data) throws IOException, JSONException {
        return this.application.connect().post("/v1/api/confirmhook", data, null);
    }

    public InputStream delete(JSONObject data) throws IOException, JSONException {
        return this.application.connect().post("/v1/api/removehook", data, null);
    }

}

