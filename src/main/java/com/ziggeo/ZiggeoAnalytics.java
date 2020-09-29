package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ZiggeoAnalytics {

    private final Ziggeo application;

    public ZiggeoAnalytics(Ziggeo application) {
        this.application = application;
    }

    public JSONObject get(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/analytics/get", data);
    }

}

