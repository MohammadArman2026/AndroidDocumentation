package com.arman.dev.androiddocumentation.questions

/**
 * Janitri innovation
 *
 * round 2. will be taken by product lead.
 *
 * Ques1.About Janitri
 * janitri innovations is an indian medtech startup founded in 2016.There main focus is maternal care ,
 * fetal care by monitoring systems.
 * they have their product for fetal monitoring system , maternal monitoring system.
 * they provide their devices to hospitals as well as to home care too.
 * keyar DT pro for hospitals
 * keyar DT lite for home care
 * Daksh SI
 *
 * they have onboarded up to 800+ hospitals and 300k+ mother monitored.
 * present in 10+ country.
 *
 * Their main goal is to reduce maternal and newborn deaths by providing
 * affordable and portable monitoring devices for hospitals and home care.
 */

/**
 * what is MVVM Architecture? why MVVM Architecture?
 * MVVM is an architecture pattern which stands for Model View ViewModel.
 * it is widely being incorporated into scalable mobile application.
 * it creates the three different layers and each layer is focused on a single responsibility,
 * making it easier to understand, easier to scale and makes easy for new comer to start with
 * ongoing project.
 *
 * Model: it stands for data related responsibility.
 * remote data sources and local data sources comes into this layer and they are being.
 * abstracted by the repository that communicates with the data sources.
 *
 * View: View stands for user interface.
 * its responsibility is to show the user interface.
 *
 * ViewModel: it is a bridging layer between the View and Model it connects the user interface
 * with data layer.
 * it manages the business logic related to the user interface and it communicates to the
 * repository.
 *
 * why MVVM ?
 * every architecture try to do -
 * “How do we organize app code so it is maintainable, testable, and scalable?”
 * Google officially has promoted the MVVM architecture because it works well with
 * 1.livedata
 * 2.stateflow
 * 3.viewModel
 * 4.room
 * 5.coroutine
 * 6.jetpack compose
 *
 * and it gives clear separation of concern, lifecycle awareness, less boilerplate than MVP,
 * easier state handling than MVC.
 * it reduce the possibility of memory leak because when activity is recreated on rotation
 * it can leak.
 * less boiler plate code than MVP.
 * better separation, UI renders only UI , ViewModel manages business logic ,Model takes care
 * about the data.
 * easier testing.
 * scalable , maintainable , loose coupling
 *
 *
 * MVVM flow--
 *
 * View <---> ViewModel <---> Repository <---> Model
 * ViewModel exposes states to the user interface.
 * View observes the states and ui react on the states.
 * ViewModel survives configuration changes.
 * Reactive updates happen automatically.
 *
 * MVVM has one problem that states can become inconsistent in complex screen, due to which
 * the people still finds the MVI usable because it has a single source of truth and unidirectional
 * data flow but it seems to be over engineered for simpler apps.
 * most business app uses MVVM.
 *
 * combination of both can be used.
 */

/**
 * what do you know about IoT and bluetooth or wifi connectivity with mobiles?
 * IoT stands for internet of things.
 * it is about connecting the devices to the internet such as sensors, wearable, medical device
 * appliances etc so that they can exchange the data over the internet and can be controlled
 * and monitored remotely.
 *
 * the devices like hand band , wearables , medical devices uses bluetooth  or wifi
 * connectivity to operate these system with mobile phone.
 *
 * Bluetooth are of two types.
 * 1.classic bluetooth
 * used for headphones
 * speaker
 * file transfers
 *
 * has higher bandwidth
 * 2.BLE (Bluetooth Low Energy)
 * fitness bands
 * smart watches
 * heart rate monitors
 * medical devices
 */

/**
 * what is SOLID principle?
 * SOLID principle is a design principle which enables us to manage the most of the software
 * problems.
 * The term SOLID is an acronym for the 5 design principle intended to make software design
 * more understandable , maintainable , and flexible.
 * SOLID acronym was first introduced by Michael Feathers.
 * S.single responsibility
 * O.open close principle
 * L.Liskov substitution principle
 * I.Interface segregation principle
 * D.Dependency inversion principle
 */

