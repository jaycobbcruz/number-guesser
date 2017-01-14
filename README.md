# number-guesser

***number-guesser*** is a simple runnable application that can guess a variable value based on a given function/expression/script and the expected result.

## Usage
```{r, engine='bash'}
java -jar number-guesser.jar {expression} {result}
```

## Example
```{r, engine='bash'}
java -jar number-guesser.jar 'function(x) x * x' 9
```

The example will return 3. The function computes the square of a given variable, thus the problem tries to solve the square root of 9.

## Requirements
This application works only with JDK 8. The only dependency is JUnit 4.12.