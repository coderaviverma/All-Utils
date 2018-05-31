package com.aw.avi.allutilsmethodsapp.ui.activity.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.aw.avi.allutilsmethodsapp.R

open class KotlinBasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basic)
        myappfirst()

//        defineValues()
        arrayFunctions()


        Toast.makeText(this, "Kotlin Acivity", Toast.LENGTH_SHORT)
    }


    init {
    println("First initializer Block")
    }

    fun myappfirst() {
        println("my first kotlin method")
    }


    fun defineValues() {

        var name = "Avi"

        var myAge = 25

        val bigInt = Int.MAX_VALUE

        println(bigInt)
    }


    fun arrayFunctions(): String {
        var myArray = arrayOf(1, 2, 3, "avi")

        println(myArray)
        println(myArray[2])

        myArray[2] = 95

        println("Array Length ${myArray.size}")


        println("Replace in array ${myArray[2]}")

        println(myArray.contains("avi"))


        val partArray = myArray.copyOfRange(1, 3)


        println("You $ partarray  $partArray")

        println("First ${myArray.first()}")

        println("Avi Index ${myArray.indexOf("avi")}")


        var sqrValue = Array(5, { x -> x * x })

        println("Square Value of " + sqrValue[3])

        return "array expressions"
    }


    fun ranges() {

        var oneTo10 = 1..10

        var alpha = "A".."Z"

        println("R" in alpha)

        var tenTo1 = 10.downTo(1)

        val tenTo1l = 10.downTo(1)


        for (x in tenTo1l) print("For loop $x")

        println("var :" + tenTo1)
        println("val :" + tenTo1l)

    }


    fun operators() {

//        Conditional Operator
//        > < <= >= != ==
//        Logical Operator
//        && || !
        var age: Int = 5

        when (age) {

            1, 2, 3, 4 -> println("At School")

            5 -> println("At high school")

            in 6..10 -> {

            }
        }

    }


    fun loopings() {

        for (x in 1..10) {

            println("Looping $x")
        }

    }

}
