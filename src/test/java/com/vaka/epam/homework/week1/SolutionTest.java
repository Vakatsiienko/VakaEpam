package com.vaka.epam.homework.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iaroslav on 10/29/2016.
 */
public class SolutionTest {
    @Test
    public void testBitsQuantity() throws Exception {
        Assert.assertEquals(Long.SIZE, Solution.getLongBitsQuantity());
        Assert.assertEquals(Integer.SIZE, Solution.getIntegerBitsQuantity());
        Assert.assertEquals(Short.SIZE, Solution.getShortBitsQuantity());
        Assert.assertEquals(Byte.SIZE, Solution.getByteBitsQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeBit() throws Exception {
        Assert.assertEquals(2435, Solution.changeBit(3, -2, true));
        Assert.assertEquals(14, Solution.changeBit(10, 2, false));
        Assert.assertEquals(1, Solution.changeBit(0, 0, false));
        Assert.assertEquals(0, Solution.changeBit(1, 0, true));
        Assert.assertEquals(2147418111, Solution.changeBit(Integer.MAX_VALUE, 16, true));
        Assert.assertEquals(-2147418112, Solution.changeBit(Integer.MIN_VALUE, 16, false));
    }

    @Test
    public void testMultiplyByKaratsuba() throws Exception {
        long x = (long) (Math.random() * Integer.MAX_VALUE);
        long y = (long) (Math.random() * Integer.MAX_VALUE);
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));

        x = (long) (Math.random() * Integer.MAX_VALUE);
        y = (long) (Math.random() * Integer.MIN_VALUE);
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));

        x = (long) (Math.random() * Integer.MIN_VALUE);
        y = (long) (Math.random() * Integer.MIN_VALUE);
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));

        x = 0;
        y = 12;
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));

        x = 0;
        y = 0;
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));
        x = -110;
        y = 0;
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));
    }

    @Test
    public void testEuclideanAlgorithm() throws Exception {
        Assert.assertEquals(0, Solution.euclideanAlgorithm(0, 0));
        Assert.assertEquals(1, Solution.euclideanAlgorithm(1, 10));
        Assert.assertEquals(0, Solution.euclideanAlgorithm(134, 0));
        Assert.assertEquals(0, Solution.euclideanAlgorithm(0, 5474));
        Assert.assertEquals(9, Solution.euclideanAlgorithm(123456789, 987654321));

        int multiplier = 42;
        long a = ((long) Integer.MAX_VALUE) * multiplier;
        long b = ((long) Short.MAX_VALUE) * multiplier;
        long euclideanGcd = Solution.euclideanAlgorithm(a, b);
        long gcd = -1, min = Math.min(a, b), max = Math.max(a, b);
        for (long i = euclideanGcd; i <= min; i++) {
            if (max % i == 0 && min % i == 0) gcd = i;
        }

        Assert.assertEquals(gcd, euclideanGcd);

    }

}

