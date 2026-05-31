package com.arman.dev.androiddocumentation.kotlin

/*data class------------------*/

/**
 * data class is a special type of class that is designed to hold the data.
 * compiler generate some function for each data class based on the properties value.
 * toString()
 * copy()
 * hashCode()
 * equals()
 * componentN()
 * these are the methods that are generated for each data class.
 *
 * to ensure the consistency and meaningful behaviour of the generated code,data class need
 * to fulfill these criteria---
 *
 * data class must have at least on properties in the constructor.
 * data class cant be abstract, open, sealed, inner.
 * all properties inside constructor need to be val/var.
 *
 *
 * if there are explicit implementations of equals(), hashCode(),
 * or toString() in the data class body or final implementations
 * in a superclass, then these functions are not generated, and the
 * existing implementations are used.
 *
 * If a supertype has componentN() functions that are open and return compatible types,
 * the corresponding functions are generated for the data class and override those of the supertype.
 * If the functions of the supertype cannot be overridden due to incompatible
 * signatures or due to their being final, an error is reported
 *
 * Providing explicit implementations for the componentN() and copy() functions is not allowed.
 *
 * data class may extend the other classes.
 */

/**
 * property declared inside the constructor has the role in generation of the methods like
 * toString,componentN,hashCode,copy,equals.
 *
 * property inside the body of the data class has no role in the generation of methods.
 */

data class Phone(
    val companyName: String,
    val price: Int,
    val color: String
){
    var camera: Int = 0

    fun copy1(companyName: String = this.companyName,
             price: Int = this.price,
             color: String = this.color
    ):Phone = Phone(companyName ,price ,color)

    //this is the implementation of the copy function
}

/**
 * equals() function------
 * this function equates two instances of the same data class and compares whether both has same property value or not.
 * if both has same property value then gives true this is known as structural equality.
 */

/**
 * copy function
 * copy function is used to copy the instance and allows to alter some of the properties and keeping other untouched.
 * returns an instance of the same type but may have different properties values.
 * it is applied on the instance of data class.
 *
 * copy function creates shallow copy-- does not copy the instances recursively.
 * it doesn't copy components recursively. As a result, references to other objects are shared.
 *
 * Outer box → new copy created
 * Items inside the box → same old items reused
 */

/**
 * destructuring declaration_________
 * it is minimal way to assign values to the more than one variable in just one go.
 *
 * data class Person(val name:String, val age:Int, val height:Int)
 * val obj = Person("arman",23,5.6)
 *
 * val (name,age,height) = obj // this is known as destructuring declaration.
 * and this become possible because in data class it creates componentN() methods which works behind
 * the scene when we do the destructuring declaration.
 */

data class Employee(val name: String, val roles: MutableList<String>)


fun main(){
    val objPhone1 = Phone("lava" ,123,"blue")
    val objPhone2 = Phone("samsung" ,234,"green")
    val objPhone3 = Phone("lava" ,123,"blue")

    objPhone1.camera = 23
    objPhone3.camera = 25

    println(objPhone1 == objPhone3)  //structural equality
    println(objPhone1 == objPhone2) // structural equality

    val emp1 = Employee("arman" , mutableListOf("developer"))
    val emp2 = emp1.copy()
    emp2.roles.add("programmer") //this will be reflecting in the original data class too because it is creating shallow copy
    //and reference is shared between both.

    println(emp1)
    println(emp2)
}

















