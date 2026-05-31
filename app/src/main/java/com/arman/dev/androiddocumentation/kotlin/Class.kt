package com.arman.dev.androiddocumentation.kotlin

/* class in kotlin________________________________________________ */

/**
 * like other object oriented programming kotlin also has classes and object concept.
 * Kotlin uses classes to encapsulate data (properties) and behavior (functions) for
 * reusable, structured code.
 * class is a blue print or template for an object which we create using the constructor.
 * when we create an instance we are creating a concrete object based on the template.
 *
 * properties inside the class is by default public.
 * class in kotlin is by default close means you cant extend it without specifying open.
 * we can keep property in the constructor of the class and default value can be provided.
 */

class HomoSapiens(){}
class Human(val name : String = "human")

/*
 constructor in kotlin_____________________________________
 in kotlin there are two type of constructor
 1.primary constructor
 2.secondary constructor

 1.primary constructor is the main way to initialize the class.
 we declare it in the header of class. eg.class X() in this way.
 The primary constructor sets up the initial state of an instance when it's created.
 If the primary constructor doesn't have any annotations or visibility modifiers,
 you can omit the "constructor" keyword:
 The primary constructor can declare parameters as properties.
 These constructor parameter properties are stored as part of
 the instance and are accessible from outside the class.

 we can also declare parameter in the constructor which are not the properties of
 class and cant be accessed with the instance and these parameter need to be assigned to
 some properties of the class.

 class Human(name:String){
 val myName :String = name
 }
this is the parameter and it is not associated with the instance of the class.
it need to be assigned to the class's property.and it is accessible inside the class body only.
properties in the class constructor is accessible to the member function of the class.
parameters in the constructor are not accessible in the member function of the class because member function are
executed at the runtime and parameters are not associated with the instance so how will member function will
get the parameter?



 2.secondary constructor provides additional initialization logic.
 we declare it in the body of class.

 Both primary and secondary constructors are optional, but a class
 must have at least one constructor.


 */

class PersonWithAssignment(name: String){
    val myName : String = name
}


/**
 * initializer block
 *
 * initializer block is a block which is used to add some logic operation during the instance creation
 * this block runs when primary constructor executes.
 * declared with init{}. init followed by curly braces.
 *
 * we can have as many initializer block, they will run in the order they appears to be in the class.
 * we can use primary constructor properties and parameters in the init block.
 */

class NoteBook(val pages:Int){
    fun getNumberPages():Int{
        return pages
    }

    init {
        println("number of pages:$pages")
    }

    init {
        println("end of the class")
    }
}

/**
 * secondary constructor
 *
 * secondary constructor are the additional constructor that a class can have beyond the primary constructor.
 * they are useful when we need to initialize the class with different ways.
 */

class Copy(val pages:Int, val cost : Int){

    init {
        println("initializer 1")
    }

    constructor(pages:Int , cost: String):this(pages , cost.toIntOrNull()?:0) {
        println("secondary constructor when cost is string")
    }

    init {
        println("initializer 2")
    }

    constructor(pages : String , cost: String):this(pages.toIntOrNull()?:0 ,cost.toIntOrNull()?:0){
        println("secondary constructor when cost and pages are string")
    }

    init {
        println("initializer 3")
    }

}

/**
 * at first primary will get execute then initializer block then secondary constructor will get execute.
 * flow is that user create object and passes argument and based on that it will go to the secondary constructor
 * and secondary constructor will call primary and then initializer block then anything inside the curly braces
 * of the secondary constructor.
 *
 * In Kotlin, secondary constructors must delegate to the primary constructor. This delegation ensures that all
 * primary constructor initialization logic is executed before any secondary constructor logic runs.
 *
 * constructor delegation can be direct or indirect means one secondary calls to other and then primary or
 * directly one secondary calls to the primary ones.
 *
 *
 * In classes with initializer blocks (init {}), the code within these blocks becomes part of the primary constructor.
 * Given that secondary constructors delegate to the primary constructor first, all initializer blocks and property
 * initializers run before the body of the secondary constructor. Even if the class has no primary constructor,
 * the delegation still happens implicitly:
 */

class Brush(val name : String , val size : Int){

    init {
        println("initializer block 1")
    }

    constructor():this("brush"){
        println("constructor with no parameter")
    }

    constructor(name : String):this(name , 10){
        println("constructor with name parameter")
    }

    init {
        println("initializer block 2")
    }


    init {
        println("initializer block 3")
    }

    /**
     * when instance is created with nothing passed in instance.
     * constructor having no parameter will be first called then it will delegate above to one has
     * one parameter then that will call the primary and then initializers will be called in order
     * then code inside the constructor will get executed in order opposite to which they were called.
     *
     * output-->>
     * initializer1
     * initializer2
     * initializer3
     *
     * constructor with name
     * constructor with no parameter.
     */
}

/**
 * abstract classes__________________________________________
 *
 * in kotlin abstract class is the class that cant be instantiated directly.
 * they are designed to be inherited by other classes which define their actual behaviour.
 * An abstract class can declare abstract properties and functions, which must be implemented by subclasses.
 *
 * Abstract classes can also have constructors. These constructors initialize class properties
 * and enforce required parameters for subclasses. Declare an abstract class using the abstract keyword:
 *
 * an abstract class can have abstract as well as concrete properties and methods.
 * we do not need to specify the abstract class with open keyword since it is by default inheritable.
 *
 * Abstract members don't have an implementation in the abstract class.
 * You define the implementation in a subclass or inheriting class with an override function or property:
 */

abstract  class WritingTool(val cost: Int,val name: String){
    abstract fun getNameAndCost()
    fun printNameAndCost(){
        println("$cost, $name")
    }

    init {
        println("initializer in abstract class")
    }
}

class Pen(cost :Int , name :String): WritingTool(cost,name){
    override fun getNameAndCost() {
        println("name is $name")
        println("cost is $cost")
    }

    init {
        println("initializer in the Pen class")
    }
}

/**
 * initializer block in the abstract class will be running first.
 * then in the Pen class it will run.
 */



fun main(){
    val objHomeSp = HomoSapiens() //creating an instance of the HomoSapiens
    val objHuman = Human()//default value will get used
    val objNoteBook = NoteBook(20)//creating an instance of the NoteBook Class
    val objCopy1 = Copy(1,2)
    val objCopy2 = Copy(1,"2")
    val objCopy3 = Copy("1" , "2")
    val objBrush1 = Brush()
    val objPen = Pen(2,"balaji")
}