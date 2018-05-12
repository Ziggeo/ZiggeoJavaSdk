package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoWebhooks {

    private Ziggeo application;

    public ZiggeoWebhooks(Ziggeo application) {
        this.application = application;
    }

    public InputStream create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().post("/api/hook", data, null);
    }

    public InputStream delete(JSONObject data) throws IOException, JSONException {
        return this.application.connect().post("/api/removehook", data, null);
    }

}

