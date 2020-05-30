package com.yesimyildirim.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness
       /* GlobalScope.launch {
            repeat(100000){
                launch {
                    println("android")
                }
            }
        }*/
        //Scope
        //Global Scope ,runBlocking,CoroutineScope
/*
        println("run blocking start")
        runBlocking {
            launch {
                delay(2000)
                println("run blocking")
            }
        }
        println("run blocking end")

 */
       /* println("global scope start")
        GlobalScope.launch {
            delay(5000)
            println("global scope")
        }
        println("global scope end")

        */
        //CoroutineScope
        //Context
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("coroutine scope end")
    }

}
