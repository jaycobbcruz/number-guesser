# number-guesser

***number-guesser*** is a simple runnable application that can calculate a variable value based on the given function and its expected result.
The calculation is done in reverse by finding the variable value by approximation.

## Usage
```{r, engine='bash'}
$ java -jar number-guesser.jar {expression} {result}
```

## Example
Compute the square root of 9.
```{r, engine='bash'}
$ java -jar number-guesser.jar 'function(x) x * x' 9
```


Find x in "7x + 4x = 100".
```{r, engine='bash'}
$ java -jar number-guesser.jar 'function(x) (7 * x) + (4 * x)' 100
```


Find x with expected result from another function.
```{r, engine='bash'}
$ java -jar number-guesser.jar 'function(x) (29 * x) / 90' 'Math.ceil( -9 * Math.cos(90))'
```


Solve for x in equation "81 / x = 71 / 8".
```{r, engine='bash'}
$ java -jar number-guesser.jar 'function(x) 81 / x' '72 / 8'
```


## Requirements
This application works with Java 8.
