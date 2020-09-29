package com.ziggeo;

import java.util.Map;

public class Ziggeo {

    private final String token;
    private final String privateKey;
    private final String encryptionKey;
    private final ZiggeoConfig configObj;
    private ZiggeoConnect connectObj;
    private ZiggeoConnect apiConnectObj;
    private ZiggeoConnect cdnConnectObj;
    private ZiggeoAuth authObj = null;
    private ZiggeoVideos videosObj = null;
    private ZiggeoStreams streamsObj = null;
    private ZiggeoAuthtokens authtokensObj = null;
    private ZiggeoApplication applicationObj = null;
    private ZiggeoEffectProfiles effectProfilesObj = null;
    private ZiggeoEffectProfileProcess effectProfileProcessObj = null;
    private ZiggeoMetaProfiles metaProfilesObj = null;
    private ZiggeoMetaProfileProcess metaProfileProcessObj = null;
    private ZiggeoWebhooks webhooksObj = null;
    private ZiggeoAnalytics analyticsObj = null;

    public Ziggeo(String token, String privateKey, String encryptionKey) {
        this.token = token;
        this.privateKey = privateKey;
        this.encryptionKey = encryptionKey;
        this.configObj = new ZiggeoConfig();

        String serverApiUrl = config().SERVER_API_URL;
        for (Map.Entry<String, String> entry : config().getRegions().entrySet())
            if (this.token.startsWith(entry.getKey()))
                serverApiUrl = entry.getValue();
        this.connectObj = new ZiggeoConnect(this, serverApiUrl, configObj);

        String apiUrl = config().API_URL;
        for (Map.Entry<String, String> entry : config().getApiRegions().entrySet())
            if (this.token.startsWith(entry.getKey()))
                apiUrl = entry.getValue();
        this.apiConnectObj = new ZiggeoConnect(this, apiUrl, configObj);

        String cdnUrl = this.config().CDN_URL;
        for (Map.Entry<String, String> entry : config().getCdnRegions().entrySet())
            if (this.token.startsWith(entry.getKey()))
                cdnUrl = entry.getValue();
        this.cdnConnectObj = new ZiggeoConnect(this, cdnUrl, configObj);
    }


    public String getToken() {
        return token;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public ZiggeoConfig config() {
        return this.configObj;
    }

    public ZiggeoConnect connect() {
        if (this.connectObj == null) {
            String serverApiUrl = this.config().SERVER_API_URL;
            for (Map.Entry<String, String> entry : this.config().getRegions().entrySet()) {
                if (this.token.startsWith(entry.getKey())) {
                    serverApiUrl = entry.getValue();
                }
            }
            this.connectObj = new ZiggeoConnect(this, serverApiUrl, this.configObj);
        }
        return this.connectObj;
    }

    public ZiggeoConnect apiConnect() {
        if (this.apiConnectObj == null) {
            String apiUrl = this.config().API_URL;
            for (Map.Entry<String, String> entry : this.config().getApiRegions().entrySet()) {
                if (this.token.startsWith(entry.getKey())) {
                    apiUrl = entry.getValue();
                }
            }
            this.apiConnectObj = new ZiggeoConnect(this, apiUrl);
        }

        return this.apiConnectObj;
    }

    public ZiggeoConnect cdnConnect() {
        if (this.cdnConnectObj == null) {
            String cdnUrl = this.config().CDN_URL;
            for (Map.Entry<String, String> entry : this.config().getCdnRegions().entrySet()) {
                if (this.token.startsWith(entry.getKey())) {
                    cdnUrl = entry.getValue();
                }
            }
            this.cdnConnectObj = new ZiggeoConnect(this, cdnUrl);
        }
        return this.cdnConnectObj;
    }

    public ZiggeoAuth auth() {
        if (this.authObj == null)
            this.authObj = new ZiggeoAuth(this);
        return this.authObj;
    }

    public ZiggeoVideos videos() {
        if (this.videosObj == null)
            this.videosObj = new ZiggeoVideos(this);
        return this.videosObj;
    }

    public ZiggeoStreams streams() {
        if (this.streamsObj == null)
            this.streamsObj = new ZiggeoStreams(this);
        return this.streamsObj;
    }

    public ZiggeoAuthtokens authtokens() {
        if (this.authtokensObj == null)
            this.authtokensObj = new ZiggeoAuthtokens(this);
        return this.authtokensObj;
    }

    public ZiggeoApplication application() {
        if (this.applicationObj == null)
            this.applicationObj = new ZiggeoApplication(this);
        return this.applicationObj;
    }

    public ZiggeoEffectProfiles effectProfiles() {
        if (this.effectProfilesObj == null)
            this.effectProfilesObj = new ZiggeoEffectProfiles(this);
        return this.effectProfilesObj;
    }

    public ZiggeoEffectProfileProcess effectProfileProcess() {
        if (this.effectProfileProcessObj == null)
            this.effectProfileProcessObj = new ZiggeoEffectProfileProcess(this);
        return this.effectProfileProcessObj;
    }

    public ZiggeoMetaProfiles metaProfiles() {
        if (this.metaProfilesObj == null)
            this.metaProfilesObj = new ZiggeoMetaProfiles(this);
        return this.metaProfilesObj;
    }

    public ZiggeoMetaProfileProcess metaProfileProcess() {
        if (this.metaProfileProcessObj == null)
            this.metaProfileProcessObj = new ZiggeoMetaProfileProcess(this);
        return this.metaProfileProcessObj;
    }

    public ZiggeoWebhooks webhooks() {
        if (this.webhooksObj == null)
            this.webhooksObj = new ZiggeoWebhooks(this);
        return this.webhooksObj;
    }

    public ZiggeoAnalytics analytics() {
        if (this.analyticsObj == null)
            this.analyticsObj = new ZiggeoAnalytics(this);
        return this.analyticsObj;
    }

}