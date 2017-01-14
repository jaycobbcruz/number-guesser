package com.jaycobbcruz.numberguesser;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class StringToFunctionConverterTest {

    @Test
    public void testGuess() {
        final Function<Object, Object> square = StringToFunctionConverter.convert("function(d) d * d");
        Assert.assertEquals((double) 81, square.apply(9));

        final Function<Object, Object> function = StringToFunctionConverter.convert("function(d) 1 + 2 + 3 + d");
        Assert.assertEquals((double) 10, function.apply(4));
    }
}
