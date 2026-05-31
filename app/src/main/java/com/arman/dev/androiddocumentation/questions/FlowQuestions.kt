package com.arman.dev.androiddocumentation.questions

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * flow questions
 */

/**
 * what is a flow?
 * A flow is an asynchronous data stream that emits multiple values sequentially.
 * it executes only when it is collected.
 */

/**
 * explain the types of flows and differentiate between them.
 * there are two types of flow
 * 1.cold flow
 * 2.hot flow
 *
 * cold flow-
 * it is data stream that emits only when it is collected.
 * when it has an active collector.
 * each new collector gets entire stream of data like a on demand independent function.
 *
 * hot flow-
 * it is stream of data that emits irrespective of collector.
 * each new collector will not get the entire stream,
 * every collector will get the same updated and latest value.
 */

fun main(){}

fun getFlow() = flow {
    for( i in 1..10){
        emit(i)
        delay(1000)
    }
}

 fun getColdFlow() : Flow<Int> = flow{
    println(Thread.currentThread().name)
}

/**
 * what are different flow builders?explain them.
 * flow builders are suspendable function that builds the flow
 * 1.flow{}
 * 2.flowOf()
 * 3.asFlow
 * 4.channelFlow{}
 * 5.callbackFlow{}
 *
 * flow{} is flow builder function that builds the flow and emits the flow, it ensures the
 * preservation of context.you can not emit from different coroutine context inside the flow.
 * flow{} is designed as sequential pipeline and collector expect one emitter coroutine.
 *
 * flowOf() is a flow builder function that builds the flow and used to emit the fix set of values
 * runs on the collector context.
 *
 * asFlow is flow builder that converts an iterable to the flow.
 *
 * channel flow is flow builder that is used to emit the concurrent emission.
 */


/**
 * what is a terminal operator? what are different terminal operator? explain each.
 * terminal operators are the operator that starts the collection of emission.
 * without the terminal operator it is just a description.
 * when applying terminal operator flow start working.
 *
 * 1.collect
 * it is terminal operator that collects the every emission from flow.
 *
 * 2.collectLatest
 * it is terminal operator that collects the newest value, the moment new value is available
 * it will drops the previous value.
 *
 * 3.first()
 * takes the first value.
 *
 * 4.firstOrNull()
 * takes the first value if not then null
 *
 * 5.last /lastOrNull
 * 6.launchIn gives scope to collector.
 */


/**
 * State flow and shared flow.
 * state flow is a hot flow
 * have replay = 1
 * every new subscriber will get a latest value
 * need initial value
 * lifecycle un aware
 * best for the ui states
 *
 * shared flow is a hot flow
 * have replay = 0
 * one time event
 * broadcast the event to multiple collector
 * no need of initial value
 * best for events.
 *
 * live data
 * android specific.
 * no need of initial value
 * built in lifecycle awareness
 * limited operators
 * not coroutine native
 * could not separate event and state.
 */

