package test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Model : Runnable {
    fun Update() {
        println("running"+Counter)
    }

    fun Increment(){
        Counter++
    }

    //var testX: Int by remember { mutableStateOf(0) }


    var Counter: Int by Delegates.observable(
        initialValue = 0,
        onChange = { property: KProperty<*>, oldValue: Int, newValue: Int -> onChange()
    })

    private fun onChange() {
        //testX = Counter * 10
        println("we move!")
    }

    override fun run() {
        while(true) {
            Thread.sleep(1000)
            Update()
        }
    }
}
