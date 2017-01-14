package com.jaycobbcruz.numberguesser;

import java.util.function.Function;

class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Proper usage is: java -jar number-guesser.jar {function} {numeric expected result}");
            System.exit(0);
        }
        final Function<Double, Double> function = StringToFunctionConverter.convert(args[0]);
        System.out.println(new GuessingAlgorithm(function, Double.valueOf(args[1])).guess());
    }

}
