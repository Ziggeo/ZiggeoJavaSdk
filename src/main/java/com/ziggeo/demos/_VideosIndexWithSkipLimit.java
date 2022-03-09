package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONArray;
import org.json.JSONObject;
/*
	This demos shows how to use index call to find the videos as you would in pagination - by skipping some and showing limited numbers. For example to get the next 10 videos on page 2.

	Parameters you need to pass:
	1. appToken
	2. privateKey
	3. skip
	4. limit
*/
public class _VideosIndexWithSkipLimit {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];
		String skip = args[2];
		String limit = args[2];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		JSONArray videos = ziggeo.videos().index(new JSONObject("{\"skip\":" + Integer.parseInt(skip) + ", \"limit\":" + Integer.parseInt(limit) + "}"));

		System.out.println(videos.length());
	}
}