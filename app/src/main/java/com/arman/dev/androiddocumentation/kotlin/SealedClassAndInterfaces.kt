package com.arman.dev.androiddocumentation.kotlin

/**
 * Sealed class and Interfaces.
 */

/**
 * sealed class is a type of class that gives controlled inheritance in its hierarchies.
 * all the subclasses are known at the compile time.
 * no other subclasses may appear outside the package and module within which sealed class
 * is defined.
 *
 * when we combine the sealed classes or interfaces with when statement, we can cover all
 * possible types safely.
 *
 * sealed class are best use for these scenarios.
 * 1.limited subclasses;
 * we have predefined set of subclasses which extends the class and are known at the compile time.
 *
 * 2.type safe design is required;
 *
 * 3.working with the closed APIs;
 *
 * we generally uses sealed class to configure the ui states , intents , events.
 * a sealed class itself is abstract means it cant be instantiated but it has constructor which is for
 * the direct subclasses of the sealed class.
 *
 * we can use enum classes within our sealed classes.
 * constructor of sealed class can have two visibility modifier
 * 1.protected (by default)
 * 2.private
 */

/**
 * Difference between the sealed class and sealed interface.
 *
 * sealed class and sealed interface both provide controlled inheritance.
 *
 * sealed class can have the constructor
 * can have the states
 * enum class cant extend the sealed class,
 * support single inheritance
 *
 * sealed interface does not uses constructor
 * supports multiple inheritance
 * cant have state
 * enum can extend sealed class
 */

sealed interface  Error
sealed class IOError : Error
class FileReadError (val error : String) : IOError()
class DatabaseError (val error : String) : IOError()


sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: String) : UIState()
    data class Error(val exception: Exception) : UIState()
}

fun updateUI(state: UIState) {
    when (state) {
        is UIState.Loading -> {}
        is UIState.Success -> {}
        is UIState.Error -> {}
    }
}
