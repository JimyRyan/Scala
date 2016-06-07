http://alvinalexander.com/scala/fpbook/explaining-scala-val-function-syntax-functional-programming

I show these examples because I want to list the many ways you can write isEven using an implicit return type:
val isEven = (i: Int) => { if (i % 2 == 0) true else false }
val isEven = (i: Int) => if (i % 2 == 0) true else false
 
val isEven = (i: Int) => { i % 2 == 0 }
val isEven = (i: Int) => i % 2 == 0
val isEven = i: Int => i % 2 == 0

The next examples show different ways you can write isEven when declaring an explicit return type:
val isEven: (Int) => Int = (i) => { if (i % 2 == 0) true else false }
val isEven: (Int) => Int = i   => { if (i % 2 == 0) true else false }
 
val isEven: (Int) => Int = (i) => { i % 2 == 0 }
val isEven: (Int) => Int = i   => { i % 2 == 0 }
 
val isEven: (Int) => Int = (i) => i % 2 == 0
val isEven: (Int) => Int = i   => i % 2 == 0
 
val isEven: (Int) => Int = (i) => {
    if (i % 2 == 0) {
        true
    } else {
        false
    }
}



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





http://like-a-boss.net/2012/07/30/ordering-and-ordered-in-scala.html
