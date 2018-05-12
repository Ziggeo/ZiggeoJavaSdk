package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoAnalytics {

    private Ziggeo application;

    public ZiggeoAnalytics(Ziggeo application) {
        this.application = application;
    }

    public JSONObject get(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/analytics/get", data, null);
    }

}

