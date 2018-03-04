package com.kaos.example

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.kaos.klogger.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener {
            test()

            Snackbar.make(it, "Logged", Snackbar.LENGTH_LONG)
                    .setAction("Ok, I wil see the logs", null).show()
        }
    }

    fun test() {
        this d "That's cool"
        //on Any variable
        Example.pizza i "I want to eat you"

        Example i {
            pizza d {
                "type: $type good? $good"
            }
            pizza
        }

        i {
            Example.doSomething() //doSomething and Log the result
        }
        // or
        i {"Pizza"} //where Pizza can be Any? variable

        //with custom tags
        "myTag" e "pizza is too good"
        "myTag" i {
            Example.eatPizza() //or "eatPizza" like before
        }

        //also d, e, w ,v and wtf

        //Try also this
        Example tryLog {
            eatPizzaWithException() //doSomething and then log any Exception
        }

        logTime {
            (1..100).sumBy { it + 1 }
        }
    }

    object Example {
        data class Pizza(val type: String, val good: Boolean)

        val pizza = Pizza("Pepperoni", true)

        fun doSomething() = "Something done"
        fun eatPizza() = 42

        fun eatPizzaWithException() {
            throw Exception("Error while eating pizza")
        }

    }

}

