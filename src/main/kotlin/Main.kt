import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import test.Model

@Composable
@Preview
fun App(model: Model) {
    var testText: String by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            model.Increment()
            testText = "Hello, Desktop!"+model.test
        }) {
            Text(testText)
        }
    }
}

fun main() {
    val model: Model = Model()
    val gameThread: Thread = Thread(model)
    gameThread.start()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App(model)
        }
    }
}





