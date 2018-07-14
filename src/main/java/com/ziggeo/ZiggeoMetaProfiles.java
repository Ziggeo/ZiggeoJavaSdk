package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoMetaProfiles {

    private Ziggeo application;

    public ZiggeoMetaProfiles(Ziggeo application) {
        this.application = application;
    }

    public JSONObject create(JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/metaprofiles/", data, null);
    }

    public JSONObject index(JSONObject data) throws IOException, JSONException {
        return this.application.connect().getJSON("/metaprofiles/", data);
    }

    public JSONObject get(String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/metaprofiles/" + token_or_key + "", null);
    }

    public InputStream delete(String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/metaprofiles/" + token_or_key + "", null);
    }

}

