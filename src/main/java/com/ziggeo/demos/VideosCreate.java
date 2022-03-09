package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;
import java.io.File;
/*
	This script will show you how you can create a video by uploading a file

	Parameters you need to pass:
	1. appToken
	2. privateKey
	3. filePath
*/
public class VideosCreate {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];
		String filePath = args[2];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		JSONObject result = ziggeo.videos().create(new JSONObject(), new File(filePath));

		System.out.println(result);
	}
}