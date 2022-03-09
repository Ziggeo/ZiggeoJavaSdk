package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;
/*
	This script will show you how you can get the number of all videos in your application

	Parameters you need to pass:
	1. appToken
	2. privateKey
*/
public class VideosCount {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		JSONObject videoCount = ziggeo.videos().count(null);

		System.out.println(videoCount.getInt("count"));
	}
}