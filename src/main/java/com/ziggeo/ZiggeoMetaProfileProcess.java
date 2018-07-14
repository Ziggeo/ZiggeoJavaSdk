package com.ziggeo;

import org.json.*;
import java.io.*;

public class ZiggeoMetaProfileProcess {

    private Ziggeo application;

    public ZiggeoMetaProfileProcess(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String meta_token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/metaprofiles/" + meta_token_or_key + "/process", null);
    }

    public JSONObject get(String meta_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().getJSON("/metaprofiles/" + meta_token_or_key + "/process/" + token_or_key + "", null);
    }

    public InputStream delete(String meta_token_or_key, String token_or_key) throws IOException, JSONException {
        return this.application.connect().delete("/metaprofiles/" + meta_token_or_key + "/process/" + token_or_key + "", null);
    }

    public JSONObject create_video_analysis_process(String meta_token_or_key) throws IOException, JSONException {
        return this.application.connect().postJSON("/metaprofiles/" + meta_token_or_key + "/process/analysis", null, null);
    }

    public JSONObject create_audio_transcription_process(String meta_token_or_key) throws IOException, JSONException {
        return this.application.connect().postJSON("/metaprofiles/" + meta_token_or_key + "/process/transcription", null, null);
    }

    public JSONObject create_nsfw_process(String meta_token_or_key, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/metaprofiles/" + meta_token_or_key + "/process/nsfw", data, null);
    }

}

