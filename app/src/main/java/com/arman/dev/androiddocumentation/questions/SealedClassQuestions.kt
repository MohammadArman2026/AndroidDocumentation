package com.arman.dev.androiddocumentation.questions

/**
 * sealed class , interface
 */

/**
 * what is a sealed class?
 * sealed class is a class which is sealed means it can not be inherited by any class
 * but its direct subclass can do.
 * it restricts the other classes to extend it and seal the known subtypes.
 *
 * gives controlled inheritance.
 * subtypes are known at the compile time.
 * used for mapping the network results.
 * for Events we can use the sealed class.
 * predictable.
 */

sealed class Results(){
    object Loading: Results()
    class Error(val error:String ? = null): Results()
    class Success(val list:List<String> = emptyList()) : Results()
}

fun parcelize(result : Results){
    when(result){
        is Results.Error -> TODO()
        Results.Loading -> TODO()
        is Results.Success -> TODO()
    }
}

/**
 * what is an interface?
 * an interface is a blue print for a class that implements it.
 * it contains the information that what a class can do.
 * it does not tell how to do it.
 * it abstracts implementing class.
 * it cant be instantiated.
 * it does not have constructor.
 * can not have states.
 * can have abstract as well as concrete method.
 * it defines can do relationship.
 * by default methods are abstract and need to be overridden in implementing class.
 * supports multiple inheritance.
 */

interface Repository{
    fun getUserInfo(): User1

}

class RepositoryImpl(): Repository{
    override fun getUserInfo(): User1 {
        TODO("Not yet implemented")
    }
}

/**
 * what is an abstract class?
 *
 * an abstract class is a type of class which can not be instantiated.
 * it can have constructor.
 * it can have states.
 * can contain concrete as well as abstract method.
 * we need to specify the methods if wanna make abstract.
 * it also act as blue print for the class extending it.
 * it defines the "is-a" relationship.
 */

//abstract class Person(){
//   abstract val height : Int
//    fun getHeight():Int{
//        return height
//    }
//    abstract fun setHeight(h :Int)
//}


/**
 * what is enum class?
 * enum class (enumeration class) is a class which is used when we have a fixed set of
 * constant values.
 * it represent set of constant values in type safe way.
 */

enum class Day{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

/**
 * what is a singleton class?
 * a singleton class is a class which is having only one instance for its lifetime.
 * it is initialized lazily.
 * it is shared globally across app.
 * holding the reference of view, activity, fragment can cause the memory leak.
 */

/**
 * what is a companion object?
 * in kotlin companion object is used to create the class level members. some times we
 * want to access factory methods, constants from the class but we have to instantiate first
 * to avoid this behaviour we uses companion objects.
 * we can access the property and methods from just its name.
 */

class Animal{
    val name : String = ""
    companion object{
        const val NAME = "doggy ji"
        fun getName(): String {
           // name
            return ""
        }
    }
}


fun getName():String{
    return Animal.NAME
}

/**
 * what are the different types of access modifier in kotlin?
 * access modifier are the one which defines the accessibility of class member and methods.
 *
 * there are 4 access modifier.
 * 1.public
 * 2.private
 * 3.protected
 * 4.internal
 *
 * public access modifier makes the property public means accessible to outside the class.
 * private access modifier makes the property private means accessible to the member of class only.
 * protected are those which are accessible to the member of class or its subtypes.
 * internal is a modifier that makes it accessible inside the same module. and module can be
 * one Android app
 * one Gradle module
 * one library module
 */

/**
 * what are the Unit, Nothing ?
 * unit is the return type which tells compiler that this function does not return
 * any thing meaning full.
 * unit is actually a type.
 * fun greet(): Unit {
 *     println("Hello")
 * }
 *
 * Nothing is a type which tells compiler that this function never completes and return
 * unsuccessfully.
 * execution stops completely.
 * Nothing is subtype of every type.
 */

/**
 * what is an inner class?
 *
 * inner class is a nested class which holds the reference to the instance of outer class.
 * means it can access the private member of outer class.
 * inner class lives in the outer class.
 * outer class can not access the inner class member but inner class can do.
 *
 * in nested class we can not have the reference of outer instance in inner class.
 * usage are Recycler ViewHolder, Bounding Service.
 * memory leak possible.
 */


class Car(private val brand: String){

    inner class Engine{
        fun start(){
            println(brand)
        }
    }
}

class Outer(private val x : Int){
    private val y = 3
   val z = 6
    class Inner{
        fun start(){
            println("hello world")
        }
    }
}

fun main(){
    val car = Car("BMW")
    val engine = car.Engine()
    engine.start()
    val outer = Outer(1)
    val inner = Outer.Inner()
}



