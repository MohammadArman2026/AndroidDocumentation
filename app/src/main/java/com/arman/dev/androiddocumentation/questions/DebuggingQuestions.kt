package com.arman.dev.androiddocumentation.questions

/**
 * what is memory leaks?
 * memory leak is a situation where instances exist in the memory even after no use because
 * someone is still referencing the instance so garbage collector could not collect it.
 *
 * it increases RAM utilisation
 * out of memory bound
 * slows the app
 * crash may happen
 *
 * context leak
 * coroutine leak
 * view leak
 * listener leak
 */

/**
 * what are the ways to avoid the memory leak?
 * avoid storing the activity/fragment context in the singleton.
 * a long lived object references the short lives object.
 * use application context.
 * use correct scope.
 * cancels the listeners when not in use.
 */

/**
 * what is a garbage collector?
 * garbage collector is a mechanism that collects and frees the memory of those instances
 * which are no longer in  use and need to be disposed.
 * garbage collector traces the reference of an instance if it is still traceable it does not
 * free up the memory else it will frees it.
 */

/**
 * how to debug whether a memory leak is actually occurring or not?
 * using leak canary-
 * it is a library that keeps track of instances that are destroyed and checks whether the
 * destroyed instance is garbage collected or not then checks if exist or not if it exist will
 * throw a report like main activity leaked.
 *
 * using memory profiler-
 * open profiler->memory
 * open activity
 * close activity
 * dump heap
 * search you activity class
 *
 * manual debugging-
 * override fun onDestroy(){
 * super.onDestroy()
 * Log.d("" ,"")
 */

/**
 * what is ANR?
 * ANR is an error that comes when ui thread gets blocked for a few second then system shows ANR
 * message.
 * ANR stands for the application not responding.
 */

/**
 * why ANR exist?
 *
 * ANR comes when the Main thread or Ui  thread gets blocked for too long and system thinks
 * that user interface could not respond to the user then it shows the ANR message.
 *
 * it generally occurs when-
 * we keep long running operation on the main thread.
 * eg.network call , database read , cpu intensive works on main.
 * because the main thread is optimised for ui related work and quick work because on main thread
 * ui runs and and draw the ui, running callbacks, handling touch events.
 *
 * Android has time out limit for ANRs.
 * for service 20 seconds
 * for broadcast receiver 10-20 seconds
 */

/**
 * how to avoid the ANR?
 * to avoid the ANR-
 * keep the long running operation outside the main thread.
 * keep network call on IO thread.
 * cpu intensive works on the default thread.
 * free main thread from any computation works keep only quick works on the main thread.
 */

/**
 * how will you find out that ANR is happening?
 * Android produces traces.txt-
 * contains main thread stack trace
 * all thread states
 * blocked locks
 * waiting operations
 */

/**
 * what is proguard? explain in depth.
 * proguard is a tool that is used to-
 * shrink the code,
 * remove the unused resources,
 * optimize bytecode
 *
 * proguard processes app before release to make it smaller, harder to reverse engineer
 * Class names obfuscated -- means meaningless name is injected instead of actual name making
 * it hard to read and then reverse engineer.
 * and potentially faster.
 * it is used for optimization.
 *
 * main use of proguard-
 * 1.shrinking
 * fun test(){
 * doTest()
 * }
 * if this function is never used it will remove it completely.
 *
 * 2.obfuscation
 * renames the class name with meaning less name making it hard to rad and reverse engineer.
 * class UserRepo(){}
 * class a(){}
 *
 * 3.optimization of bytecode
 * method inlining
 * removing redundant instruction
 * simplifying logic
 */

/**
 * how does proguard works?
 * proguard start from activity, manifest file and entry point.
 * creates a dependency graph
 * then removes those node which are unused
 */


/**
 * what is minSdk , targetSdk , compileSdk?
 *
 * 1.minSdk
 * lowest android version your app supports is known as min sdk.
 * if(deviceVersion < minSdk) app cant install.
 *
 * 2.compileSdk
 * it is android sdk version against which your app is compiled.
 *
 * 3.targetSdk
 * it is android sdk version for which our app is optimized and tested for.
 */