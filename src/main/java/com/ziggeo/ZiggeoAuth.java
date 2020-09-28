package com.ziggeo;

import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class ZiggeoAuth {

    final private static char[] hexArray = "0123456789abcdef".toCharArray();
    private final Ziggeo application;

    public ZiggeoAuth(Ziggeo application) {
        this.application = application;
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public String generate(JSONObject data) throws JSONException,
            NoSuchAlgorithmException, InvalidKeyException,
            NoSuchPaddingException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException {
        data.put("application_token", this.application.getToken());
        data.put("nonce", this.generateNonce());
        return this.encrypt(data.toString());
    }

    private String generateNonce() {
        return System.currentTimeMillis() + ""
                + Math.floor((Math.random() * (Math.pow(2, 32) - 1)));
    }

    private String encrypt(String plaintext) throws NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(this.application.getEncryptionKey().getBytes());
        SecretKeySpec skeySpec = new SecretKeySpec(bytesToHex(md.digest()).getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5padding");
        byte[] iv = new byte[8];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(iv);
        String ivx = bytesToHex(iv);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(ivx.getBytes()));
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return ivx + bytesToHex(encrypted);
    }

}