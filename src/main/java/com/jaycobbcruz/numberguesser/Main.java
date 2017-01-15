package com.jaycobbcruz.numberguesser;

class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Proper usage is: java -jar number-guesser.jar {function} {numeric expected result}");
            System.exit(0);
        }
        System.out.println(new GuessingAlgorithm(args[0], args[1]).guess());
    }

}