/**
 * Questions from flow.
 *
 * Ques1. What problem does Flow solve?
 *
 * lets say we have a data base that emits user information from the local database and
 * on the other hand user is submitting some information , in this case we would like to have
 * the update user information from the database , this problem will be solved by flow because
 * flow is asynchronous stream of data that is emitted to the collector when ever new
 * data is available it will emit.
 * it makes realtime update .
 * eg. we used to keep the user interface always updated and reactive this problem is solved
 * by the flow.
 *
 *
 * Ques2.Difference between Flow, suspend, and callback APIs?
 *
 * Flow is asynchronous stream of data emitted.
 * it uses coroutine to collect data.
 * it asynchronously emits data.
 * back pressure
 *
 * suspend is suspend function
 * returns one time result only
 * not a stream.
 * no backpressure.
 *
 * callback is an old way to perform the asynchronous task where we pass a callback(function)
 * which is executed later or called later.
 *
 * Ques3.Why is Flow called a cold stream?
 * Flows are called because it emits when it is collected.
 * it stores the logic to build the value not the value itself.
 * it starts emitting when someone request.
 *
 * Ques4.What does “cold” actually mean internally?
 *
 * Ques5.When does a Flow start executing?
 * when flow is getting collected it starts executing and emitting.
 *
 * Ques6.How is Flow different from RxJava Observable?
 *
 * Ques7.What is the lifecycle of a Flow?
 * lifecycle of flow start from when it is collected.
 *
 * How does cancellation work in Flow?
 * when collecting coroutine is cancelled flow gets cancelled.it lifecycle end.
 * Flow checks cancellation at suspension points
 *
 * What happens if collector gets cancelled?
 * entire collection will stop and emission will stop.
 *
 * Is Flow push-based or pull-based?
 * flow is pull based.
 *
 * How does Flow preserve sequential execution?
 * 
 * Why is Flow suspendable?
 * What happens internally during emit()?
 * Can multiple collectors collect same Flow simultaneously?
 * How is Flow implemented internally?
 * What is the role of Continuation in Flow?
 * How does emit() suspend?
 * Why is Flow sequential by default?
 * What prevents concurrent emission in Flow?
 * What is SafeCollector internally?
 * What is context preservation in Flow?
 * Why can't emit happen from another coroutine directly?
 * How does Flow enforce structured concurrency?
 * How does cooperative cancellation work in Flow?
 * How does Flow check cancellation during emission?
 * What happens internally when using flowOn()?
 * How many coroutines are created by flowOn()?
 * How do operators create Flow chains internally?
 * Are operators eager or lazy?
 * What is operator fusion?
 * How are intermediate operators implemented?
 * How are terminal operators implemented?
 * What happens internally in:map{}, collect{}, filter{}
 * Why is flow {} cold?
 * Why can emit only happen in same coroutine?
 * Why is concurrent emit prohibited?
 * Can you launch inside flow builder?
 * Why is this wrong?
 * Why does channelFlow allow concurrent emission?
 * Internally how does channelFlow work?
 * Difference between flow and channelFlow?
 * When should channelFlow be used?
 * How is Channel used internally?
 * Why does callbackFlow exist?
 * How does callbackFlow bridge callback APIs?
 * Why is awaitClose() mandatory?
 * What happens if awaitClose is missing?
 * Difference between callbackFlow and channelFlow?
 * Why does StateFlow always have initial value?
 * Why is StateFlow hot?
 * How does StateFlow store latest value?
 * Why does StateFlow replay latest emission?
 * Is StateFlow conflated?
 * Difference between LiveData and StateFlow?
 * Difference between StateFlow and SharedFlow?
 * Can StateFlow lose emissions?
 * Why was SharedFlow introduced?
 * What is replay cache?
 * What is extraBufferCapacity?
 * What happens when buffer overflows?
 * Difference between replay and buffer?
 * How does SharedFlow manage multiple collectors?
 * When should SharedFlow be used instead of Channel?
 * Why is Flow context-preserving?
 * Why does collect happen in collector context?
 * What exactly does flowOn() do?
 * Why does flowOn() affect upstream only?
 * What is upstream/downstream in Flow?
 * Why can multiple flowOn() exist?
 * How does thread switching happen in Flow?
 * Why is emit() context-sensitive?
 * Why does Flow forbid emission from another dispatcher?
 * What is backpressure?
 * How does Flow handle slow collectors?
 * Difference between:buffer() conflate() collectLatest()
 * Difference between withContext() , flowOn()
 * What happens internally in buffer()?
 * How does buffering create concurrent pipelines?
 * Why does conflate() skip values?
 * When can emissions be dropped?
 * What happens if producer is faster than collector?
 * Difference between Channel buffering and Flow buffering?
 * How does map work internally?
 * Difference between map and transform?
 * Difference between flatMapConcat, flatMapMerge, flatMapLatest?
 * Which creates concurrent collection?
 * Which cancels previous flow?
 * How does debounce work internally?
 * Difference between debounce and sample?
 * What happens if collector is slow?
 * Difference between distinctUntilChanged and StateFlow behavior?
 * Which waits for both emissions? zip() , combine() , merge()
 * Which emits immediately?
 * Which preserves ordering?
 * Which is concurrent?
 *
 * What makes a Flow hot?
 * What makes a Flow cold?
 * Can cold Flow become hot?
 * What does shareIn() do internally?
 * What does stateIn() do internally?
 * How does sharing work internally?
 * What happens when no collectors exist?
 * Difference between eager/lazy/whileSubscribed sharing?
 * How do multiple collectors affect cold flow?
 *
 * Difference between: try-catch , catch
 * Why does catch not catch downstream exceptions?
 * How does retry work internally?
 * Difference between retry and retryWhen?
 * What happens when collector throws exception?
 * How does cancellation exception behave?
 *
 * What causes unnecessary recompositions with StateFlow?
 * Why should immutable state be preferred?
 * How to optimize Flow chains?
 * What is operator fusion?
 * How does buffering improve throughput?
 * What are Flow allocation costs?
 * Why avoid deeply nested Flow chains?
 *
 * Why use StateFlow in ViewModel?
 * Why not expose MutableStateFlow?
 * Why collect Flow in repeatOnLifecycle?
 * Why is launchWhenStarted discouraged?
 * Difference between LiveData and StateFlow?
 * How to avoid multiple collectors?
 * Why does Flow work better with Compose?
 * How to collect Flow in Compose?
 * Difference between: collectAsState() LaunchedEffect() snapshotFlow()
 *
 * How is StateFlow lock-free?
 * How does SharedFlow maintain replay cache?
 * What atomic operations are used internally?
 * How are collectors stored internally?
 * How does Flow suspend/resume collectors?
 * How does Flow integrate with Continuation machinery?
 * How does Flow cancellation resume suspended collectors?
 * How does select work with channels?
 * How are Flow operators inlined?
 *
 * How would you implement search debounce?
 * How would you prevent duplicate API calls?
 * How would you cache Flow results?
 * How would you merge local DB + network?
 * How would you implement infinite pagination with Flow?
 * How would you handle retry with exponential backoff?
 * How would you implement one-time UI events?
 * Why is SharedFlow preferred over SingleLiveEvent?
 * How would you share expensive Flow computation?
 *
 */





