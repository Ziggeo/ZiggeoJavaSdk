package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONArray;
import org.json.JSONObject;
/*
	This demos shows how to use index call to find the videos as you would in pagination - by skipping some and showing limited numbers. For example to get the next 10 videos on page 2.

	Parameters you need to pass:
	1. appToken
	2. privateKey
*/
public class VideosIndex {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");

		JSONArray videos = ziggeo.videos().index(new JSONObject("{}"));

		System.out.println(videos);
	}
}