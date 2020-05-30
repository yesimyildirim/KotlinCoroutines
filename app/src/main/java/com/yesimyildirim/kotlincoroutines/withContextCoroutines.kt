package com.yesimyildirim.kotlincoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking (Dispatchers.Default){

        println("Context: ${coroutineContext}")
        withContext(Dispatchers.IO){
            println("Context:${coroutineContext}")
        }
    }
}