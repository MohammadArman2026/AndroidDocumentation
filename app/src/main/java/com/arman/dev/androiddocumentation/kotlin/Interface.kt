package com.arman.dev.androiddocumentation.kotlin

/**
 * interfaces
 *
 * interface is a contract for the classes that implements it.
 * it can have abstract as well as concrete methods.
 * it can not have the constructor.
 * it does not stores the states.because storing state would require memory and interface does not own memory.
 * they can have the properties which need to be abstract or provide accessor implementations.
 * accessor is basically a custom getter and setter function.
 * methods in interface is by default abstract.
 * a class or object or interface can implement the interface.
 * interface supports multiple inheritance and it cant be instantiated.
 * it does not have constructor.
 */


interface MyInterface{
    fun foo(){
        //body
    }
    fun bar()

    //properties
    //we need to give getter setter implementation in interface.
    val prop :Int
    val propWithImpl :String
        get() = "alpha"
}


class Child :MyInterface{
    override fun bar(){
        //implementation of bar function of interface
    }
    override val prop = 2
}

/**
 * backing field
 * a backing field in kotlin is the hidden variable that actually stores the value of a property.
 * a backing field is created when memory storage is needed.
 * Inside getters/setters, Kotlin exposes the backing field using:field
 */

/**
var age = 20
    set(value) {
        field = value
    }
 */


/**
 * properties in interface
 *
 * properties in kotlin is a higher abstraction that gives controlled access to data.
 * it may includes->>
 * getter
 * setter
 * validation
 * custom logic
 * computation
 *
 * You can declare properties in interfaces. A property declared in an interface can either
 * be abstract or provide implementations for accessors. Properties declared in interfaces
 * can't have backing fields, and therefore accessors declared in interfaces can't reference them:
 */

var age1 = 20
// when we do this kotlin internally does this
private var hiddenStorage = 20
fun getAge(): Int {
    return hiddenStorage
}

fun setAge(value:Int) {
    hiddenStorage = value
}


/**
 * interface inheritance
 *
 * an interface can inherit from other interfaces.
 * it can both provide implementation for their member and declare new properties and function.
 * classes implementing such interfaces are required to define the missing implementation.
 */


interface Named {
    val firstName:String
    val lastName:String
}

interface PersonName:Named{
    override val firstName:String
        get() = "mohammad"
    override val lastName :String
        get() = "arman"
    val fullName :String
}

class NameOfPerson() :PersonName{
    override val fullName :String = "$firstName + $lastName"
}


/**
 * Resolving overriding conflicts.
 */

interface A{
    fun foo() {
        println("A")
    }
    fun bar()
}

interface B{
    fun foo(){
        println("B")
    }
    fun bar(){
        println("bar")
    }
}

class C :A{
    override fun bar() {
        println("bar")
    }
}

class D :A,B{
    override fun bar() {
        super<B>.bar()
    }

    override fun foo() {
        super<A>.foo()
        super<B>.bar()
    }
}

/**
 * explanation
 *
 * A interface has 2 methods foo() and bar() where foo() has the implementation and bar() is abstract.
 * B interface has 2 methods foo() and bar() where both has implementation.
 *
 * Class D is implementing the A, B interfaces.
 * so it need to override the method bar of A since A interface method is abstract and  B interface has same method
 * implemented so compiler will be confused that what to do since one is implemented and one is not.
 *
 * in interface B foo() has implementation and in interface A foo() also has implementation so when a class will inherit the both
 * interfaces then at runtime it will have issues that which implementation should be called. so to resolve this issue
 * we need to override the foo() method as well in class D to resolve the issue and we can call super<A>.foo() , super<B>.foo() to
 * call the method of different interfaces.
 *
 * rules--
 * if a class implements two interfaces and both interface has one common function and one has implementation of one function
 * one does not have the implementation then
 * class must need to implement.
 *
 * if a class implements two interfaces and both interfaces has common function and both are having concrete implementation
 * in respective interfaces then still class will have to implement these function because at runtime compiler will be confused that
 * whom to call.
 */

open class X{
    fun fun1(){
        println("inside the class X")
    }
}

interface I{
    fun fun1()
    fun fun2()
}

//this class should only have 1 function definition because fun1 definition it has already got from the class X
class Y :I , X() {
    override fun fun2() {
        TODO("Not yet implemented")
    }
}

/**
 * interface says whoever implements me must have the implementation of these function.
 *
 * class says whoever extends me will get what i have.
 */

/**
 * questions from interfaces in kotlin
 *
 * Ques1. will this compile?
 * this will not compile because class should implement the interface function otherwise it will throw compile
 * time error.
 *
 * interface A {
 *     fun foo()
 * }
 *
 * class B : A {}
*/

interface Alpha {
    fun foo() {
        println("A")
    }
}
class Beta : Alpha{}

/**
 * interface A {
 *     val x:Int
 * }
 *
 * will this compile?
 *
 * yes, because it i just a declaration and any class implementing it will have to provide the implementation.
 */

interface Gama {
    val x:Int
        get() = 10
} // this is correct because it is roughly a getter function behind the scene and will return the value 10.
// it does not uses the backing field.
// no storage is used since it is just a contract.

interface Delta {
    companion object {
        var count = 0
    }
} // this is allowed because kotlin creates an object associated with interface.

class  Peta : Delta  //despite implementing the delta interface , an instance of Peta will not get count since count is
//associated with only the interface.

fun main(){
    val obj = NameOfPerson()
    println(obj.fullName)
    Beta().foo() // A will get printed
}


