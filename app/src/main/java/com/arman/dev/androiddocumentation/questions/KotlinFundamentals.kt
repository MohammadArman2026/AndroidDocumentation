package com.arman.dev.androiddocumentation.questions

/**
 * kotlin fundamentals.
 */

/**
 * what is difference between val and var?
 * val is immutable.
 * its reference cant be changed.
 * it is read only.
 *
 * var is mutable.
 * its reference can be changed.
 * it is read/write both.
 *
 * but in nonprimitive data types like list we can have modification in the list.
 * we can add/remove the items in the list.
 */


fun main(){}

/**
 * what is const val?
 * const is a keyword which is used to define a compile time constant.
 * it is known at the compile time.
 * it is inline.
 * performance enhances.
 */

/**
 * can const be used with var? if no why?
 * const is used with val only cant be used with var.
 * because const is a compile time constant and its value is known at the compile time
 * but var is run time variable and can change the value at run time so  this will cause
 * the contradiction.
 */

/**
 * what is lateinit var ? can lateinit be used with val?
 * lateinit stands for late initialisation.
 * initialised before using it.
 * we uses it when we actually know that it will be having some value.
 * it cant be val because it is injected at the runtime.
 * it tells the compiler that i will initialise it before using it.
 * so basically it is some sort of assurance to compiler that i will initialise it before using it.
 * lateinit var name : String
 *
 * lateinit can not be used with val.
 * internally initially it stores the null value.
*/

/**
 * what is by lazy?
 * lazy is a lazy initialisation when first accessed.
 * it is one time initialisation.
 * it can be only used with val.
 * it is created only once and then used afterward.
 */

/**
 * what is scope function?
 * scope function is a special type of function that executes a block of code in the
 * context of an object.
 * they are used to write cleaner and readable code.
 */

/**
 * how many scope functions are there?what are their function? why each one is used?
 * There are 5 scope function
 * 1.let
 * 2.run
 * 3.with
 * 4.apply
 * 5.also
 */

/**
 * let.
 * it is a scope function.
 * it return lambda result.
 * it is referenced with "it"
 * it is used to check the nullability
 * temporary transformation
 * chaining
 */

//it will print the name only when name is not null
fun letExplanation(name :String?){
    name?.let {it->
        println(it)
    }
}

/**
 * run
 * it is scope function.
 * referenced with this.
 * returns lambda result.
 *
 */

fun runExplanation(){
    val str = "Arman"
    str.run {
        length
    }
}

//class  X{
//    lateinit var x: String
//    x = "arman"
//}

/**
 * with
 * reference with this.
 * returns lambda result.
 */

data class You(
    val user : String
)

fun withExplanation(u : You){
    with(u){
        user.length
        println(user)
    }
}

/**
 * apply
 * reference with this
 * returns object
 */

fun applyExplanation(u: You){
    u.apply {
        println(user)
    }
}
/**
 * also
 * reference with it
 * returns object
 */

/**
 * List in kotlin.
 *
 * there are the two type of list in the kotlin.
 * MutableList
 * ImmutableList
 *
 * mutable list is read only ,
 * cant be modified.
 * immutable list  can be modified.
 *
 * val list = listOf("arman" ,"salman") //we can not add or subtract from it.
 * val list = mutableListOf("arman" , "salman") // we can add or subtract from it.
 *
 * iterators---->>>>
 * 1.filter
 * 2.map
 * 3.forEach
 * 4.find
 * 5.any
 * 6.all
 * 7.sorted
 * 8.distinct
 */

/**
 * 1.map
 * it is an iterator which is used to convert each element of the list.
 * when we want to convert every element of list
 * returns a immutable list.
 * its lambda returns generic.
 * */

fun getDiscountedPrice(list :List<Int>):List<Int>{
    val discountedList = list.map { it->
        it-20
    }
    return discountedList
}

/**
 * filter
 * it is an inline iterator which keeps only those element that matches the condition.
 * to filter out some elements we use filter.
 * it returns the list.
 * its lamba returns boolean
 */

fun getFilteredPrice(list: List<Int>):List<Int>{
  val filteredList = list.filter { it->
        it>30
    }
    return filteredList
}

/**
 * forEach{}
 * it is an iterator which is used to iterate through the each element.
 * its lambda returns unit.
 */

fun onEachIterate(list: List<Int>){
      list.forEach {
        println(it)
    }
}

/**
 * find.
 * it is inline function which is used to find the first occurrence of element in the list.
 * it returns T? any type with nullable.
 * its lambda returns the boolean
 */

fun runFind(list:List<Int>): Int?{
   return  list.find {
        it%2==0
    }
}

/**
 * any
 * it is an inline function used to check that this condition is satisfied by any element.
 * it returns boolean.
 * its lambda returns boolean.
 */

fun runAny(list: List<Int>): Boolean{
   return list.any{
        it == 2
    }
}

/**
 * all
 * it is an inline function which will return true if all element will satisfy the condition.
 */

fun runAll(list :List<Int>): Boolean{
    return list.all {
        it %2==0
    }
}

/**
 * distinct
 * it is inline function returns list of distinct element removes the duplicate ones.
 */

fun runDistinct(list:List<Int>):List<Int>{
    return list.distinct()
}
/**
 *
 * sorted()
 * to sort the list in ascending order
 * sortedBy{}
 */
