package com.ziggeo.demos;

import org.json.*;
import com.ziggeo.*;

class VideoCount {

    public static void main(String args[]) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
		JSONObject videoCount = ziggeo.videos().count(null);
		System.out.println(videoCount.getInt("count"));
    }

}