/**
 * Single responsibility principle.
 * "it says a class should have only one reason to change"
 * every module or class should have responsibility over a single part of the functionality
 * provided by the software, and that responsibility should be entirely encapsulated by
 * the class.
 * it makes the code loosely coupled and makes it easier to test, maintain , scale and reuse.
 * easier testing.
 * easier debugging.
 * better readability.
 */
 class UserManager{
    fun saveUser(user : String){
        print(user)
    }

    fun sendEmail(user :String){
        print("send email to $user")
    }

    fun generateReport(user : String){
        println("generating report for $user")
    }
 }

/**
 * this class UserManager has 3 reasons to change
 * 1.saving user into db
 * 2.sending email
 * 3.generating report
 *
 * so this violates the Single responsibility principle.
 * we can break this class into three different classes.
 * now these classes follows the single responsibility principle.
 */
class UserRepository{
    fun saveUser(user : String){
        println("save user $user")
    }
}

class EmailService{
    fun sendEmail(user : String){
        println("sending email to $user")
    }
}

class ReportGenerator{
    fun generateReport(user : String){
        println("generating report :$user")
    }
}



/**
 * Open close principle
 * it says a class should be open for extension but close for modification.
 * it means that new behaviour can be added to the class without modifying the code by extension.
 * in the example below there is a problem that when ever new type of payment method
 * will come like wallet then we have to modify the codes have to add the one more condition
 * that will modify the code so it is violating the open close principle.
 */

class PaymentProcessor{
    fun pay(type : String){
        if(type == "card"){
            println("pay with $type")
        }else if (type == "upi"){
            println("pay with $type")
        }
    }
}
/**
 * it can be solved using the abstraction
 */

interface  Payment{
    fun pay()
}
class CardPayment: Payment {
    override fun pay() {
        TODO("Not yet implemented")
    }
}

class UpiPayment : Payment {
    override fun pay() {
        TODO("Not yet implemented")
    }
}

class PaymentManager (private val paymentMethod : Payment){
    fun pay(){
        paymentMethod.pay()
    }
}
/**
 * in future if new type of payment comes into the picture then we can simply create the class
 * for that and pass the instance to the payment  manager class.
 * this will not modify the single line of code and will add the new behaviour just by
 * extending the class.
 */
class PayPalPayment : Payment{
    override fun pay() {
        TODO("Not yet implemented")
    }
}

/**
 * Liskov substitution principle
 * it says that the derived class instance should be able to replace the base class instance.
 */
 open class Bird{
    open fun fly(){}
 }
 class Sparrow : Bird(){
     override fun fly() {
         println("fly")
     }
 }

class Ostrich : Bird(){
    override fun fly() {
        throw Exception("ostrich cant fly")
    }
}
/**
 * ostrich is a bird but cant fly so this breaks the liskov substitution principle.
 * better design is using the interfaces.
 * now this will not break the liskov substitution principle.
 */
interface Aves

interface FlyingAves{
    fun fly()
}

class SparrowG : Aves , FlyingAves{
    override fun fly() {
        TODO("Not yet implemented")
    }
}

class OstrichG : Aves

/**
 * Interface segregation principle
 * it says that a class should not be forces to depend on those methods which it does not uses.
 * it means we should prefer the small focused interfaces instead of messy bigger interfaces.
 * example below is breaking the interface segregation principle because junior developer has
 * no need to depend on the testing, deployment, manage teams .
 */

interface Worker{
    fun code()
    fun test()
    fun deploy()
    fun manageTeam()
}

class JuniorDeveloper : Worker{
    override fun code() {
        TODO("Not yet implemented")
    }

    override fun test() {
        TODO("Not yet implemented")
    }

    override fun deploy() {
        TODO("Not yet implemented")
    }

    override fun manageTeam() {
        TODO("Not yet implemented")
    }

}
/**
 * better would be if we can break the functionality into different smaller interfaces with
 * focused functionality.
 * now the whole functionality is divided into smaller interfaces with focused functionality.
 */

interface Coder{
    fun code()
}
interface Tester{
    fun test()
}
interface Deployer {
    fun deploy()
}
interface Manager {
    fun manageTeam()
}

