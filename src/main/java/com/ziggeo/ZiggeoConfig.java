package com.ziggeo;

import java.util.HashMap;
import java.util.Map;

public class ZiggeoConfig {

    public String server_api_url = "https://srvapi.ziggeo.com";
    public String api_url = "https://api-us-east-1.ziggeo.com";
    public Map<String, String> regions;
    public Map<String, String> api_regions;
    private int connectionTimeout = 60 * 1000;
    private int socketTimeout = 60 * 1000;

    public ZiggeoConfig() {
        regions = new HashMap<String, String>();
        regions.put("r1", "https://srvapi-eu-west-1.ziggeo.com");
        api_regions = new HashMap<String, String>();
        api_regions.put("r1", "https://api-eu-west-1.ziggeo.com");
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
}
