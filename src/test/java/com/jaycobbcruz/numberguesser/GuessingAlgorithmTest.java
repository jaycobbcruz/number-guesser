package com.jaycobbcruz.numberguesser;

import org.junit.Assert;
import org.junit.Test;

public class GuessingAlgorithmTest {

    @Test
    public void testGuess() {

        Assert.assertEquals(Double.valueOf(3), new GuessingAlgorithm(x -> 12 / x, () -> 4).guess());

        Assert.assertEquals(Double.valueOf(3), new GuessingAlgorithm(d -> d * d, () -> 9d).guess());

        Assert.assertEquals(Double.valueOf(9), new GuessingAlgorithm(x -> 90 / x, () -> 80 / 8).guess());

        Assert.assertEquals(Double.valueOf(15.517241379310345), new GuessingAlgorithm(x -> (29 * x) / 90,
                () -> Math.ceil(-9 * Math.cos(90))).guess() );
    }
}