/**
 * Dependency inversion principle
 * it says that high level module should not depend on the low level modules
 * both should depend on the abstraction.
 * it means depend on the contraction not on the concrete implementation.
 */
class WiredKeyboard {
    fun type() {
        println("Typing")
    }
}
class Computer {

    private val keyboard = WiredKeyboard()

    fun start() {
        keyboard.type()
    }
}
/**
 * here computer is tightly coupled with the keyboard class.
 * it cannot easily replace the keyboard.
 * cannot test.
 * cannot extend.
 *
 * dip is achieved by dependency injection.
 */
interface Keyboard{
    fun type()
}
class WireKeyboard : Keyboard{
    override fun type() {
        TODO("Not yet implemented")
    }
}
class BluetoothKeyboard : Keyboard{
    override fun type() {
        TODO("Not yet implemented")
    }
}

class Computers(private val keyboard: Keyboard){
    fun type(){
        keyboard.type()
    }
}

/**
 * what are the best coding practices should we take to have beautiful code ?
 * for an android developer good coding practices is not just about the clean code.
 * it affects scalability, maintainability, performance, team collaboration, debugging
 * and production stability.
 *
 * 1.writing readable code
 * we should write variable name, function name and class name readable and which actually
 * make sense.
 * class -->> PascalCase
 * variable -->> camelCase
 * function -->> camelCase
 * constants -->> UPPER_CASE
 * interface -->> Describe behaviour
 *
 * 2.follow Single responsibility principle
 * each class should have focused functionality.
 *
 * 3.write small function
 * a function should do one logical thing.
 *
 * 4.Avoid God Classes
 * we should avoid a class which knows every thing instead should have
 * different classes.
 *
 * 5.Use interfaces and abstraction.
 * we should use as much as abstraction using the interfaces.
 *
 * 6.Avoid hardcoding
 *
 * 7.avoid deep nesting
 *
 * 8.do not ignore errors silently
 *
 * 9.write reusable code
 *
 * 10.use immutable data whenever possible
 *
 * 11.separate ui from business logic to have separation of concern.
 *
 * 12.use proper architecture
 *
 * 13.comment why or why not
 *
 * 14.avoid massive constructor
 *
 * 15.apply consistent formatting
 *
 * 16.use dependency injection
 *
 * 17.write testable code
 *
 * 18.use lifecycle aware components
 */

/**
 * how do you take the ownership?
 * Taking the ownership actually means treating the product, feature, bug, as your responsibility
 * from start to finish not just writing code.
 * and I have actually done this taking ownership and have experience in this because recently
 * i did internship at Adgama digital where i was developing the whole application from
 * scratch to working and i was taking the decision related to architecture, user interface
 * reactiveness and user interface and i myself was taking care of bug so i have experience
 * and i love taking decisions and take the ownership of product and i find it challenging
 * and also it gives so much confidence when you actually execute without having any fault
 * even if you fail to meet the requirement you learn so much for the future about what not
 * to do to avoid the failure.
 * and also currently i am doing internship remotely in a startup where i am taking ownership
 * of the features and till now i have raised 5 prs and 3 prs have been merged and 2 are on the
 * way to get merged.
 *
 * eg.lets say manager says develop the login screen.
 * so as taking ownership does not means that build ui, plug the loginscreen with viewmodel,
 * configure firebase then push code instead it means it should have -
 * proper validation
 * should have loding state
 * it should handle the error not let it go silently
 * testability
 * retry
 */

/**
 * How do you think as an engineer?
 * thinking like an engineer means solving problems systematically, logically and responsibly
 * while balancing the correctness, scalability, maintainability and user experience.
 *
 * engineer thinking process-
 * 1.understand the problem.
 * 2.breaking big problems into smaller ones.
 * 3.Think about the tradeoff-> which one to use, what would be benefit.
 * 4.Thinking about the failure scenario.
 * 5.Thinking about scalability.
 * 6.Thinking about the maintainability.
 * 7.Thinking about the performance.
 * 8.thinking about the architecture.
 * 9.Thinking about the adaptability of code when new feature is to be added.
 */

