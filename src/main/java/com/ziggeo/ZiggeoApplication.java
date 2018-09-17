package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoApplication {

    private Ziggeo application;

    public ZiggeoApplication(Ziggeo application) {
        this.application = application;
    }

    public JSONObject get() throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/application", null);
    }

    public JSONObject update(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/application", data, null);
    }

    public JSONObject get_stats(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/application/stats", data);
    }

}

