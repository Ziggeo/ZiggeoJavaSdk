package com.ziggeo.demos;

import org.json.*;
import com.ziggeo.*;

class VideoListLimit {

    public static void main(String args[]) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
		JSONArray videos = ziggeo.videos().index(new JSONObject("{\"skip\":" + Integer.parseInt(args[2]) + ", \"limit\":" + Integer.parseInt(args[3])+ "}"));
		System.out.println(videos.length());
    }

}

