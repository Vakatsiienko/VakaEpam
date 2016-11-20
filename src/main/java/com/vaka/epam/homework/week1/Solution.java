package com.vaka.epam.homework.week1;


/**
 * Created by Iaroslav on 10/29/2016.
 */
public class Solution {
    private Solution() {
    }

    // Задание 1.
    // Используя побитовые операции подсчитать количество занимаемых бит для byte, short, int, long
    private static int countBits(long number) {
        long some = number;
        int bits = 1;
        while (some != 0) {
            some = some >> 1;
            bits++;
        }
        return bits;
    }

    public static int getByteBitsQuantity() {
        return countBits(Byte.MAX_VALUE);
    }

    public static int getShortBitsQuantity() {
        return countBits(Short.MAX_VALUE);
    }

    public static int getIntegerBitsQuantity() {
        return countBits(Integer.MAX_VALUE);
    }

    public static int getLongBitsQuantity() {
        return countBits(Long.MAX_VALUE);
    }


    // Задание 2.
    // Используя побитовые операции изменить в переменной типа int бит с номером pos на единицу, на 0.

    /**
     * @param number - number in the decimal numeral system
     * @param pos    - position of bit, start from 0 as first right bit
     * @param bool   - true for 0 and false for 1
     * @return return number in the dns with changed bit
     * @throws IllegalArgumentException pos cannot be lower than 0
     */
    public static int changeBit(int number, int pos, boolean bool) {
        if (pos < 0  || pos > Integer.SIZE)
            throw new IllegalArgumentException("pos cannot be lower than 0 or greater than Integer.SIZE");
        return bool ? number ^ (1 << pos) : number | (1 << pos);
    }

    // Задание 3.
    // Реализовать умножение Карацубы.
    public static long multiplyByKaratsuba(long x, long y) {

        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());

        n = (int) Math.pow(10, (n + 1) / 2);

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
        // Check incoming parameters
        if (x == 0L)
            return x;
        if (y == 0L)
            return y;
        if (x == y)
            return x;
        if (x == 1L || y == 1L)
            return 1L;
        // x and y even
        if ((x & 1) == 0 && (y & 1) == 0)
            return euclideanAlgorithm(x >> 1, y >> 1) << 1;

            // x is even, y is odd
        else if ((x & 1) == 0)
            return euclideanAlgorithm(x >> 1, y);

            // x is odd, y is even
        else if ((y & 1) == 0)
            return euclideanAlgorithm(x, y >> 1);

            // x and y odd, x >= y
        else if (x >= y)
            return euclideanAlgorithm((x - y) >> 1, y);

            // x and y odd, x < y
        else return euclideanAlgorithm(x, (y - x) >> 1);
    }


}
