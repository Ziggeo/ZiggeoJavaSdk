package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoEffectProfiles {

    private Ziggeo application;

    public ZiggeoEffectProfiles(Ziggeo application) {
        this.application = application;
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/effects/", data, null);
    }

    public JSONObject index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/effects/", data);
    }

    public JSONObject get(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/effects/" + token_or_key + "", null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/effects/" + token_or_key + "", null);
    }

}

