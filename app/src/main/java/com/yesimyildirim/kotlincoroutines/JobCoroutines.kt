package com.yesimyildirim.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //Job

    runBlocking {
       val myJob = launch {
            delay(2000)
            println("job")
        }
        myJob.invokeOnCompletion {
            println("my job end ")
        }
    }
}