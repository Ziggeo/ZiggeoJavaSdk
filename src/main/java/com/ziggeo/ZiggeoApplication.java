package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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

    @Deprecated
    public JSONObject get_stats(JSONObject data) throws IOException, JSONException {
        return getStats(data);
    }

    public JSONObject getStats(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/application/stats", data);
    }

}

