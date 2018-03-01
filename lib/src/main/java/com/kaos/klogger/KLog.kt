package com.kaos.klogger

import android.util.Log

/**
 * Created by elial on 2/26/2018.
 *
 * Description:
 *
 */
inline fun Any.tryLog(f: () -> Unit) {
    try {
        f()
    } catch(e: Exception) {
        this e e.message!!
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
inline infix fun <reified T> T.i(call: T.() -> Any?) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.i(tag,"${call(this)}")
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
inline infix fun <reified T> T.d(call: T.() -> Any?) {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.d(tag,"${call(this)}")
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
inline infix fun <reified T> T.e(call: T.() -> Any?)  {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }

    Log.e(tag,"${call(this)}")
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
inline infix fun <reified T> T.v(call: T.() -> Any?)  {
    val tag = when(this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.v(tag,"${call(this)}")
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
inline infix fun <reified T> T.w(call: T.() -> Any?) {
    val tag = when (this) {
        is String -> this
        else -> T::class.java.simpleName
    }
    Log.w(tag, "${call(this)}")
}