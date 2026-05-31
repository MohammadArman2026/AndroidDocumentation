package com.arman.dev.androiddocumentation.questions

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * what is android component?
 * Android components are the building blocks of and android application with which android works.
 * They are used to interact with user,system,other apps.
 * each android component we use should be registered in the manifest.
 */

/**
 * what are the different android component?
 * there are 4 android components in android-
 * 1.activity
 * 2.service
 * 3.content provider
 * 4.broadcast receiver
 */

/**
 * why do we register android component in the manifest?
 * android components are registered in the manifest file to tell the android system that
 * these component exist in the application.
 * without manifest file it would have been time consuming and unreliable to query the
 * entire application to find the android components.
 */

/**
 * what is an activity?
 * An activity is a class that gives a window on which user interface is drawn through which
 * user can interact and information can be shown to user.
 *
 * A login screen , home screen , profile screen can be an activity.
 */

/**
 * define lifecycle of an activity.
 * An activity lifecycle is the sequence of stage through which the activity goes from
 * creation of activity to destroying the activity.
 *
 * os manages the lifecycle of an activity.
 * there are callback method that are called at different stages.
 * onCreate()
 * onStart()
 * onResume()
 * onPause()
 * onStop()
 * onRestart()
 * onDestroy()
 */

/**
 * onCreate() -> onStart() ->onResume() <->pause()->onStop()->onDestroy()
 *                  |                                  |
 *                 ----------------------------- onRestart()
 * 1.onCreate()
 * when app is launched onCreate() is called.
 * one time setup work is done in this stage.
 * dependency injection starts in this.
 * ui is initialised.
 * variable initialisation.
 * lifecycle aware component receives rhe ON_CREATE events.
 *
 * 2.onStart()
 * after onCreate() onStart() is called.
 * in this user interface becomes visible.
 * ui is only visible but not the interactive.
 * lifecycle aware component receives ON_START event.
 *
 * 3.onResume()
 * ui is visible.
 * ui is interactive.
 * lifecycle aware component receives ON_RESUME state.
 * resource access in this stage.
 * for eg.accessing camera , registering the listeners.
 *
 * 4.onPause()
 * it is fired when focus from activity changes.
 * any interruption occurs.
 * system dialog appears.
 * incoming call.
 * resource free up.
 *
 * 5.onStop()
 * when ui leaves.
 * user presses home button.
 * ui is in background loosed focus.
 * resource free up.
 *
 * 6.onDestroy()
 * calls to destroy the whole activity.
 * clears the activity.
 *
 * 7.onRestart()
 * used to restart the activity.
 */

/**
 * scenario based questions.
 */

/**
 * what is content provider?
 * content provider is an android component used to share the app data securely between
 * application.
 * content provider act as standardized database interface for the other apps.
 * eg.whatsapp takes the contact data from the contact app with the help of content provider.
 *
 * direct database access is not possible due to security reason, content provider gives a
 * secure way to share the data between apps.
 */

/**
 * what is broadcast receiver?
 * broadcast receiver is an android component that is used to react on the system wide or
 * app wide broadcast message.
 * it works like an event listener for android system.
 *
 * battery low
 * internet connected
 * airplane mode changed
 * SMS received
 * boot completed
 */

class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
       /**
        * broadcast the intent and it is received. based on this it will react.
        */
    }
}

/**
 * based on the registration there are two type of broadcast receivers->
 * 1.static broadcast receiver.
 * 2.dynamic broadcast receiver.
 *
 * 1.static broadcast receiver:
 * it is registered in manifest.xml instead of runtime code
 * android system knows about it.
 * it is declared permanently in manifest.xml
 * registration is fixed at installation time.
 * runs even if app is not open.
 * it runs even if app is closed or process is dead because android os itself launches it.
 * eg.BOOT_COMPLETED,SMS_RECEIVED
 *
 * 2.dynamic broadcast receiver:
 * it is a type of broadcast receiver which is registered at runtime.
 * it only works when app is alive.
 * we manually register and unregister it, and need to be unregistered.
 * it basically says notify me when the app is alive.
 */

/**
 * system wide broad cast-
 * it is broadcast made by operating system.
 * it is a system events.
 * hardware changes.
 * battery low
 * airplane mode changes
 *
 * app wide broad cast-
 * it is broadcast made by the application within itself for communication between its
 * component.
 * custom broadcast
 * app level broadcast
 */

