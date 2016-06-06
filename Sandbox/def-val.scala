http://alvinalexander.com/scala/fpbook/explaining-scala-val-function-syntax-functional-programming

The following lines show the implicit and explicit syntax for a function named add1, which returns an Int value that is 1 larger than the Int value it is given as an input parameter:

val add1 = (i: Int) => i + 1           // implicit return type (IRT)
val add1: Int => Int = (i) => i + 1    // explicit return type (ERT)

One variation of this is that you can put curly braces around the function body:

val add1 = (i: Int) => { i + 1 }
val add1: Int => Int = (i) => { i + 1 }

You generally need to use curly braces around multi-line functions, but you can also use them in one-line functions if you prefer.

With the ERT syntax, when you have only one input parameter, you can leave the parentheses off of the parameter name:

val add1: Int => Int = (i) => { i + 1 }
val add1: Int => Int =  i  => { i + 1 }   // parentheses not required

All of those examples show a function that takes one input parameter. The next examples show the syntax for a sum function that takes two input parameters:

val sum = (a: Int, b: Int) => a + b            // implicit
val sum: (Int, Int) => Int = (a, b) => a + b   // explicit
