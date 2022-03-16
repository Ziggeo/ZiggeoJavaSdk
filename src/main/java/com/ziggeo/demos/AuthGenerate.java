package com.ziggeo.demos;

import com.ziggeo.Ziggeo;
import org.json.JSONArray;
import org.json.JSONObject;

/*
	This script will allow you to see how to create client side auth tokens

	docs: https://ziggeo.com/docs/api/authorization-tokens/

	Parameters you need to pass:
	1. appToken
	2. privateKey
	3. encryptionKey
*/
public class AuthGenerate {

	public static void main(String[] args) throws Exception {

		String appToken = args[0];
		String privateKey = args[1];
		String encryptionKey = args[2];

		Ziggeo ziggeo = new Ziggeo(appToken, privateKey, encryptionKey);

		JSONObject arguments = new JSONObject("{\"grants\":{\"read\":{\"all\":true}}}");

		String result = ziggeo.auth().generate(arguments);

		System.out.println(result);
	}
}