/**
 * what is a service?
 * a service is an android component that is used to perform the long running operations
 * in the background without a user interface.
 * background here means that independent of user interface/activity, it runs continuously
 * in the background.
 * eg.music playback.
 * eg.file sync.
 * eg.location track.
 *
 * by default service runs on the main thread. to switch context we can use the dispatcher.
 */

/**
 * what are the different types of service?
 * different type of services are-
 * 1.started service
 * 2.bound service
 * 3.foreground service
 */

/**
 * does service runs in the background even if the app is killed completely.
 * service runs inside the app process, it does not have independent process so if app is
 * killed then service will stop.
 * if system kills the service due to low memory it might start based on the return value of
 * onStartCommand().
 */
/**
 * does service provide scope to execute coroutine?
 * service does not provide its own coroutine scope we manually create it and manage
 * it.
 * we create the scope and launch the coroutine and cancels the scope in onDestroy()
 * method.in this way we manages the scope to avoid from the memory leak.
 */

class MusicService(): Service(){
    private val serviceScope = CoroutineScope(Dispatchers.IO+ SupervisorJob())

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

}

/**
 * explain about the started service.
 * a started service is a service which is started by calling startService from the android
 * components.
 * it is independent of caller and can stop itself by calling stopService(), stopSelf().
 * onCreate()->onStartCommand()->onDestroy()
 *
 * onCreate() is called first in this we do one time task like initialisation work.
 * onStartCommand()
 * onDestroy() to clear the resources, and cancelling the coroutine scope.
 */

/**
 * what is a foreground service?
 * a foreground service is a service which runs in the background by showing a notification.
 * it is less likely to be killed by the system.
 * it is started by calling the startForegroundService()
 * and destroyed by calling stopService() or stopSelf()
 */

/**
 * what is a bound service?
 * a bound service is a type of service that is bound to android components.
 * it is dependent on the component.
 * it is started by calling bindService()
 * it is destroyed when that component is destroyed.
 * to implement the bound service we need to override the onBind() method which returns
 * an Ibinder?.
 */

/**
 * what is an IBinder?
 * IBinder is core android interface which is used for interprocess communication between the
 * android components.
 * it act as bridge between the client and service.
 *
 * let say an activity want to call the function inside the service.
 * it will be done using the IBinder.
 */

/**
 * what is the difference between thread and service?
 * service is a core android component.
 * it is used for executing long running operation in the background independent
 * of any screen.
 * it creates its own process in lifecycle managed way.
 *
 * Thread is not an android component.
 * it is path of execution or execution unit inside the app process.
 * it is core related to programming for managing the long running , asynchronous task.
 * it does need to be registered in the manifest.
 * gets killed if app process killed.
 */


/**
 * what is fragment? explain its lifecycle? what is fragment manager? scenario based.
 * fragment is a reusable portion of ui that needs an activity to live on.
 * it makes the ui more modular and reusable.
 * it is hosted upon activity.
 * it has its own lifecycle callback.
 * it depends on the activity on which it is hosted to be alive.
 *
 * lifecycle-->>
 * in similar way as activity, fragment also has lifecycle callback which are triggered
 * at different phases during its lifecycle.
 * onAttach():
 * onCreate()
 * onCreateView()
 * onViewCreated()
 * onStart()
 * onResume()
 * onPause()
 * onStop()
 * onDestroyView()
 * onDestroy()
 * onDetach()
 */

/**
 * what is a fragment manager?
 * fragment manager is a class in android which is responsible for managing the fragment inside
 * the activity.
 *
 * its core work is to -
 * 1.Adding fragment
 * 2.Removing fragment
 * 3.Replacing fragment
 * 4.BackStack
 * 5.state restoration
 */

/**
 * what is work manager?
 * work manager is an android Jetpack library that is used to schedule the background task.
 * it provides guaranteed execution.
 * it is deferrable.(work does not need immediate execution)
 * it survives process death, reboot.
 * it is backward compatible(on older device it runs reliably)
 * work manager automatically runs on the default thread.
 */

