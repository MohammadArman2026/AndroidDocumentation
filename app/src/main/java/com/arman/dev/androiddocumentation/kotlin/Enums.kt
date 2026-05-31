package com.arman.dev.androiddocumentation.kotlin

/**
 * Enum class.
 * Enum is a type of class that lets developer to define type safe enum constant.
 * each enum is an instance.
 * enum class can implements the interfaces.
 */

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}