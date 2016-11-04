package com.vaka.epam.homework;

import com.vaka.epam.homework.week1.Solution;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Suite;

/**
 * Created by Iaroslav on 10/29/2016.
 */
public class SolutionTest {
    @Test
    public void testBitsQuantity() throws Exception {
        Assert.assertEquals(Long.SIZE, Solution.getBitsQuantity(4365L));
        Assert.assertEquals(Integer.SIZE, Solution.getBitsQuantity(3123));
        Assert.assertEquals(Short.SIZE, Solution.getBitsQuantity((short) 2134));
        Assert.assertEquals(Byte.SIZE, Solution.getBitsQuantity((byte) 42));
    }

    @Test
    public void testChangeBit() throws Exception {
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
        x = 0;
        y = 12;
        Assert.assertEquals(x * y, Solution.multiplyByKaratsuba(x, y));
    }

    @Test
    public void testEuclideanAlgorithm() throws Exception {
        int multiplier = (int) (Math.random() * 10 + 1);
        long a = ((long) (Math.random() * Integer.MAX_VALUE)) * multiplier;
        long b = ((long) (Math.random() * Short.MAX_VALUE)) * multiplier;
        long euclideanGcd = Solution.euclideanAlgorithm(a, b);
        long gcd = -1, min = Math.min(a, b), max = Math.max(a, b);
        for (long i = euclideanGcd; i <= min; i++) {
            if (max % i == 0 && min % i == 0) gcd = i;
        }
        Assert.assertEquals(gcd, euclideanGcd);
        Assert.assertEquals(0, Solution.euclideanAlgorithm((0), 0));
        Assert.assertEquals(0, Solution.euclideanAlgorithm((0), 0));

    }

}

