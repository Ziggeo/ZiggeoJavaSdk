package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;
/*
	This script will allow you to get the stats of your application

	Parameters you need to pass:
	1. appToken
	2. privateKey
*/
public class ApplicationGetStats {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		JSONObject stats = ziggeo.application().getStats(null);

		System.out.println(stats);
	}
}