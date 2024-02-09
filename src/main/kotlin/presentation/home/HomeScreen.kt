package presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.HistoryScreen

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<HomeScreenModel>()
        val token by screenModel.token.collectAsState()
        Column {

            TextField(
                value = token,
                onValueChange = {
                    screenModel.updateToken(it)
                }
            )
            Button(
                onClick = {
                    navigator.push(HistoryScreen())
                }
            ) {
                Text("Go to History")
            }
        }

    }
}