package presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class HistoryScreen : Screen {

    @Composable
    override fun Content() {
        Column {
            val navigator = LocalNavigator.currentOrThrow
            Text("Hello from History")
            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text("Go back")
            }
        }
    }
}
