package com.arman.dev.androiddocumentation.kotlin

/* Null Safety _________________________________________________*/

/**
 * A variable which can hold the null reference is known as nullable.
 *
 * Null reference means it references to nothing means it is not referencing to any object.
 * Null safety in kotlin is designed to significantly reduce the risk of null reference and also
 * known as billion dollar mistake.
 *
 * Accessing reference which is pointing to null will cause the null pointer exception and program
 * will crash.(NPE)
 *
 * Kotlin explicitly supports the nullability, means it tells you the way to declare a variable which
 * can hold null.
 * Kotlin compiler also enforces a non null variable to not hold the null reference.
 * Kotlin compiler forces you to check the nullability during code and eventually leading to safe
 * handling and avoiding null pointer exception.
 */

/**
 * Declaring the nullable types.
 *
 * val name :String ? = "arman"
 * this is nullable variable which can hold the null reference.
 */

/**
 * Kotlin compiler allows to check for nullability.
 * we can handle the null values with different ways.
 * 1.using if else
 * 2.safe call operator ?.
 * 3.elvis operator ?:
 * 4.non null assertion operator !!
 * 5.nullable receiver
 * 6.let function
 * 7.safe cast as ?
 * 8.collection of a nullable types
 */

/**
 * using if else.
 * if(value != null){}else{}
 */

/**
 * using safe call operator
 * ?.
 * name?.length
 */

/**
 * using elvis operator
 * it is a way to handle the nullable types and it is used to provide the default value when it is
 * null.
 * val x :String ? = null
 * println(x?:"arman")
 */

/**
 * using non null assertion operator.
 * !!
 * it asserts value into non null.
 * if the value is non null then it will be fine
 * if the value is null it will crash throwing the NPE(Null pointer exception)
 * it is useful only when you actually know that it cant have the null value.
 */

/**
 * Nullable receiver
 * an extension function can be called on the nullable receiver.
 * and explicitly handle the the null values.
 * .toString() function can be called on the nullable receiver and it handles null safely.
 */

/**
 * let function.
 * let function is used to operate on null types safely, it execute its block only when the
 * type is having non null value only.
 * ?.let{}
 * inside block will execute when variable on which let is applied having the non null value.
 */

/**
 * on nullable collection we can have filterNotNull() function.
 */

public inline fun<T,R> T.let(block:(T)->R):R{
    return block(this)
}


fun handleNullValue(name : String ?){
    //using if else
    if(name != null){
        println(name)
    }else{
        println("no name")
    }

    //using safe call operator
    //save from the null pointer exception
    println(name?.length)


}

fun main(){
    val name : String? = "arman"
    var age :Int ? = null

    println(name)
    println(age)
}