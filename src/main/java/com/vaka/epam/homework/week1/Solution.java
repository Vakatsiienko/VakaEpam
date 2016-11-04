package com.vaka.epam.homework.week1;


import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Iaroslav on 10/29/2016.
 */
public class Solution {

    // Задание 1.
    // Используя побитовые операции подсчитать количество занимаемых бит для byte, short, int, long
    private static int countBits(long number) {
        int bits = 1;
        while (number != 0) {
            number >>= 1;
            bits++;
        }
        return bits;
    }

    public static int getBitsQuantity(byte number) {
        return countBits(Byte.MAX_VALUE);
    }

    public static int getBitsQuantity(short number) {
        return countBits(Short.MAX_VALUE);
    }

    public static int getBitsQuantity(int number) {
        return countBits(Integer.MAX_VALUE);
    }

    public static int getBitsQuantity(long number) {
        return countBits(Long.MAX_VALUE);
    }


    // Задание 2.
    // Используя побитовые операции изменить в переменной типа int бит с номером pos на единицу, на 0.

    /**
     * @param number - number in the decimal numeral system
     * @param pos    - position of bit, start from 0 as first right bit
     * @param bool   - true for 0 and false for 1
     * @return return number in the dns with changed bit
     */
    public static int changeBit(int number, int pos, boolean bool) {
        return bool ? number ^ (1 << pos) : number | (1 << pos);
    }

    // Задание 3.
    // Реализовать умножение Карацубы.
    public static long multiplyByKaratsuba(long x, long y) {

        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());

        n = (int) Math.pow(10, ((n + 1) / 2));

        long x1 = x / n;
        long x2 = x - x1 * n;

        long y1 = y / n;
        long y2 = y - y1 * n;

        long x1y1 = x1 * y1 * n * n;
        long x2y2 = x2 * y2;
        long x1x2y1y2 = ((x1 + x2) * (y1 + y2) - x2y2 - y1 * x1) * n;
        return x1y1 + x2y2 + x1x2y1y2;
    }

    //            Задание 4.
//    Используя побитовые операции реализовать алгоритм Евклида нахождения НОД.
    public static long euclideanAlgorithm(long x, long y) {
        long gcd = 1L;
        long tmp;
        // Check incoming parameters
        if (x == 0L)
            return y;
        if (y == 0L)
            return x;
        if (x == y)
            return x;
        if (x == 1L || y == 1L)
            return 1L;
        // x and y even
        if ((x & 1) == 0 && (y & 1) == 0) return euclideanAlgorithm(x >> 1, y >> 1) << 1;

            // x is even, y is odd
        else if ((x & 1) == 0) return euclideanAlgorithm(x >> 1, y);

            // x is odd, y is even
        else if ((y & 1) == 0) return euclideanAlgorithm(x, y >> 1);

            // x and y odd, x >= y
        else if (x >= y) return euclideanAlgorithm((x - y) >> 1, y);

            // x and y odd, x < y
        else return euclideanAlgorithm(x, (y - x) >> 1);
    }

    //    Задание 5.
    //    Реализовать алгоритм RSA.
    public static void encryptRSA(Object object) {
        long firstPrime = getRandomPrime(Integer.MAX_VALUE);
        long secondPrime = getRandomPrime(Integer.MAX_VALUE);
        long n = multiplyByKaratsuba(firstPrime, secondPrime);
        long fN = multiplyByKaratsuba(firstPrime - 1, secondPrime - 1);
        long e = 3;
        while (euclideanAlgorithm(fN, e) == 0) {
            e += 2;
        }
        long d = (fN * 2L + 1L) / e;
        System.out.println(d);
    }

    private static long getRandomPrime(int maxValue){
        //add SecureRandom holder
        return Primes.nextPrime(new SecureRandom().nextInt(maxValue));
    }


    public static void main(String[] args) {
        RSA rsa = new RSA();
        String encr = rsa.encrypt("nyyyy!");
        String decr = rsa.decrypt(encr);
        System.out.println(decr);
    }


}
