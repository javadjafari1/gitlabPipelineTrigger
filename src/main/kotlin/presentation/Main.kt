package presentation

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import data.di.appModules
import org.koin.core.context.GlobalContext.startKoin
import presentation.home.HomeScreen

fun main() = application {
    startKoin {
        modules(appModules())
    }

    Window(onCloseRequest = ::exitApplication) {
        Navigator(HomeScreen())
    }
}
