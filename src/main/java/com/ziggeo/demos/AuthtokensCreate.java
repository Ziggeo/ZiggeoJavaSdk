package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONObject;
/*
	This script will show you how to create server side auth tokens

	docs: https://ziggeo.com/docs/api/authorization-tokens/

	Parameters you need to pass:
	1. appToken
	2. privateKey
*/
public class AuthtokensCreate {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, "");
		JSONObject result = ziggeo.authtokens().create(new JSONObject("{\"grants\":{\"read\":{\"all\":true}}}"));

		System.out.println(result.get("token"));
	}
}