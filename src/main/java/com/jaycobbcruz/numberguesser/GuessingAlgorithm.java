package com.jaycobbcruz.numberguesser;

import java.util.function.Function;
import java.util.function.Supplier;

class GuessingAlgorithm {

    private static final int MAX_LOOP = 400;

    private final Function<Double, Double> function;
    private final Double expectedResult;

    public GuessingAlgorithm(final String formulaFunction, final String resultFunction) {
        this(StringToFunctionConverter.convertToFunction(formulaFunction), StringToFunctionConverter.convertToSupplier(resultFunction));
    }

    public GuessingAlgorithm(final Function<Double, Double> formulaFunction, final Supplier<Number> resultFunction) {
        this.function = formulaFunction;
        this.expectedResult = resultFunction.get().doubleValue();
    }

    public Double guess() {

        Double guess = 1d;
        try {
            Double result;
            Double low = 1d;
            int i = 0;
            while (MAX_LOOP > i) {
                i++;
                result = function.apply(guess);
                if (result.doubleValue() == expectedResult.doubleValue()) {
                    return guess;
                } else if (result < expectedResult) {
                    low = guess;
                    guess = guess * 2;
                } else if ((result % expectedResult) == 0) {
                    return findNumber(function, 0, expectedResult, result / expectedResult, 0d);
                } else {
                    return findNumber(function, 0, expectedResult, low, low);
                }
            }

            if (MAX_LOOP > i) {
                throw new RuntimeException("Max loop exceeded.");
            }

        } catch (StackOverflowError e) {
            throw new RuntimeException("Stack overflow error occurred.");
        }
        return guess;
    }

    private Double findNumber(final Function<Double, Double> function, final int maxLoopCounter, final Double expected,
                              final Double guess, final Double offset) {

        if (maxLoopCounter > MAX_LOOP) {
            throw new RuntimeException("Reached max loop count.");
        }

        final Double newOffset = offset / 2;
        final Double newGuess = guess + newOffset;
        final Double result = function.apply(newGuess);

        if (expected > result) {
            return findNumber(function, maxLoopCounter + 1, expected, newGuess, Math.abs(newOffset));
        } else if (expected < result) {
            return findNumber(function, maxLoopCounter + 1, expected, newGuess, offset * -1);
        } else {
            return newGuess;
        }
    }

}
