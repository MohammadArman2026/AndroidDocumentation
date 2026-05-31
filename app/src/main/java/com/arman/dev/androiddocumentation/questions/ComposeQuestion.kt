package com.arman.dev.androiddocumentation.questions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.jetbrains.annotations.TestOnly

/**
 * this will contain the question from the compose.
 */

/**
 * Q.1 What is recomposition? how does compose know what to compose.
 *
 * Recomposition is process of re executing those composable whose states or input have changed.
 * compose has ui tree, and it recomposes only those which has changed.
 *
 * it decides by a mechanism-
 * compose keep tracks of the states and keeps track of those composable that are reading the states and when state changes compose schedules
 * the recomposition of those composable that are reading the state.
 *
 * eg...
 * in the example when count changes compose will be able to know that count has changed , so it will recompose the Text() to update the ui.
 */

@Composable
fun HomeScreen(){
    var count by remember {
        mutableIntStateOf(0)
    }
    Text(
        text = "$count"
    )
}


/**
 * Q.2 What makes a class stable? Why does it matters?
 *
 * A class is stable if compose can reliably track whether it has changed or not.
 * A class is stable if all its properties are Immutable.
 * A class is stable if all properties are stable.
 * A class is stable if it implements the meaningful equals()
 *
 * Stability matter because compose can skip the recomposition,when value have not changed.
 * It gives compose a guarantee that it will not change without notifying the compose.
 * eg..
 */

data class User(
    val name : String = "" ,
    val age :Int = 0 ,
    val price : Double = 0.0
)
/**
 * this class is stable because it contains the immutable properties, and compiler will mark them stable and compose will be notified when they
 * will change.
 */

data class Product(
    val list:List<String> = emptyList()
)
/**
 * this is unstable class , still it has the immutable property
 */

//data class Products(
//    val list : ImmutableList<String> = emptyList()
//)

/**
 * this class is stable because it is immutable.
 */


/**
 * Q.3 Explain remember and rememberSaveable.
 *
 * remember is a composable function that is used to store the value which is retained across the recomposition as long as the composable is in
 * tree. Survives recomposition.
 *
 * remember saveable is a composable function that is used to store the value and retained it across the configuration changes.
 * it survives both the configuration change and recomposition.
 * rememberSaveable for user input , remember for computed and derived values.
 *
 *
 * var count by rememberSaveable { mutableIntStateOf(0) }
 * After rotation: count = whatever it was before rotation
 * rememberSaveable for complex objects - needs custom Saver
 * val product by rememberSaveable(stateSaver = ProductSaver) {
 *     mutableStateOf(Product())
 * }
 */


/**
 * Q.4 what is side effect? what are different side effect API in jetpack ?
 *
 * A side effect is anything outside the scope of composable.
 * eg. making a network call, writing to database, launching coroutine, triggering navigation.
 *
 * LaunchedEffect
 * SideEffect
 * DisposableEffect
 * rememberCoroutineScope
 * derivedStateOf
 */


@TestOnly
@Composable
fun CustomScreen(){
    LaunchedEffect(Unit) {

    }

    var text by remember {
        mutableStateOf("")
    }

    val isTrue by remember {
        derivedStateOf {
            text.length >=8
        }
    }

    DisposableEffect(Unit) {
        onDispose {

        }
    }

}

/**
 * Q.5 what are the difference between launched effect , side effect , disposable effect?
 * LaunchedEffect is a suspend function that provides a scope which is tied to the composable lifecycle.
 * it is used to execute the coroutine from the composable.
 * it automatically cancels the previous coroutine when key changes and restarts new ones.
 * when compose leave the composition it automatically gets cleared.
 *
 * SideEffect{} is a side effect that executes on each successfully recomposition.
 *
 * DisposableEffect(){} is a side effect api which provides setup  when composable first enters composition state and cleanup when composable
 * leaves the composition or key changes.,
 */

/**
 * what is rememberCoroutineScope() ?
 * it returns a coroutine scope tied to the current composable. which can be used to launch the coroutine from the composable.
 * it is used with the click handler where manual user interaction is required.
 */

/**
 * what is derivedStateOf{}?
 * derived state of creates a state that only changes when results changes not the source.
 * it minimises the recomposition.
 * used when the derived value changes less frequently than source itself.
 * it returns a State<T>.
 */


