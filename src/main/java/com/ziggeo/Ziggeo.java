package com.ziggeo;

public class Ziggeo {

    public String token;
    public String private_key;
    public String encryption_key;
    private ZiggeoConfig configObj;
    private ZiggeoConnect connectObj;
    private ZiggeoAuth authObj = null;
    private ZiggeoVideos videosObj = null;
    private ZiggeoStreams streamsObj = null;
    private ZiggeoAuthtokens authtokensObj = null;
    private ZiggeoEffectProfiles effectProfilesObj = null;
    private ZiggeoEffectProfileProcess effectProfileProcessObj = null;
    private ZiggeoMetaProfiles metaProfilesObj = null;
    private ZiggeoMetaProfileProcess metaProfileProcessObj = null;
    private ZiggeoWebhooks webhooksObj = null;
    private ZiggeoAnalytics analyticsObj = null;

    public Ziggeo(String token, String private_key, String encryption_key) {
        this.token = token;
        this.private_key = private_key;
        this.encryption_key = encryption_key;
        this.configObj = new ZiggeoConfig();
        this.connectObj = new ZiggeoConnect(this);
    }

    public ZiggeoConfig config() {
        return this.configObj;
    }

    public ZiggeoConnect connect() {
        return this.connectObj;
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