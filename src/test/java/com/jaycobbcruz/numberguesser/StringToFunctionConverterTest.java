package com.jaycobbcruz.numberguesser;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class StringToFunctionConverterTest {

    @Test
    public void testGuess() {
        final Function<Double, Double> square = StringToFunctionConverter.convert("function(d) d * d");
        Assert.assertEquals(Double.valueOf(81), square.apply(Double.valueOf(9)));

        final Function<Double, Double> function = StringToFunctionConverter.convert("function(d) 1 + 2 + 3 + d");
        Assert.assertEquals(Double.valueOf(10), function.apply(Double.valueOf(4)));
    }
}
