package com.vaka.epam.homework;

import com.vaka.epam.homework.week1.RSA;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iaroslav on 11/4/2016.
 */
public class RSATest {
    @Test
    public void testEncrypt() throws Exception {
        RSA rsa = new RSA();
        String message = "Hello World!";
        String coded = rsa.encrypt(message);
        Assert.assertNotEquals(message, coded);
    }

    @Test
    public void testDecrypt() throws Exception {
        RSA rsa = new RSA();
        String message = "Hello!";

        String encrypted = rsa.encrypt(message);
        Assert.assertNotEquals(message, encrypted);

        String decrypted = rsa.decrypt(encrypted);
        Assert.assertEquals(message, decrypted);
    }
}
