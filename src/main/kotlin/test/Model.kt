package test

class Model : Runnable {
    fun Update() {
        println("running"+test)
    }

    fun Increment(){
        test++
    }

    var test: Int = 0

    override fun run() {
        while(true) {
            Thread.sleep(1000)
            Update()
        }
    }
}
