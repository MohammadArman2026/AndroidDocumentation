package com.arman.dev.androiddocumentation.questions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * Resume Questions
 */

/**
 * what is firebase
 * Firebase is a backend as a service platform.
 * it provides backend services like-
 * 1.data storage
 * 2.file storage
 * 3.authentication
 * 4.realtime database
 * 5.Firebase cloud messaging
 *
 * it is based on the mongoDB, data storage is in the form of key value pair.
 */

/**
 * what is firebase cloud messaging.
 * it is service provided by the firebase which allow servers to send the notification
 * or messages to android,ios or web applications.
 */

/**
 * what is Supabase?
 * supabase is a backend service platform that provides backend services like-
 * 1.data storage
 * 2.file storage
 * 3.authentication
 * 4.realtime data base
 * 5.it has triggers which gets executed on some task execution.
 *
 * it is based on the postgreSQL
 */

/**
 * what is android TTS (Text to Speech)
 * TTS is a Text to speech conversion API.
 * it is used to convert text into speech and play that speech.
 * it is provided by the Android.
 */

/**
 * what is pagination?
 * Pagination is a technique which eventually helps to bring data in chunks or pages instead
 * of loading entire data at once.
 * instead of fetching 10000 of data we can break this into pages containing 20 data on each page.
 * fetching entire data at once will cause the huge memory usage.
 * slow and laggy user interface.
 * ANR.
 * Network waste.
 *
 * data loads while user scroll.
 */

/**
 * what are the different types of pagination?
 * there are four types of pagination-
 * 1.offset pagination:
 * traditional and most basic pagination.
 * it sends the offset and limit to the backend.
 * it ask for data after the the offset.
 *
 * problem in this is that if new item gets added to the database at the top then
 * that item will get missed or some item will gets duplicated.
 *
 * 2.page number pagination
 * internally backend calculate the offset using the page.
 * user sends the page number to the backend and backend calculates the offset from page
 * number and returns the data.
 * easy to implement.
 * it has the same problem as the offset pagination.
 *
 * 3.cursor pagination.
 * in this pagination backend sends the cursor token instead of the offset.
 * it tracks the actual position of using the item identity.
 * instagram, twitter, facebook feed uses cursor pagination.
 * it is scalable, fast for huge db.
 *
 * 4.keyset pagination.
 * similar to the cursor pagination it uses database keys.
 * it is fast.
 * it is optimized using the database keys.
 * used in chat app,timelines,infinite scrolling.
 */

/**
 * what is a paging 3 library?
 * it is android jetpack library that is used to load the data in the chunks/pages instead
 * of loading entire data at ones.
 */

/**
 * what is offline first architecture?
 * offline first architecture is a pattern where application depends on the internet but that
 * does not mean that without internet it will not run and show loader only.
 * it will show those data that are cached using the local database.
 * local database act as a primary data source for the app and network act as synchronization
 * layer for the app.
 * initially fetch the data from the internet and store it in the local database and repository
 * interact with the local db when internet returns it synchronizes the remote and local datasource.
 * local database act as the single source of truth.
 *
 * eg.chatting apps stores the chat using offline first architecture
 * instagram reels getting cached using this architecture.
 */

/**
 * what is a google credential manager?
 * google credential manager is an authentication api that automates the authentication
 * using credential stored in phones like email.
 * it provides a way to handle -
 * passwords
 * passkey
 * signIn with google
 * on tap sign in
 */

/**
 * what is analytics event logging for whole code base using the firebase?
 *
 * Analytics even logging is centralized way to track the important user actions, app behaviour,
 * and system events across the entire application.
 *
 * eg.if we want to track  which feature is used more often then we can do this with
 * firebase analytics.
 */

/**
 * what is FFmpeg?
 * it is native c++ library for audio and video processing.
 * it is fast library written in c++.
 * to use this library we need to cross compile this library for the android architecture.
 * to use it in the kotlin code we need to build a JNI (java native interface) layer which is
 * needed to connect the kotlin code to the c++ code.
 *
 * Audio conversion.
 * video quality.
 * video trimming.
 */

/**
 * what is media extractor and media meta data retriever ?
 * media extractor is low level android api to extract the raw encoded audio/video samples
 * from a media file or stream.
 * it parses the stream and return video stream , audio track , subtitle,metadata.
 */

