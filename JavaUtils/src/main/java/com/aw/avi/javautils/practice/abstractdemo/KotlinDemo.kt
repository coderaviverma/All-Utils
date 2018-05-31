package com.aw.avi.javautils.practice.abstractdemo

/**
 * Created by avinash.verma on 2/12/2018.
 */
class KotlinDemo : MainAbstract() {

    internal override fun inheritanceMethod(string: String): Boolean {
        println("inheritanceMethod Called")

        return false
    }

//    companion object {
//
//        @JvmStatic fun main(args: Array<String>) {
//            println("ExtendedDemo Called")
//
//        }
//    }


}