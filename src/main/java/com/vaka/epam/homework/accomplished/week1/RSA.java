package com.vaka.epam.homework.accomplished.week1;

import lombok.Getter;
import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Iaroslav on 11/3/2016.
 */
@Getter
public class RSA {

    private boolean keysGenerated;
    /**
     * Multiplication of first and second prime
     */
    private Long n;
    /**
     * Small number that doesn't have common denominators with FiN
     */
    private Long e;
    /**
     * (2 * FiN + 1) / e
     */
    private Long d;

    private SecureRandom random;

    public RSA() {
        random = new SecureRandom();
    }

    public void generateKeys() {
        Long firstPrime = (long) Primes.nextPrime(random.nextInt(Integer.MAX_VALUE));
        Long secondPrime = (long) Primes.nextPrime(random.nextInt(Integer.MAX_VALUE));
        n = Solution.multiplyByKaratsuba(firstPrime, secondPrime);
        Long fiN = Solution.multiplyByKaratsuba(firstPrime - 1, secondPrime - 1);
        e = 3L;
        while (Solution.euclideanAlgorithm(fiN, e) > 1) {
            e += 2;
        }
        d = new BigInteger(e.toString()).modInverse(new BigInteger(fiN.toString())).longValue();
        keysGenerated = true;

    }

    public String encrypt(String message) {
        if (keysGenerated)
            return new BigInteger(message.getBytes()).modPow(new BigInteger(e.toString()), new BigInteger(n.toString())).toString();
        else
            throw new IllegalStateException("Public and private keys are not generated, you should call generateKeys() at first");
    }

    public String decrypt(String message) {
        if (keysGenerated)
            return new String((new BigInteger(message)).modPow(new BigInteger(d.toString()), new BigInteger(n.toString())).toByteArray());
        else
            throw new IllegalStateException("Public and private keys are not generated, you should set keys at first");
    }

    /**
     * @param n multiplication of first and second prime
     * @param e exponent - Small number that doesn't have common denominators with FiN
     * @param d e modInverse(fiN)
     */
    public void setKeys(long n, long e, long d) {
        this.n = n;
        this.e = e;
        this.d = d;
        keysGenerated = true;
        if (!checkKeys()) {
            keysGenerated = false;
            throw new IllegalArgumentException("Wrong keys");
        }
    }

    public boolean checkKeys() {
        String hello = "hello";
        String encryptedStr = this.encrypt(hello);
        if (hello.equals(encryptedStr))
            return false;
        String decryptedStr = this.decrypt(encryptedStr);
        return hello.equals(decryptedStr);
    }

}
