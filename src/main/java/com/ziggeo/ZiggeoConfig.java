package com.ziggeo;

import java.util.*;

public class ZiggeoConfig {
	
	public boolean local = false;
	public String server_api_url = "https://srvapi.ziggeo.com";
    public Map<String, String> regions;

    public ZiggeoConfig() {
        regions = new HashMap<String, String>();
                    regions.put("r1", "https://srvapi-eu-west-1.ziggeo.com");
            }

}
