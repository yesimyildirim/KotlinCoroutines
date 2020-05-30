package com.yesimyildirim.kotlincoroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    var userName=""
    var userage=0

    runBlocking {

        val downloadName=async {
            downloadName()
        }
        val downloadAge = async {
            downloadAge()
        }
        userName=downloadName.await()
        userage= downloadAge.await()

        println("${userName} ${userage}")
    }
}

suspend fun downloadName():String {
    delay(2000)
    val userName ="Atil:"
    println("username download")
    return userName

}

suspend fun downloadAge():Int{
    delay(4000)
    val userAge=60
    println("userage download")
    return  userAge
}