/**
 * How will you take the architecture decision?
 * Architecture is a way to organise the code such that it remains maintainable,
 * testable,scalable and adaptive to new features and does not make messy code when
 * new feature is being added to the project.
 *
 * and architecture decision is taken on the basis of project ,
 * first will try to understand the problem, then will think about the size of the
 * project and complexity of project based on these parameter we can decide the architecture.
 *
 * for smaller project we can have MVI but when we talk about bigger project we can have
 * combination of MVVM and MVI with clean architecture.
 */

/**
 * How do you manage the stress?
 * I try to manage the stress by breaking the problem into systematically instead of reacting
 * emotionally.
 * When i face pressure , i first break the problem into smaller task and prioritize what is
 * most important. If something is blocking the progress, I communicate early instead of
 * waiting until the last moment.
 * In technical work stress often comes from uncertainty, so i focus on understanding the
 * root cause, reproducing issues carefully and solving them step by step.I also ensure
 * proper planning and avoid last minute chaos by tracking task and deadlines.
 */

/**
 * What will you contribute if you get selected ?
 * If I get selected i will join as an android developer and will work with android team
 * and currently i will first tell the QA team about the UI bug that i showed you and will
 * brainstorm the ideas with the senior manager and will communicate if any idea comes to mind
 * about the new feature.
 * Currently i have seen our application and noticed lazy boarding screen will try to
 * communicate about that and will fix that.
 */


/**
 * How will you find yourself in fast paced startup environment ? since we are startup
 * we do ship features early .
 * I already have experience of fast paced startup where we do daily shipping code and i find
 * myself this situation challenging and it will some how test my limit and i would take it
 * positively and will approach with positive mindset will learn and contribute and grow
 * with the same.
 */


/**
 * How will you manage the work life balance?
 * work life balance is actually very important aspect of our life since Janitri is a
 * MedTech innovation organisation whose focus is on maternal health and fetal health then
 * its employee should also have some work life balance and i will ensure this by having
 * proper sleep cycle, being involved in sports like gym, badminton , cricket or football
 * on the weekends.I am also a person who loves sport.
 */


/**
 * How do you take leadership and what are the leadership quality?
 * Leadership qualities-->>
 * 1.communication
 * 2.taking responsibility
 * 3.decision making
 * 4.problem solving mindset
 * 5.technical clarity
 * 6.takes initiative
 * 7.able to handle pressure
 *
 *
 * I think leadership is not about only being senior,managing people and giving orders.
 * I believe it is about taking the ownership, communicating with the people even brainstorming
 * when needed and have problem solving mindset with enthusiastic behaviour toward new
 * things.
 * have technical clarity and being able to decide which one to choose and which one will
 * impact and will be scalable.
 */

/**
 * How to optimise the application ?
 * optimising the application is a huge engineering topic-
 * it affects the -
 * user experience
 * startup time
 * ui reactiveness
 * user retention
 * ANRs
 * battery draining
 * app rating
 * all these things comes under the performance tag and i can improve the these by--
 * 1.avoiding memory leak
 * 2.keeping main thread only for the user interface
 * 3.avoid using main thread for long running tasks
 * 4.by optimizing the lazy columns or recycler view
 * 5.by minimising the number of recomposition using the derived state and immutable instances.
 * 6.by using the pagination for large list of data
 * 7.by optimizing the layout hierarchy
 * 8.by optimizing the startup time
 * 9.by using coroutines properly
 * 10.by using the caching
 * 11.optimize the database usage
 */


/**
 * How will you debug the crashes?
 * debugging crashes means when user uses some feature of application it might not behave
 * the way it should behave and expected in these situation we need to debug the issue by
 * having the log statement and logging, by reading the traces it produces and going to
 * the root level and actually identifying the issue and then isolating that issue.
 * we have firebase crashylitics for this which gives crash reports
 * handling the crashes then carefully and gracefully.
 */


