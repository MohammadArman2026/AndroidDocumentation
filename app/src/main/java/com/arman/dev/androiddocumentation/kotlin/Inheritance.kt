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
 *
 * equals() function here checks objects reference.
 *
 * open keyword-->>
 * open keyword is used to tell explicitly that this class is inheritable or member function cant be overridden
 * because in kotlin all classes are by default final means cant be inherited.
 */

open class Bottle()

class YellowBottle (): Bottle()

open class Device {
    open fun operate(){
        println("operate")
    }
}

/**
here i have inherited the Device class since it is open and overridden the operate function.
overriding member is by default open , to make it final we can explicitly specify that.

declaring the same method in the subclass is not allowed.
 */
class ElectronicDevice : Device(){
    override fun operate() {
        super.operate()
    }
}

/**
 * Overriding the class properties.
 * overriding mechanism works same as override on methods.
 * any property declared open in the base class can be override with override keyword.
 * Each declared property can be overridden by a property with an initializer or by a property with a get method:
 *
 * we can override val property with a var property but not its vice versa because val has get method and
 * overriding it as var will add an extra set method.
 */

interface Mobile {
    val size : Int
}

class Oppo: Mobile {
    override val size: Int = 23
}


/**
 * derived class initialisation order.
 *
 * when an instance of the derived class is constructed then first base class initialization
 * is done as the first step proceeded by evaluation of the base class argument.
 * then derived class initialisation logic is executed.
 */

/**
 * Calling the super class implementation.
 * derived class can call the property and methods in the superclass by using the keyword
 * super in the derived class.
 *
 * Inside an inner class, accessing the superclass of the outer class is done using the
 * super keyword qualified with the outer class name: super@Outer
 */

/**
 * Overriding rules.
 *
 * if a class inherits the same member function from the different superclasses then
 * it must give its own implementation of that method.
 */

open class Student {
    open fun study(){
        println("studying")
    }
}

interface Student1{
    fun study(){
        println("study")
    }
}

class Arman : Student() , Student1{
    //compiler is forcing you to implement the study function since it has two implementation
    // so it would need which one to use.
    override fun study() {
        super<Student>.study()
        super<Student1>.study()
    }
}


fun main(){
    val objBottle = Bottle()
    println(objBottle is Any)//this tells that every class is subtype of Any.it will print true.

    val objBottle1 = Bottle()
    val objBottle2 = Bottle()

    println(objBottle1 == objBottle2)// this will print false since both has different references.

    println(objBottle)

}
