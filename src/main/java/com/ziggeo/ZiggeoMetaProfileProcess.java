package com.ziggeo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ZiggeoMetaProfileProcess {

    private Ziggeo application;

    public ZiggeoMetaProfileProcess(Ziggeo application) {
        this.application = application;
    }

    public JSONArray index(String metaTokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSONArray("/v1/metaprofiles/" + metaTokenOrKey + "/process", null);
    }

    public JSONObject get(String metaTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().getJSON("/v1/metaprofiles/" + metaTokenOrKey + "/process/" + tokenOrKey + "", null);
    }

    public InputStream delete(String metaTokenOrKey, String tokenOrKey) throws IOException, JSONException {
        return this.application.connect().delete("/v1/metaprofiles/" + metaTokenOrKey + "/process/" + tokenOrKey + "", null);
    }

    @Deprecated
    public JSONObject create_video_analysis_process(String metaTokenOrKey) throws IOException, JSONException {
        return createVideoAnalysisProcess(metaTokenOrKey);
    }

    public JSONObject createVideoAnalysisProcess(String metaTokenOrKey) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/metaprofiles/" + metaTokenOrKey + "/process/analysis", null, null);
    }

    @Deprecated
    public JSONObject create_audio_transcription_process(String metaTokenOrKey) throws IOException, JSONException {
        return createAudioTranscriptionProcess(metaTokenOrKey);
    }

    public JSONObject createAudioTranscriptionProcess(String metaTokenOrKey) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/metaprofiles/" + metaTokenOrKey + "/process/transcription", null, null);
    }

    @Deprecated
    public JSONObject create_nsfw_process(String metaTokenOrKey, JSONObject data) throws IOException, JSONException {
        return createNsfwProcess(metaTokenOrKey, data);
    }

    public JSONObject createNsfwProcess(String metaTokenOrKey, JSONObject data) throws IOException, JSONException {
        return this.application.connect().postJSON("/v1/metaprofiles/" + metaTokenOrKey + "/process/nsfw", data, null);
    }

}

