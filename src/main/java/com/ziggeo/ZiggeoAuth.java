package com.ziggeo;

import org.json.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class ZiggeoAuth {

	private Ziggeo application;

	public ZiggeoAuth(Ziggeo application) {
		this.application = application;
	}

	public String generate(JSONObject data) throws JSONException,
			NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException {
		data.put("application_token", this.application.token);
		data.put("nonce", this.generate_nonce());
		return this.encrypt(data.toString());
	}

	private String generate_nonce() {
		return System.currentTimeMillis() + ""
				+ Math.floor((Math.random() * (Math.pow(2, 32) - 1)));
	}

	private String encrypt(String plaintext) throws NoSuchAlgorithmException,
			InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(this.application.encryption_key.getBytes());
		byte[] hashed_key = md.digest();
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5padding");
		SecretKeySpec skeySpec = new SecretKeySpec(hashed_key, "AES");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec,
                            new IvParameterSpec(new byte[16]));
		byte[] encrypted = cipher.doFinal(plaintext.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}

}
