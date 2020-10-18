
package com.ziggeo;

import java.util.HashMap;
import java.util.Map;

public class ZiggeoConfig {

    public final String SERVER_API_URL = "https://srvapi.ziggeo.com";
    public final String API_URL = "https://api-us-east-1.ziggeo.com";
    public final String CDN_URL = "https://video-cdn.ziggeo.com";
    private final Map<String, String> cdnRegions;
    private final Map<String, String> resilienceOnFail;
    private final Map<String, String> info;
    private int resilienceFactor = 5;
    private final Map<String, String> regions;
    private final Map<String, String> apiRegions;
    private int connectionTimeout = 60 * 1000;
    private int socketTimeout = 60 * 1000;

    public ZiggeoConfig() {
        regions = new HashMap<>();
                    regions.put("r1", "https://srvapi-eu-west-1.ziggeo.com");
                apiRegions = new HashMap<>();
                    apiRegions.put("r1", "https://api-eu-west-1.ziggeo.com");
                cdnRegions = new HashMap<>();
                    cdnRegions.put("r1", "https://video-cdn-eu-west-1.ziggeo.com");
                resilienceOnFail = new HashMap<>();
        resilienceOnFail.put("error", "Too many failed attempts");
        info = new HashMap<>();
        info.put("progress_show", "no");
        info.put("progress_multiplier", "1048576");
        info.put("progress_desc", "mb");
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public Map<String, String> getRegions() {
        return regions;
    }

    public Map<String, String> getApiRegions() {
        return apiRegions;
    }

    public Map<String, String> getCdnRegions() {
        return cdnRegions;
    }

    public Map<String, String> getResilienceOnFail() {
        return resilienceOnFail;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public int getResilienceFactor() {
        return resilienceFactor;
    }
}