/**
 * explain collectAsState() and collectAsStateWithLifeCycle()
 *
 * collect as state with lifecycle stops collecting in stopped state , when app is backgrounded it stops but collectAsState() does not .
 * collectAsStateWithLifeCycle() prevent wasted work when the app is invisible.
 */

/**
 * what is channel ?
 * it is queue model which sends values to the collector, it stores the value until it is consumed , follows producer-consumer model.
 * it is used to send the events to the consumer,and it is not broadcasted means value will be consumed by only one consumer in case
 * if there are multiple consumer.
 */

/**
 * how will you emit an event from viewmodel to ui ?
 *
 * i can emit an event from the viewmodel to the user interface using the channel as well as shared flow.
 * both has its own benefit and pitfall.
 * shared flow broadcast the event to all its active observer,it emit to every collector.
 * channel sends the value to only one collector and ensures that event will be consumed by only one collector, follows one to one pipeline
 * model.
 * channel buffers the event when there is not active observer, but shared flow drops the event.
 */

class VM : ViewModel(){
    private val _events : Channel<String> = Channel(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    fun sendEvent(){
        viewModelScope.launch {
            _events.send("hello world")
        }
    }
}

@Composable
fun Log(){
    val viewModel = VM()

    LaunchedEffect(Unit) {
        viewModel.events.collect {

        }
    }
}

/**
 * explain three compose phase.
 *
 * compose has three phases-
 * 1.composition
 * 2.layout
 * 3.drawing
 *
 * in composition phase ui tree is being built.
 * it is actually a tree of composable in child and parent manner.
 *
 * in layout phase the size of parent is determined, according to the childs size.
 * positioning of child element occurs in the layout phase.
 *
 * in drawing phase actual pixel by pixel ui is drawn.
 */

/**
 * what is graphics layer? how does it help in optimisation?
 *
 * graphics layer creates a separate drawing layer for a composable, allowing transformation (scale, rotation, alpha) to be applied
 * without redrawing the content every time.
 *
 * it works on the draw phase so no recomposition and layout
 */

/**
 * what is sp and dp.
 * 1.dp --
 * dp stands for density independent pixel.
 * used for sizing the layout  like button, padding, height.
 * it ensures that element looks same size on the different density phone.
 * android converts different dp into pixels.
 *
 * 2.sp--
 * sp stands for scale independent pixel.
 * used for font size.
 * it respect user font size accessibility setting.
 * if user increases font size in setting text scale properly.
 */

/**
 * what is composable ? why compose over xml ? what are its benefit?
 *
 * a composable is a function that is responsible for building the user interface.
 * a composable function can be called from another composable function.
 * to make a function composable we annotate it with @Composable.
 * each composable is a reusable unit.
 *
 * composable have some benefit over the compose--
 * 1.compose is declarative but xml is imperative.
 * 2.kotlin is only needed but for xml you need xml as well as kotlin.
 * 3.less boiler plate code in compose than xml.
 * 4.compose has automatic state handling but xml need to handle manually.
 * 5.reusability is higher in compose than xml.
 * 6.compose has better theming.
 * 7.faster preview.
 * 8.better state handling in compose.
 * 9.xml is highly optimized for static user interface.
 * 10.recycler view is still used over lazy column in production apps because it is highly
 * optimized.
 */

/**
 * what is declarative UI means?
 *
 * declarative means the ui is function of states, when state changes automatically
 * ui changes. we don't manually need to update the values.
 * in xml we manually do everything.
 */

/**
 * what is recomposition and how recomposition occur, how it identify that what to recompose?
 *
 * recomposition is reexecuting the compose function when any state changes on which the
 * composable depends upon.
 * internally compose uses snapshot system which observes the state and also know the scope
 * of those states that which composable are reading or depending on this. when state changes
 * compose knows it and then recompose those composable which changes.
 * compose uses slot table and snapshot system to detect changes and scope.
 */

/**
 * what is slot table?
 *
 * slot table is internal compose data structure that stores the information about the
 * composable during the composition so compose can efficiently recompose only changed
 * part of the user interface.
 *
 * it store-->>
 * store the composable tree
 * remember UI structure
 * track state dependencies
 * manage recomposition efficiently
 */

/**
 * what is snapshot system?
 *
 * snapshot system is internal state management engine of jetpack compose.
 * it is responsible for the -->>
 * tracking the state reads.
 * tracking the state writes.
 * detecting changes.
 * triggering recomposition safely.
 * most common example could be git.
 */
