
package com.ziggeo;

import java.util.*;

public class ZiggeoConfig {
	
	public String server_api_url = "https://srvapi.ziggeo.com";
    public String api_url = "https://api-us-east-1.ziggeo.com";
    public Map<String, String> regions;
    public Map<String, String> api_regions;

    public ZiggeoConfig() {
        regions = new HashMap<String, String>();
                    regions.put("r1", "https://srvapi-eu-west-1.ziggeo.com");
                api_regions = new HashMap<String, String>();
                    api_regions.put("r1", "https://api-eu-west-1.ziggeo.com");
            }

}
