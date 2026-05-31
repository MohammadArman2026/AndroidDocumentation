package com.arman.dev.androiddocumentation.kotlin

import androidx.compose.ui.graphics.RectangleShape
import kotlin.math.min

/**
Extension function

extension function is a type of function that is used to extend the functionality of a existing class
or an interface without touching the source code or modifying the source code.it does not have the
access to the private member of class since it is not a member function.

Extensions are always called on a receiver. The receiver has to have the same type as the class or
interface being extended.To use an extension, prefix it with the receiver followed by a . and the
function or property name.

standard kotlin library provides many useful extension functions such as-
 filter,map,reduce,fold,groupBy  for collections.
*/

/**
 * to create out own extension function-
 *
 * we need to create using the syntax-
 * fun ClassName.functionName(){}
 *
 * we can have extension function for the interfaces as well.
 * Defining an extension on an interface like this is useful when you want to add functionality to
 * all types that implement an interface only once.
 */

interface User {
    val name: String
    val email: String
}
fun User.userInfo()=println("$name,$email")
class RegularUser(override val name: String, override val email: String) : User
/**
 * any classes implementing this interface will get the extension function.
 */
fun RegularUser.userInfo()=println("$name,$email aa")

/**
 * when we have two same named extension function one from interface and one from the class's
 * extension function and class implements the interface and in that scenario when extension is called
 * then class's extension function will take priority.
 */

/**
 * generic extension
 *
 * an extension function which is called for every type is known as generic extension.
 */

/**
 * generic on list
 * this is a generic function on the list, any type of list can apply extension.
 */

fun <T> List<T>.getLastValue():T?{
    return if(isEmpty()) null
    else this[this.size-1]
}

/**
 * Nullable receiver
 *
 * we can define an extension function on a nullable receiver.
 * we can call on the variable even when it is null and `this` will refer to null.
 * so we have to manage the nullability.
 * */

fun Any?.toString(): String{
    return this?.toString() ?: "null"
}

/**
 * since extension function and member functions have the same syntax, how does compiler
 * knows which to call.
 *
 * extension functions are dispatched statically based on the receiver type on which it is called,
 * on compile time it is resolved.
 */
open class Shape

class Rectangle : Shape()
fun Shape.getName()="shape"
fun Rectangle.getName()="rectangle"
fun printClassName(shape : Shape){
    shape.getName()
}

/**
 * Important________________________________________________________________________________________
 * If a class has a member function and there's an extension function with the same receiver type,
 * the same name, and compatible arguments, the member function takes precedence.
 *
 * However, extension functions can overload member functions that have the same name but a
 * different signature:
 */

class Example {
    fun printFunctionType() { println("Member function") }
}
//overloading the existing member function with an extension function.
fun Example.printFunctionType(index: Int) { println("Extension function #$index") }

/**
 * Anonymous extension function
 * an extension which does not have name but has behaviour.
 */
data class Order(
    val weight : Double
)
val calculateRate = fun Order.(rate:Double): Double = this.weight*rate

//we can create a lambda extension
val isInRange : Int.(min:Int, max:Int)-> Boolean = {min,max->
    this in min..max
}

/**
 * in kotlin we can have extension properties.
 * val ClassName.propertyName :Type
 * get() = //define computation.
 * it should be defined with val only because extension can have getter only
 * and it does not have backing field.
 * extensions are syntax sugar for function.
 */

val Example.username : String
    get() = "username"

/**
 * extension on companion object
 *
 * in kotlin we can define extension function and properties for the companion
 * object just like regular member of the companion object.
 * compiler names it companion object Companion.
 *
 * fun ClassNam.Companion.functionName(){}
 */
class Logger{
    companion object{

    }
}

fun Logger.Companion.logStartupMessage(){
    println("Application Started")
}

/**
 * declaring extension as member function
 *
 * we can declare extension on one class as a member function for other class too.
 * extension function does not have access to private and protected member.
 *
 */


fun main(){
    val user = RegularUser("arman" , "armanamu123@gmail.com")
    user.userInfo() //here it will call extension on class not on interface

    printClassName(Rectangle()) //here we are passing rectangle which is subclass of shape
    // and it is received in shape:Shape  and it will call extension on shape not on rectangle
    //since it is statically resolved based on the receiver type.

    Example().printFunctionType(1) //overloading the existing member function with the extension.
    10.isInRange(2,8)  // this is how we will call the lambda extension.

    Logger.logStartupMessage() // we can call the extension function on companion by just class name
}
