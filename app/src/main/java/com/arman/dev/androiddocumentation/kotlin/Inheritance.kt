package com.arman.dev.androiddocumentation.kotlin

/*Inheritance___________________________________________________*/

/**
 * inheritance is one of the pillar of the OOP.
 * it allows to inherit the properties and behaviour of classes.
 * in kotlin single inheritance is allowed with classes.
 *
 * every class has by default supertype `Any` unless you explicitly define your supertype.
 * `Any` has three methods equals() , toString() , hashCode().
 *
 * by default kotlin classes are final and cant be inherited, to inherit them we need to specify a
 * keyword called open.
 *
 */

/**
 * equals() in the any class.
 * every class gets these methods and equals checks the object reference.
 */

class Bottle()

fun main(){
    val objBottle = Bottle()
    println(objBottle is Any)//this tells that every class is subtype of Any.it will print true.

    val objBottle1 = Bottle()
    val objBottle2 = Bottle()

    println(objBottle1 == objBottle2)// this will print false since both has different references.

}
