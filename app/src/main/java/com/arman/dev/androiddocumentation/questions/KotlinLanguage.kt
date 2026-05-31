package com.arman.dev.androiddocumentation.questions

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * list in kotlin are the collection of elements.
 * mutable list and immutable list.
 * mutable is one which can be modified and immutable cant be modified.
 * we can add subtract in mutable but not in immutable.
 */

fun main(){
    testList()
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
fun testList(){
    val list : MutableList<String> = mutableListOf("")
    /**
     * some methods on the mutable list.
     */
    list.add("arman")
    list.add(1,"salman")
    list.clear()
    list.subList(1,4) //here end index is exclusive
    list.remove("arman")
    list.removeAt(1)
    list.removeFirst()
    list.removeLast()
    list.size
    list.contains("arman")
    list.take(2)
    list.drop(2)
    
}