package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

    public JSONObject getStats(JSONObject data) throws IOException, JSONException {
        return this.application.apiConnect().getJSON("/server/v1/application/stats", data);
    }

}

