package com.qohat

import kotlinx.coroutines.*

/**
 * runBlocking generates a Job and that job can be cancelled
 */
fun main() = runBlocking {
    /*val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(2000L)
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    /**
     * job.cancel() and job.join() could be job.cancelAndJoin()
     */
    println("main: Now I can quit.")*/

    /**
     * Cooperative cancelation
     */
    /*val startTime = System.currentTimeMillis()
    val job1 = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job1.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")*/

    /**
     * Computation cancellation using isActive inside the CoroutineScope
     */
    /*val startTime0 = System.currentTimeMillis()
    val job2 = launch(Dispatchers.Default) {
        var nextPrintTime = startTime0
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job2.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")*/

    /**
     *
     */
    val job3 = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job3.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}
