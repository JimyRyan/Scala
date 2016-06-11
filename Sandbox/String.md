# Formating

## Pattern

1. Check digit numbers

%d => Display the number
%02d => Display number with mimium 2 digit (will add 0 if number have only 1 characters). This is usefull for date !

## Functions

1. Printf

Only display the result

```scala
printf("%d.%d.%d %d:%d:%d", year, month, day, hour, minute, second)
```

2. Format

Output and/or store the result into a variable

```scala
"%d.%d.%d %d:%d:%d".format(year, month, day, hour, minute, second)
```
