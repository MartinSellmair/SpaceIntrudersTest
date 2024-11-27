import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import test.Model

@Composable
@Preview
fun App(model: Model) {
    var testText: String by remember<MutableState<String>>(
        calculation = {
            ->
            val mutableStateOf: MutableState<String> = mutableStateOf<String>(value = "Hello, World!")
            return@remember mutableStateOf
        }
    )

    MaterialTheme(
        content = {
            ->
            Button(
                //das ist ein lambda
                onClick = {
                    ->
                    model.Increment()
                    testText = "Hello, Desktop!" + model.test

                },
                //wir setzten text auf einen speicherbereich names testText, wenn sich testText ändert, ändert sich auch der dargestellte text automatisch
                content = { -> Text(text = testText) }
            )
        }
    )
}

fun main() {
    val model: Model = Model()
    val gameThread: Thread = Thread(model)
    gameThread.start()

    application(
        content = {
            ->
            Window(
                onCloseRequest = ::exitApplication,
                content = { -> App(model) }
            )
        })
}





