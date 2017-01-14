package com.jaycobbcruz.numberguesser;

import org.junit.Assert;
import org.junit.Test;

public class GuessingAlgorithmTest {

    @Test
    public void testGuess() {
        Assert.assertEquals( Double.valueOf(3), new GuessingAlgorithm(d -> d * d, 9d).guess() );
    }
}
