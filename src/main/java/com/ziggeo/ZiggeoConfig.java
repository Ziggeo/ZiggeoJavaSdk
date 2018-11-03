
package com.ziggeo;

import java.util.HashMap;
import java.util.Map;

public class ZiggeoConfig {

    public final String SERVER_API_URL = "https://srvapi.ziggeo.com";
    public final String API_URL = "https://api-us-east-1.ziggeo.com";
    private Map<String, String> regions;
    private Map<String, String> apiRegions;
    private int connectionTimeout = 60 * 1000;
    private int socketTimeout = 60 * 1000;

    public ZiggeoConfig() {
        regions = new HashMap<String, String>();
                    regions.put("r1", "https://srvapi-eu-west-1.ziggeo.com");
                apiRegions = new HashMap<String, String>();
                    apiRegions.put("r1", "https://api-eu-west-1.ziggeo.com");
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

}
