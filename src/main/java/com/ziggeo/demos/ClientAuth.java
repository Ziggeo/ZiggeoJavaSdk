package com.ziggeo.demos;

import org.json.*;
import com.ziggeo.*;

public class ClientAuth {

	public static void main(String[] args) throws Exception {
		Ziggeo ziggeo = new Ziggeo(args[0], args[1], args[2]);
		System.out.println(ziggeo.auth().generate(new JSONObject("{\"grants\":{\"read\":{\"all\":true}}}")));
	}

}
