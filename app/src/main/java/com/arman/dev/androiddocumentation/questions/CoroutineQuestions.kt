package com.arman.dev.androiddocumentation.questions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

fun main() {
//    runBlocking {
//        launch {
//            getUser1()
//        }
//           launch {
//               withContext(Dispatchers.IO){
//                   println("waiting for delay.....")
//                   delay(5000)
//                   getUser2()
//               }
//           }
//        launch {
//            getUser1()
//        }
//    }
//
//    runBlocking(Dispatchers.Default) {
//        val scope = CoroutineScope(Job())
//
//           launch {
//            println(Thread.currentThread().name)
//        }
//    }

 //   runBlocking()

    runBlocking{
        launch {
            println("hello")
        }
        delay(1000)

        println("hello end")
    }

}

suspend fun getUser1() {
    println("user1")
}

suspend fun getUser2() {
    println("user2")
}

suspend fun runCoroutineScope(){
    coroutineScope {

    }
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun runGlobalScope(){
  val j =  GlobalScope.launch {

    }
    j.cancel()
}

/**
 * what is coroutine?
 *
 * coroutine is a suspendable computation that suspends its execution and resume after suspension
 * point without blocking the thread on which it is running and letting other coroutine to
 * consume the thread for that suspension time and optimizes maximum use of resource.
 * internally coroutine uses state machine, code after the suspension point is stored in continuation object
 * and when coroutine resumes it will be resumed from that point.
 *
 * before coroutine there were threads, they were resource intensive and each thread would take up to
 * 1 mb and it has intensive context switching and they were managed by os ,
 * they were blocking in nature if any blocking task comes then it blocks the whole thread.
 *
 * coroutines are concurrent not parallel.
 */

/**
 * what is the difference between concurrent and parallel?
 *
 * concurrent means doing multiple task on the thread for eg.doing multiple network call and database read and ensuring the efficient use of
 * the thread. and the tasks are not running at the same instant.
 * parallel tasks are literally running at the same instant , using the core of system.it does not ensure the efficient utilisation
 * of resource.
 */

/**
 * what is the difference between the thread and coroutine.
 *
 * A thread is managed by the operating system. Threads can run tasks in parallel on multiple CPU cores and represent
 * a standard approach to concurrency on the JVM. When you create a thread, the operating system allocates memory for
 * its stack and uses the kernel to switch between threads. This makes threads powerful but also resource-intensive.
 * Each thread usually needs a few megabytes of memory, and typically the JVM can only handle a few thousand threads at once.
 *
 * On the other hand, a coroutine isn't bound to a specific thread. It can suspend on one thread and resume on another
 * , so many coroutines can share the same thread pool. When a coroutine suspends, the thread isn't blocked and remains
 * free to run other tasks. This makes coroutines much lighter than threads and allows running millions of them in one
 * process without exhausting system resources.
 *
 */


/**
 * what is suspend function?
 * a suspending function is a type of function which pause its execution and resume execution later without affecting the structure.
 * suspend function is declared using the suspend keyword.
 * suspend function can be called from the suspend function or coroutine.
 */

suspend fun greet() {
    println("hello prashant bkl")
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun runWithContext() {
    withContext(Dispatchers.Default) {
        this.launch {

        }
        this.launch {

        }
        launch {

        }
    }
    GlobalScope.launch {

    }
}

/**
 * what is withContext()
 * withContext() is a suspending function that is used to change current context.
 * it provides the scope to launch the coroutine.
 * it waits for its child coroutines to complete.
 * it suspends to the previous context and then switches to the next context shifts its task to that context completes and then resume on the
 * previous context with result.
 */

/**
 * why coroutine is known as lightweight thread?
 *
 * coroutine is known as lightweight thread because -
 *
 * it gives thread like behaviour at lighter cost than thread
 * it is of few kbs
 * it runs on top of thread
 * we can have many coroutines on the thread
 * it is non blocking gets suspended
 * context switching is faster
 * managed by kotlin runtime
 * android independent
 */


/**
 * what is structured concurrency?
 *
 * structured concurrency is a principle, which explains that coroutine forms the parent child relationship and when parent scope gets
 * cancelled all its child coroutine gets cancelled and when child fails parent cancels the scope eventually cancelling all the coroutine.
 * unless provide a supervisor scope.
 */

/**
 * explain dispatchers.
 *
 * dispatcher is an interface that tells the compiler that on which thread a coroutine should work.
 * android has four dispatchers-
 * 1.Main
 * 2.IO
 * 3.Default
 * 4.Unconfined
 *
 * on Main thread Ui runs and it is optimised for ui related task.
 * IO thread is optimised for the io related works like database read, network calls
 * Default is optimised for the cpu intensive works like manipulating the Bitmap.
 * Unconfined is unconfined which no specific thread, testing only avoid in production
 */


/**
 * what is launch and async ? what is the difference between both?
 *
 * launch and async are the coroutine builder function they give a block to launch the coroutine.
 *
 * launch is fire and forget .
 * returns job which is a handle to the coroutine to manage it.
 *
 * async is for the coroutine that returns a result.
 * it returns a deferred object, an object which will contain some result which is deferred but will be resolved in future.
 */


/**
 * what happens when a coroutine is cancelled?
 *
 *
 */


/**
 * what is scope? what are the different scopes?
 *
 * scope provide a way to manage the coroutine as a group , it defines where a coroutine lives, how long it lives and who cancels it.
 * coroutine form the parent child relationship, a coroutine launched in a coroutine is a direct child.
 *
 * there are various scope available in android -->>
 * GlobalScope
 * LifecycleScope
 * viewModelScope
 * coroutineScope
 * CoroutineScope()
 * withContext()
 * runBlocking{}
 * supervisorScope()
 * supervisorJob()
 */

/**
 * explain about the GlobalScope.
 *
 * it is a top level scope, has no parent.
 * it is a scope which is alive as long as the app lives.
 * its lifetime is tied to the lifecycle of app.
 * it runs on the default thread by default.
 * we can launch GlobalScope.launch{} inside another coroutine, but this does not mean that it will become child of the other coroutine.
 * GlobalScope.launch{}
 *
 */
@OptIn(DelicateCoroutinesApi::class)
suspend fun runGlobal() {

    coroutineScope {

        GlobalScope.launch {
            delay(2000)
            println("Global done")
        }

        println("Scope completed")
    }

    println("Main completed")
}

/**
 * explain about the runBlocking{}
 *
 * runBlocking{} is coroutine builder function which inherits the context from the parent.
 * it blocks the current thread and let it be block until all the child coroutine finishes.
 * we can provide our own context in it.
 * it is used for testing purpose.
 * it forms the parent child relationship.
 * exception propagates to parent and parent cancels.
 */

fun runBlocking() = runBlocking(Job()+ Dispatchers.Default) {
    launch {
        delay(2000)
        println(Thread.currentThread())
        println("hello from first launch after delay")
    }

    launch {
        delay(2000)
        println("hello from second launch after dalay")
    }
    println("hello from the run blocking-end")
}


/**
 * explains about the lifecycle scope.
 * a scope which is tied to the lifecycle of an activity or fragment.
 * it is lifecycle aware.
 * child coroutine failure does not affect other child coroutines.
 * runs on main thread if not given a context.
 * it is auto cancellable since it is tied with android component.
 * forms parent child relationship.
 * it internally uses the supervisorJob() to manage the exception propagation.
 * child coroutine are un affected to each other on exception.
 * lifecycle can be launched from the other coroutine , but it will not become child of the launching coroutine and
 * exception will no cause harm to lifecycle and parent will not wait for it.
 * inside the lifecycle scope normal hierarchy will work.
 */


/**
 * explain about the viewModelScope.
 * viewModelScope is a scope provided by the viewModel and it is tied to the lifecycle of viewModel.
 * it gets destroyed when viewModel gets destroyed.
 * runs on the main thread.
 * it uses supervisor job internally to manage the structured concurrency.
 * one child coroutine's cancellation will not affect other coroutine.
 * survives configuration change.
 * lifecycle aware.
 * it cant become child of other coroutines like lifecycle scope since it is tied to the component.
 */

/**
 * explain about the coroutineScope{}
 * it is suspending function which inherits context from parent and builds a scope and runs and does not return until all its child
 * coroutine finishes.
 * if any child fails entire coroutines will be cancelled.
 * it accept a suspendable lambda.
 */

suspend fun coroutineScope()= coroutineScope {

}

/**
 * explain about the supervisorScope
 *
 * it gives a scope which ensures that children does not get cancelled when any child fails.
 * supervisor scope uses supervisor job internally, which ensures to not cancel the parent coroutine when one fails.
 * it waits for all children to complete.
 * it inherits context from the parent.
 */

suspend fun runSupervisor(){
    supervisorScope{
        //accept a suspendable lambda
        //inherit parent context
    }
}


/**
 * supervisor job
 *
 * it is a type of job that ensures child to not get cancelled when one child coroutine throws exception.
 */


/**
 * explain about the withContext(context){}
 * it is a suspending function that switches the coroutine context and return result and return back to the parent context.
 * it does not create a new coroutine it just runs on a different context on the same coroutine.
 * suppose on a thread coroutine launched with the "withContext()" then it will suspend on the previous context and switches to next
 * context and does it execution over there and return back to the previous context.
 * sequential , wait for completion.
 */
suspend fun runwithContext(){
    val scope = CoroutineScope(Job()+ Dispatchers.Main)

    scope.launch {

        println("Before")

        withContext(Dispatchers.IO) {

            delay(2000)

            println("Inside IO")
        }

        println("After")
    }

    //inside io
    //after

    //because with context completes first

}

/**
 * explains about flowOn
 * flowOn changes the context of upstream without affecting the downstream.
 *
 * flow {
 *     emit(1)
 * }
 * .map {
 *     heavyWork(it)   //it runs on default
 * }
 * .flowOn(Dispatchers.Default)
 * .collect {
 *     println(it)   // runs on main thread
 * }
 */

/**
 * explain about Mutex()
 * it ensures that a variable is being updated at a time by one coroutine, when multiple coroutine try to update the coroutine.
 * it ensures consistency among the value of variable.
 */

/**
 * explain about the CoroutineScope()
 *
 * it is a scope builder function that creates a scope to launch the coroutine.
 * when we work with some component that does not provide the scope we do need this function to build the scope
 * and we manually have to manage this scope otherwise it can leak and cause performance degradation.
 *
 * when we work with service , then we manually create the scope using the CoroutineScope() function by passing the
 * context in the builder function and we cancels it in the onDestroy function to let it get cleared.
 * */

fun coroutineScopeBuilder(){
    val scope = CoroutineScope(Dispatchers.IO)
}