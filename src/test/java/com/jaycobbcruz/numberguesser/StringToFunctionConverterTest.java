package com.jaycobbcruz.numberguesser;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

public class StringToFunctionConverterTest {

    @Test
    public void convertToFunction() {
        final Function<Double, Double> square = StringToFunctionConverter.convertToFunction("function(d) d * d");
        Assert.assertEquals(Double.valueOf(81), square.apply(9d));

        final Function<Double, Double> function = StringToFunctionConverter.convertToFunction("function(d) 1 + 2 + 3 + d");
        Assert.assertEquals(Double.valueOf(10), function.apply(4d));
    }

    @Test
    public void convertToSupplier() {
        final Supplier<Number> multiply = StringToFunctionConverter.convertToSupplier("10 * 5.0");
        Assert.assertEquals(50.0, multiply.get());

        final Supplier<Number> function = StringToFunctionConverter.convertToSupplier("Math.cos(3)");
        Assert.assertEquals(-0.9899924966004454, function.get());
    }
}
