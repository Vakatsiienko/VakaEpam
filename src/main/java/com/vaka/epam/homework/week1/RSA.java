package com.vaka.epam.homework.week1;

import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Iaroslav on 11/3/2016.
 */
public class RSA {
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
        generateKeys();
    }

    private long getRandomPrime(int maxValue) {
        //add SecureRandom holder
        return Primes.nextPrime(random.nextInt(maxValue));
    }


    public void generateKeys() {
        Long firstPrime = getRandomPrime(Integer.MAX_VALUE);
        Long secondPrime = getRandomPrime(Integer.MAX_VALUE);
        n = Solution.multiplyByKaratsuba(firstPrime, secondPrime);
        /*
      multiply(firstPrime -1, secondPrime -1)
     */
        Long fiN = Solution.multiplyByKaratsuba(firstPrime - 1, secondPrime - 1);
        e = 3L;
        while (Solution.euclideanAlgorithm(fiN, e) > 1) {
            e += 2;
        }
        d = new BigInteger(e.toString()).modInverse(new BigInteger(fiN.toString())).longValue();
    }

    public String encrypt(String message) {
        return new BigInteger(message.getBytes()).modPow(new BigInteger(e.toString()), new BigInteger(n.toString())).toString();
    }

    public String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(new BigInteger(d.toString()), new BigInteger(n.toString())).toByteArray());
    }

}
