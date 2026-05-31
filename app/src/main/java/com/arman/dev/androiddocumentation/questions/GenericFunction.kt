package com.arman.dev.androiddocumentation.questions

/**
 * What is generics?
 * generics mean general for every one , no type specification.
 * it simply means writing classes or function that works with every type is known as generic.
 */

/**
 * writing a generic class
 */

fun main(){
//    val iContainer = Container<String>("arman")
//    iContainer.getData()

        val nums = listOf(1, 2, 3, 4, 5, 6)
        val evens = nums.myFilter { it % 2 == 0 }
        println(evens) // [2, 4, 6]

   val result = nums.myMap {it->
       "$it"
    }
    println(result)
}

/**
 * this is a generic class will work as a container for all the data types.
 */
//class Container<T>(var data :T){
//    fun getData():T = data
//    fun storeData(value :T) {
//        data = value
//    }
//}

/**
 * writing generic function
 */
//T can represent nullable and non nullable
//Any excludes the nullable
fun <T> identity(x:T) = x
fun<K,V>pair(a:K , b:V):Pair<K,V> = Pair(a,b)

fun <T> Iterable<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun <T,V> Iterable<T>.myMap(predicate:(T)->V):List<V>{
    val result = mutableListOf<V>()
    for(item in this){
        result.add(predicate(item))
    }
    return result
}