/**
 * What should we check before releasing the application to production?
 * before release a good engineer or developer would be thinking about--
 * functional testing -- feature perfectly works or not.
 * stability-- no major crashes happens
 * performance -- smooth and efficient
 * security -- sensitive data protected
 * compatibility -- across device it runs smoothly
 * UX callout -- better user experience
 */

/**
 * What is clean architecture and why do we need clean architecture ?
 * clean architecture is a software design architecture that helps build applications
 * which are ->
 * scalable
 * maintainable
 * testable
 * modular
 * independent of framework
 * it was popularised by Robert C.Martin
 *
 * core goal of clean architecture-->>>
 * biggest goal is separation of concern--
 * it says each layer should have clear responsibility, minimal coupling, independent evolution.
 *
 * we need clean architecture because without the clean architecture application will become-
 * messy
 * hard to maintain
 * difficult to test
 * tightly coupled
 * difficult to scale
 * buggy
 *
 * it has three different layers which makes it easy to maintain and scale the code-->>
 * data layer
 * domain layer
 * presentation layer
 *
 * 1.presentation layer
 * responsible for user interaction,UI,state handling and it contains ViewModel, Activity
 * Fragment, Compose Ui.
 * it observes state exposed from the viewModel.
 * Handles UI events
 * Render data
 *
 * 2.domain layer
 * responsible for having the pure kotlin code and to create the abstraction.
 * it contains business logic, rules, use cases, interfaces,models.
 * this layer is independent of framework.
 *
 * 3.data layer
 * responsible for fetching data, caching data, APIs cal, database
 * it contains retrofit, room,repository implementation.
 */

/**
 * packaging structure
 *
 * com.example.audioconverter
 *
 * ├── app
 * │
 * ├── core
 * │   ├── common
 * │   ├── constants
 * │   ├── dispatcher
 * │   ├── extensions
 * │   ├── logger
 * │   ├── network
 * │   ├── ui
 * │   ├── utils
 * │   ├── result
 * │   └── designsystem
 * │
 * ├── di
 * │
 * ├── domain
 * │   ├── model
 * │   ├── repository
 * │   └── usecase
 * │
 * ├── data
 * │   ├── remote
 * │   │   ├── api
 * │   │   ├── dto
 * │   │   ├── mapper
 * │   │   └── datasource
 * │   │
 * │   ├── local
 * │   │   ├── dao
 * │   │   ├── entity
 * │   │   ├── database
 * │   │   └── datasource
 * │   │
 * │   ├── repository
 * │   │
 * │   └── mapper
 * │
 * ├── mediaengine
 * │   ├── ffmpeg
 * │   ├── command
 * │   ├── parser
 * │   ├── codec
 * │   ├── session
 * │   └── worker
 * │
 * ├── feature_home
 * │   ├── presentation
 * │   │   ├── ui
 * │   │   ├── component
 * │   │   ├── state
 * │   │   ├── event
 * │   │   └── viewmodel
 * │   │
 * │   └── navigation
 * │
 * ├── feature_converter
 * │   ├── presentation
 * │   │   ├── ui
 * │   │   ├── component
 * │   │   ├── state
 * │   │   ├── event
 * │   │   └── viewmodel
 * │   │
 * │   ├── domain
 * │   │   ├── model
 * │   │   └── usecase
 * │   │
 * │   ├── data
 * │   │   ├── repository
 * │   │   ├── datasource
 * │   │   └── mapper
 * │   │
 * │   └── navigation
 * │
 * ├── feature_history
 * │
 * ├── feature_player
 * │
 * └── service
 *     ├── notification
 *     └── foreground
 */

/**
 * why do you want to work with Janitri?
 *
 * Janitri is a medtech innovation company founded in 2016.it provides maternal
 * and fetal care and they develop devices for fetal and child care and builds
 * software for connecting with the application.and their main goal is to not
 * let any child or mother die because of difficulties occur during the the phase
 * of pregnancy and after birth.
 * and  i would say they are solving real world problem and me as
 * android developer find my interest in working with janitri and one
 * reason is that they are product oriented startup environment where i will be
 * learning about taking the product ownership and leadership with deep down
 * understanding of android architecture which will help me build scalable,
 * testable ,optimized smooth and better user experience application.
 */

