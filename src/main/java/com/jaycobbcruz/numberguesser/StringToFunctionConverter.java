package com.jaycobbcruz.numberguesser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.function.Function;
import java.util.function.Supplier;

class StringToFunctionConverter {

    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    /**
     * Convert a script/function in String to a java.util.function.Function
     *
     * @param functionString the function in String type
     * @return the function converted to java.util.function.Function
     */
    @SuppressWarnings("unchecked")
    public static Function<Double, Double> convertToFunction(final String functionString) {

        try {
            return (Function<Double, Double>) engine.eval(String.format("new java.util.function.Function(%s)", functionString));
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot evaluate the given function script.");
        }
    }

    /**
     * Convert a script/function in String to a java.util.function.Supplier
     *
     * @param expression the function or expression in String type
     * @return the function converted to java.util.function.Supplier
     */
    @SuppressWarnings("unchecked")
    public static Supplier<Number> convertToSupplier(final String expression) {

        try {
            String function = expression;
            if (!expression.startsWith("function")) {
                function = "function() " + expression;
            }
            return (Supplier<Number>) engine.eval(String.format("new java.util.function.Supplier(%s)", function));
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot evaluate the given function script.");
        }
    }

}
