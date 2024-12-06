import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.isActive
import test.Model

@Composable
@Preview
fun App(model: Model) {
    MaterialTheme(
        content = {
            ->
            var testX: Int by remember { mutableStateOf(0) }

            Box(
                content = {
                    ->
                    LaunchedEffect(true) {
                        while (isActive) {
                            withFrameMillis(onFrame = { it: Long -> it })
                            testX = model.Counter
                        }
                    }
                },
                modifier = Modifier.offset(x = testX.dp, y = 10.dp).size(50.dp).clip(RectangleShape).background(Color.Red),
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
                content = { -> App(model) },
                onKeyEvent = { keyEvent ->
                    if (keyEvent.key == Key.A) {
                        model.ProcessKeyPressed(Key.A)
                    } else if (keyEvent.key == Key.B) {
                        model.ProcessKeyPressed(Key.B)
                    }

                    return@Window false
                }
            )
        })
}





