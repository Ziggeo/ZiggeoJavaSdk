package com.ziggeo.demos;

import org.json.*;
import com.ziggeo.*;

class ApplicationStats {

    public static void main(String args[]) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
		JSONObject stats = ziggeo.application().get_stats(null);
		System.out.println(stats);
    }

}

