package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;

class ApplicationStats {

    public static void main(String args[]) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
        JSONObject stats = ziggeo.application().getStats(null);
        System.out.println(stats);
    }

}

