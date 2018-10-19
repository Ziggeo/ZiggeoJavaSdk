package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;

public class ClientAuth {

    public static void main(String[] args) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], args[2]);
        System.out.println(ziggeo.auth().generate(new JSONObject("{\"grants\":{\"read\":{\"all\":true}}}")));
    }

}
