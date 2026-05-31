package com.arman.dev.androiddocumentation.kotlin

import android.R

/**
 * Functions in kotlin.
 *
 * function is a block of code that execute some particular functionality.
 * it ensures code reusability.
 * modularized program.
 */

/**
 * Declaring the function.
 *
 * fun FunctionName(parameter:Type , parameter :Type = defaultValue):ReturnType{}
 */

fun double(x:Int):Int{
    return 2*x
}

fun addList(x :Int , list: MutableList<Int>){
    list.add(x)
}
/**
 * Calling functions
 *
 * double(3)
 */

/**
 * Inside the body of a function, received arguments are read-only(important).
 * we can pass one function in other function as parameter.
 */

/**
 * You can assign a parameter a default value that isn't constant. For example,
 * the default can be the result of a function call or a calculation that uses the values
 * of other arguments, like the len parameter in this example:
 */

fun read(
    b: ByteArray,
    off: Int = 0,
    len: Int = b.size,
) { /*...*/ }

/**
 * this is known as single expression function.
 */
fun double1(x: Int): Int = x * 2

/**
 * if a function does not return anything, it returns unit and we do not need to specify
 * explicitly the return type as unit.
 */

/**
 * to pass a variable number of arguments to the function we can use `varargs`
 *
 * To pass a variable number of arguments to a function, you can mark one of its parameters
 * (usually the last one) with the vararg modifier. Inside a function, you can use a
 * vararg-parameter of type T as an array of T:
 */

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}


/**
 * Higher order functions and lambdas.
 */