package com.kaos.klogger

import android.util.Log

/**
 * Created by elial on 2/26/2018.
 *
 * Description:
 *
 */
inline infix fun <reified T> T.tryLog(f: () -> Unit) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }

    try { tag i(f) } catch(e: Exception) {
        tag e e.message!!
    }
}

/** Info **/
//String
inline infix fun <reified T> T.i(mess: String) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.i(tag,mess)
}
//Lambda
inline infix fun <reified T> T.i(call: () -> Any?) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.i(tag,"${call()}")
}

/** Debug **/
//String
inline infix fun <reified T> T.d(mess: String) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.d(tag,mess)
}
//Lambda
inline infix fun <reified T> T.d(call: () -> Any?) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.d(tag,"${call()}")
}

/** Error **/
//String
inline infix fun <reified T> T.e(mess: String) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.e(tag,mess)
}
//Lambda
inline infix fun <reified T> T.e(call: () -> Any?)  {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }

    Log.e(tag,"${call()}")
}

/** VERBOSE **/
//String
inline infix fun <reified T> T.v(mess: String) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.v(tag,mess)
}
//Lambda
inline infix fun <reified T> T.v(call: () -> Any?)  {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.v(tag,"${call()}")
}

/** WARN **/
//String
inline infix fun <reified T> T.w(mess: String) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.w(tag,mess)
}
//Lambda
inline infix fun <reified T> T.w(call: () -> Any?) {
    val tag = when (this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.w(tag, "${call()}")
}

