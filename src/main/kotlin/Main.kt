import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            var testX: Int by remember { mutableStateOf(0) }
            Button(
                //das ist ein lambda
                onClick = {
                    ->
                    model.Increment()
                    testText = "Hello, Desktop!" + model.Counter
                    testX = model.Counter * 10

                },
                content = {
                    //wir setzten text auf einen speicherbereich names testText, wenn sich testText ändert, ändert sich auch der dargestellte text automatisch
                    ->
                    Text(text = testText)
                },
                modifier = Modifier.offset(x = testX.dp, y = 100.dp)
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





