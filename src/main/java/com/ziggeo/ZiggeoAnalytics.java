package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ZiggeoAnalytics {

    private Ziggeo application;

    public ZiggeoAnalytics(Ziggeo application) {
        this.application = application;
    }

    public JSONObject get(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/analytics/get", data, null);
    }

}

