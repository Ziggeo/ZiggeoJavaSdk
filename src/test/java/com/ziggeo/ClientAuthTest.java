package com.ziggeo;

import org.json.*;
import javax.crypto.*;
import java.security.*;
import com.ziggeo.Ziggeo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.isA;

public class ClientAuthTest {

    protected Ziggeo apiClient;

    @Before
    public void setUp() {
        apiClient = new Ziggeo("token", "private_key", "encryption_key");
    }

    @Test
    public void testGenerate() throws
        NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
        InvalidAlgorithmParameterException, IllegalBlockSizeException,
        BadPaddingException {
        JSONObject data = new JSONObject("{\"key\": \"value\"}");
        assertThat(apiClient.auth().generate(data), isA(String.class));
    }
}
