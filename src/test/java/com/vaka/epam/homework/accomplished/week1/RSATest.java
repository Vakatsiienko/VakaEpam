package com.vaka.epam.homework.accomplished.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iaroslav on 11/4/2016.
 */
public class RSATest {
    @Test(expected = IllegalStateException.class)
    public void testEncrypt() throws Exception {
        RSA rsa = new RSA();
        String message = "Hello!";
        String encrypted = rsa.encrypt(message);
        rsa.generateKeys();
        encrypted = rsa.encrypt(message);
        Assert.assertNotEquals(message, encrypted);
    }

    @Test(expected = IllegalStateException.class)
    public void testDecrypt() throws Exception {
        RSA rsa = new RSA();
        String message = "Hello!";

        String encrypted = rsa.encrypt(message);
        rsa.generateKeys();

        encrypted = rsa.encrypt(message);

        Assert.assertNotEquals(message, encrypted);

        String decrypted = rsa.decrypt(encrypted);
        Assert.assertEquals(message, decrypted);
    }

    @Test
    public void testGenerateKeys() throws Exception {

        RSA rsa = new RSA();
        rsa.generateKeys();
        Assert.assertTrue(rsa.isKeysGenerated());
        long d = rsa.getD();
        long e = rsa.getE();
        long n = rsa.getN();
        Assert.assertNotEquals(0, d);
        Assert.assertNotEquals(0, e);
        Assert.assertNotEquals(0, n);
        Assert.assertTrue(rsa.checkKeys());
    }

    @Test(expected = IllegalStateException.class)
    public void testCheckKeys() throws Exception {
        RSA rsa = new RSA();
        Assert.assertEquals(false, rsa.checkKeys());
        rsa.setKeys(2947416405923174503L, 3, 1964944268305189627L);
        Assert.assertEquals(true, rsa.checkKeys());

        rsa.getClass().getDeclaredField("e").setLong(rsa, 2L);
        Assert.assertEquals(false, rsa.checkKeys());
        rsa.getClass().getDeclaredField("e").setLong(rsa, 3L);

        Assert.assertEquals(true, rsa.checkKeys());
        rsa.getClass().getDeclaredField("n").setLong(rsa, 2947416405923174504L);
        Assert.assertEquals(false, rsa.checkKeys());
        rsa.getClass().getDeclaredField("n").setLong(rsa, 2947416405923174503L);


        Assert.assertEquals(true, rsa.checkKeys());
        rsa.getClass().getDeclaredField("d").setLong(rsa, 1964944268305189628L);
        Assert.assertEquals(false, rsa.checkKeys());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetKeys() throws Exception {
        RSA rsa = new RSA();
        rsa.setKeys(2947416405923174503L, 3, 1964944268305189627L);
        Assert.assertEquals(true, rsa.checkKeys());
        rsa.setKeys(1345231345355436431L, 3, 1964944268305189627L);
        rsa.setKeys(2947416405923174503L, 4, 1964944268305189627L);
        rsa.setKeys(2947416405923174503L, 3, 4537412332323444212L);


    }
}
