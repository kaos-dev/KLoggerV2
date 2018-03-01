# KLogger
Expressive, simple yet powerful kotlin logger for Android


## Example usage
```kotlin
fun test() {
    this d "That's cool"
    //on Any variable
    Example.Pizza i "I want to eat you"

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
    tryLog {
        Example.doSomething() //doSomething and then log any Exception
    }
}
```
