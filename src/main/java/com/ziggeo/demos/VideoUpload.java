package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;

import java.io.File;

class VideoUpload {

    public static void main(String[] args) throws Exception {
        Ziggeo ziggeo = new Ziggeo(args[0], args[1], "");
        JSONObject created = ziggeo.videos().create(new JSONObject(), new File(args[2]));
        System.out.println(created);
    }

}

