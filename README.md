# number-guesser

***number-guesser*** is a simple runnable application that can calculate a variable value based on the given function/formula and its expected result.
The calculation is done in reverse by finding the variable value by approximation.

## Usage
```{r, engine='bash'}
java -jar number-guesser.jar {expression} {result}
```

## Example
Compute the square root of 9.
```{r, engine='bash'}
java -jar number-guesser.jar 'function(x) x * x' 9
```

Find x in "7x + 4x = 100".
```{r, engine='bash'}
java -jar number-guesser.jar 'function(x) (7x) + (4 * x)' 100
```

## Requirements
This application works with JDK 8.