/**
 * what are the different component of the work manager?
 *
 * the different component of work manager are-
 * Worker() class - it provides a method doWork() which is executed when work manager start execution.
 * return Result.success() , Result.failure() , Result.retry()
 * WorkRequest- it is work request.it tells what type of work is to be executed.1.periodic,onetime.
 * WorkManager - it schedules and manages work.
 * Constraint - these are the condition when to run the worker.eg.when battery is high,
 * eg.when internet is connected,
 * Work Continuation
 */

/**
 * what is chaining in work manager?
 * work manager allows the chaining of work.
 * it starts execution with one work then another work is executed after the first one completed.
 *
 * it is help full in scenario like get image ->compress image->upload image.
 * we can chain the work first fetching image->compress->upload.
 */

/**
 * how to check whether the work is executed successfully or not?
 * work manager gives uuid for each task to be scheduled.
 * and with that id we can have information about the work
 * work manager stores the current state, progress, result.
 */

/**
 * what is backward compatibility ? how does work manager achieve it?
 * it is property of work manager which ensures the work manager to execute task
 * in the older version of android.
 * Because it checks internally whether the android version is older or newer and depending
 * upon the version it uses job scheduler , Alarm manager
 */

/**
 * what is the need of work manager if there is service?
 * work manager gives guaranteed execution.
 * it survives the process death / app kill.
 * it stores work in internal sqlite database.
 * it supports coroutine.
 */


/**
 * what are the benefit of using the work manager?
 * reliable work.
 * guaranteed execution.
 * backward compatibility.
 * gives a way to check status of work.
 */

/**
 * how many types of work manager are there?
 *
 * CoroutineWorker()
 * Worker()
 * RxWorker()
 * ListenableWorker()
 */

/**
 * what are the constraint in the work manager?
 *
 * constraints are the condition that are checked when executing the work manager.
 * eg.NETWORK_CONNECTED
 */

/**
 * does work manager survives process death?
 * work manager survives process death because it keeps the work in sqlite database internally.
 */

/**
 * what is an intent?
 * intent is a messaging mechanism used to request an action from the other component of
 * android.
 * it act like a message or request object.
 * used for the communication between component.
 *
 * to start an activity from another activity we pass intent to start.
 * to start service.
 * to start broadcast.
 *
 * intent helps component to communicate with each other.
 */

/**
 * types of intent.
 *
 * explicit intent->
 * an intent which explicitly knows which component to start.
 * for ex. starting an activity from main activity will use explicit intent
 * because we know that this activity is to be started.
 *
 *
 * implicit intent->
 * an intent which does not know which component to start but it specifies the desired
 * action and let the android system to handle it and find the best component to execute it.
 * eg.Action.View
 * eg.Action.Dial
 * eg.Action.Call
 *
 * we just pass intent and android will decide which component to better use.
 *
 * passing data with intent is done through the putExtra() , getExtra() in key value pair
 * we can pass the custom data with the intent but it need to be parcelable.
 * and we can get using getParcelable(key, Class.java)
 */

/**
 * what is an intent filter?
 * intent filter is a declaration which tells that the particular component can handle
 * this type of Intent.
 * for example we can have a intent filter with a intent to receive the sms, if sms comes
 * then this component in which  the intent is declared can handle it.
 */

/**
 * what is parcelable?
 * parcelable is android specific serialization mechanism to serialize object into compact
 * binary so that they can be transferred between android component.
 *
 * lets say i have an object User() , i will not be able to transfer the object as it is
 * so i need a way to transfer this into some format which can be transferred. here comes
 * the parcelable which convert instance into compact binary.
 * android specific.
 * faster.
 * less garbage collection.
 * optimized for mobile.
 * less memory.
 */

/**
 * what is serializable?
 * it is java based serialization which converts objects into bytes to transfer, to be stored
 * and reconstructed later.
 * java specific.
 * higher memory.
 * slower than parcelable.
 * reflection based.
 *
 */

/**
 * what is local return and non local return?
 * local returns mean returning from lambda but not completely return from function.
 * non local means exiting the function or returning from the function from inside the
 * lambda.
 */


fun test() {
    val list  = listOf(1,2,3)
    list.forEach {it->

        if(it == 2)
            return@forEach
        println(it)
    }

    println("Runs")
}

fun main(){
    test()
}