/**
 * what is exo player?
 * exo player is library that is used to play audio , video and used for streaming.
 * it has wide support of different codecs.
 * different streaming platform uses this library for streaming.
 */

/**
 * what is dependency injection?
 * dependency injection is a design pattern where we inject or pass the dependency or instances
 * to the class instead of creating them inside the class.
 *
 * it make code easier to test.
 * it makes loose coupling between the different classes.
 * it makes easier to manage.
 * modularity
 * scalable
 *
 * dependency we inject by two way ->
 * 1.field injection --- inside the body of class
 * 2.constructor injection -- inside the primary constructor
 */

/**
 * explain about hilt
 * hilt is dependency injection framework used to inject the dependency(instances) to the classes.
 * it is annotation based dependency framework.we just write the annotation and hilt does behind the scene work.
 * annotation tells how to create dependency, how long will they live, where to inject.
 * hilt generates the code at compile time
 *
 * faster runtime
 * compile time validation
 * fewer runtime crashes
 *
 * Annotations
 * @AndroidEntryPoint
 * @HiltViewModel
 * @HiltAndroidApp
 * @Module
 * @Provides
 * @Bind
 * @Singleton
 * @SingletonComponent
 * @Inject
 * @InstallIn
 *
 * @HiltAndroidApp
 * it is annotation used to initialize the dependency graph.
 * it is applied on the application class.
 * at first application class is executed and hilt is initialized.
 *
 * @HiltAndroidApp
 * class MyApp :Application()
 *
 * @AndroidEntryPoint
 * it is annotation used on the android components.
 * it allows the dependency injection into the android's class.
 *
 * @AndroidEntryPoint
 * class MainActivity :AppCompatActivity()
 *
 * @Inject
 * it is annotation used to tell the hilt how to create the dependency.
 * now the hilt know how to create the dependency.
 * class UserRepository @Inject constructor(private val api :ApiService)
 *
 * @Module
 * it is annotation used to group the dependency containers/providers or it explicitly tells the compiler
 * that this is container you can look for the dependency in this container or provider.
 * used for the third party instances.
 *
 * @Provides
 * it is annotation used inside the modules and it tells the hilt how to create the dependency.
 * @Provides
 * fun provideRepo():UserRepo = UserRepo()
 *
 * @Binds
 * it is annotation used to bind the interface with its implementation.
 * actually the interfaces cant be instantiated so for that purpose we need binds.
 *
 * @InstallIn
 * it is annotation which defines which component own the dependency.
 * SingletonComponent::class
 *
 * @Singleton
 * it is annotation which is used to tell the compiler that create only one dependency of the class and reuse it.
 */

/**
 * explain about koin
 * koin is a dependency injection framework that resolve the dependency graph at the runtime rather than on compile time.
 * it uses domain specific language to provide the dependency.
 * it is runtime time slower.
 * very lightweight.
 * setup simpler.
 */

/**
 * what are the differences between both?which one is better and why?
 */

/**
 * what is REST API ?
 */

/**
 * what is retrofit?
 * retrofit is a type safe HTTP client library for android and java developed by square to communicate with REST Api.
 * it helps to send HTTP request.
 * receive api response.
 *
 */

/**
 * what is interceptor?
 * interceptor is a component that act between the app and server and it intercept the network request.
 * it can observe, modify, block or retry HTTP requests and responses before they reach to the server or app.
 *
 * they are used for ---
 * authentication tokens
 * logging
 * retry logic
 * analytics
 * caching
 * request modification
 * error handling
 */

fun main()= runBlocking {
    testing()
}




suspend fun testing() {
    val scope = CoroutineScope(Job())

    supervisorScope {

        scope.launch {
            launch {
                throw RuntimeException()
            }

            launch {
                delay(300)
                println("Still running")
            }
        }
    }

    delay(5000)
    println("END")
}


//abstract class A() {
//   abstract fun fun1()
//}

internal interface I {
    fun fun1()
    fun fun2()
}


internal class B : A(), I{
    override fun fun1() {
        TODO("Not yet implemented")
    }

    override fun fun2() {
        TODO("Not yet implemented")
    }

}