package com.kaos.klogger

import android.util.Log
import com.kaos.klogger.Methods.*
import java.util.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * Created by elial on 2/26/2018.
 *
 * Description:
 *
 */
enum class Methods { Info, Error, Debug, Verbose, Warn, Wtf }

/** Standard Tag **/
val Any?.TAG: String
    get() = when(this) {
        is String, Int -> toString()
        is Any -> this::class.java.simpleName
        else -> "null"
    }

/** Base Method **/
fun Any?.log(method: Methods, message: Any? = null) = when(method) {
    Info -> Log.i(TAG, message.toString())
    Error -> Log.e(TAG, message.toString())
    Debug -> Log.d(TAG, message.toString())
    Verbose -> Log.v(TAG, message.toString())
    Warn -> Log.w(TAG, message.toString())
    Wtf -> Log.wtf(TAG, message.toString())
}

/** Try catch **/
inline infix fun <T> T.tryLog(f: T.() -> Any?) =
        try { this i f } catch(e: Exception) {
            this e e.message
        }

/** Log result and time **/
infix fun <T> T.logTime(f: T.() -> Any?) {
    i { "result: ${f()}, time: ${measureNanoTime {f()}}ns" }
}

/** Info **/
//String
infix fun Any?.i(mess: Any?) = log(Info,mess)

//Lambda
inline infix fun <T> T.i(call: T.() -> Any?): Any? = log(Info,call())

/** Debug **/
//String
infix fun <T> T.d(mess: Any?) = log(Debug,mess)

//Lambda
inline infix fun <T> T.d(call: T.() -> Any?) = log(Debug,call())

/** Error **/
//String
infix fun <T> T.e(mess: Any?) = log(Error,mess)

//Lambda
inline infix fun <T> T.e(call: T.() -> Any?) = log(Error,call())

/** Verbose **/
//String
infix fun <T> T.v(mess: Any?) = log(Verbose,mess)

//Lambda
inline infix fun <T> T.v(call: T.() -> Any?) = log(Verbose,call())

/** Warn **/
//String
infix fun <T> T.w(mess: Any?) = log(Warn,mess)

//Lambda
inline infix fun <T> T.w(call: T.() -> Any?) = log(Warn,call())

/** Wtf **/
//String
infix fun <T> T.wtf(mess: Any?) = log(Wtf,mess)

//Lambda
inline infix fun <T> T.wtf(call: T.() -> Any?) = log(Wtf,call())

