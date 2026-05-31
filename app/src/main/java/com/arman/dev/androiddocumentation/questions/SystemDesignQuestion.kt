package com.arman.dev.androiddocumentation.questions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Build a text editor
 */

@Composable
fun  TextEditorUndoRedo(){

    val stateList = remember {
        mutableStateListOf("")
    }

    var currentIndex by remember {
        mutableIntStateOf(0)
    }

    val undoButtonState by remember {
        derivedStateOf {
            currentIndex > 0
        }
    }

    val redoButtonState by remember {
        derivedStateOf {
            currentIndex < stateList.lastIndex
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(200.dp))

        OutlinedTextField(
            value = stateList[currentIndex]?:"" ,
            onValueChange = {it->
                // check whether it is not writing after undo
                if(stateList.size > currentIndex+1){
                    //have undone and started writing, so trim off the list after the index
                    // and then add
                    stateList.subList(currentIndex+1 , stateList.size).clear()
                }
                    //update the list and move the current index
                    stateList.add(it)
                    currentIndex++
            } ,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
        ) {
            Button(
                onClick = {
                    if(currentIndex > 0)  currentIndex--
                } ,
                enabled = undoButtonState,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Undo"
                )
            }

            Spacer(modifier = Modifier.width(32.dp))

            Button(
                onClick = {
                    if(currentIndex < stateList.lastIndex) currentIndex++
                } ,
                enabled = redoButtonState,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Undo"
                )
            }
        }
    }
}

/**
 * flow implementation
 */

//create a collector interface

interface FlowCollector<T>{
    suspend fun emit(value :T)
}

interface MyFlow<T>{
    suspend fun collect(
        collector: FlowCollector<T>
    )
}

fun <T> myFlow(
    block : suspend FlowCollector<T>.()-> Unit
): MyFlow<T>{
    return object : MyFlow<T> {
        override suspend fun collect(collector: FlowCollector<T>) {
            collector.block()
        }
    }
}

/**
 * # Kotlin, Coroutines, Flow & Compose Internals Learning Roadmap
 *
 * ---
 *
 * # 1. Higher Order Functions & Lambdas
 *
 * ## YouTube
 * - [Kotlin Higher Order Functions Tutorial](https://www.youtube.com/watch?v=ESm5AX1ZbSg)
 *
 * ## Official Docs
 * - [Kotlin Lambdas & Higher Order Functions Docs](https://kotlinlang.org/docs/lambdas.html)
 *
 * ---
 *
 * # 2. Lambdas With Receiver
 *
 * ## Article
 * - [Lambdas With Receiver Explained Simply](https://dev.to/derlin/kotlin-is-fun-lambdas-with-receivers-4a99)
 *
 * ---
 *
 * # 3. Coroutines Fundamentals
 *
 * ## YouTube
 * - [Philipp Lackner Kotlin Coroutines](https://www.youtube.com/results?search_query=philipp+lackner+kotlin+coroutines)
 *
 * ## Advanced Coroutines
 * - [Roman Elizarov Coroutines Talks](https://www.youtube.com/results?search_query=roman+elizarov+coroutines)
 *
 * ---
 *
 * # 4. Kotlin Flow
 *
 * ## YouTube Playlist
 * - [Philipp Lackner Kotlin Flow Playlist](https://www.youtube.com/results?search_query=philipp+lackner+kotlin+flow)
 *
 * ## Official Docs
 * - [Kotlin Flow Official Docs](https://kotlinlang.org/docs/flow.html)
 *
 * ---
 *
 * # 5. Channels
 *
 * ## Official Docs
 * - [Kotlin Channels Docs](https://kotlinlang.org/docs/channels.html)
 *
 * ## YouTube
 * - [Philipp Lackner Kotlin Channels](https://www.youtube.com/results?search_query=philipp+lackner+kotlin+channels)
 *
 * ---
 *
 * # 6. Continuations & Suspend Internals
 *
 * ## YouTube
 * - [Roman Elizarov Continuations and Coroutines](https://www.youtube.com/results?search_query=roman+elizarov+continuations+coroutines)
 *
 * ## Article
 * - [How Kotlin Coroutines Work Internally](https://medium.com/androiddevelopers/how-do-kotlin-coroutines-work-bd42880350fd)
 *
 * ---
 *
 * # 7. Compose Runtime Internals
 *
 * ## YouTube
 * - [Leland Richardson Compose Runtime Talks](https://www.youtube.com/results?search_query=Leland+Richardson+Compose+Runtime)
 *
 * ## YouTube
 * - [Jorge Castillo Compose Internals](https://www.youtube.com/results?search_query=jorge+castillo+compose+internals)
 *
 * ## Official Docs
 * - [Jetpack Compose State Docs](https://developer.android.com/develop/ui/compose/state)
 *
 * ---
 *
 * # 8. Observer Pattern & Reactive Programming
 *
 * ## Observer Pattern
 * - [Observer Pattern Explained](https://refactoring.guru/design-patterns/observer)
 *
 * ## Reactive Programming Intro
 * - [Reactive Programming Explained](https://www.baeldung.com/cs/reactive-programming)
 *
 * ---
 *
 * # 9. State Machines
 *
 * ## YouTube
 * - [State Machines Explained](https://www.youtube.com/results?search_query=state+machine+explained+programming)
 *
 * ## Article
 * - [Finite State Machines Explained](https://www.geeksforgeeks.org/finite-state-machine-fsm-introduction/)
 *
 * ---
 *
 * # 10. Concurrency & Threading
 *
 * ## YouTube
 * - [Concurrency vs Parallelism Explained](https://www.youtube.com/results?search_query=concurrency+vs+parallelism)
 *
 * ## Official Kotlin Docs
 * - [Kotlin Coroutine Context and Dispatchers](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html)
 *
 * ---
 *
 * # Build These Yourself (MOST IMPORTANT)
 *
 * After learning basics, implement:
 *
 * 1. Callback system
 * 2. Observer pattern
 * 3. Mini Flow
 * 4. Mini Channel
 * 5. Mini StateFlow
 * 6. Mini Compose state system
 * 7. Simple recomposition system
 *
 * ---
 *
 * # Recommended Learning Order
 *
 * 1. Higher Order Functions
 * 2. Lambdas
 * 3. Lambdas with Receiver
 * 4. Observer Pattern
 * 5. Coroutines
 * 6. Continuations
 * 7. Flow
 * 8. Channels
 * 9. Compose Runtime
 * 10. Build mini frameworks yourself
 *
 * ```
 */