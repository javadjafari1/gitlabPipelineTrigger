package presentation

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.navigator.Navigator
import common.AppConstants
import common.string.EnString
import common.string.FaString
import common.string.LocalStrings
import data.di.appModules
import org.koin.core.context.GlobalContext.startKoin
import presentation.home.HomeScreen

fun main() = application {
    startKoin {
        modules(appModules())
    }

    Window(onCloseRequest = ::exitApplication) {
        val lyricist = rememberStrings(
            currentLanguageTag = AppConstants.EN_LOCAL,
            translations = mapOf(
                Pair(AppConstants.EN_LOCAL, EnString),
                Pair(AppConstants.FA_LOCAL, FaString)
            )
        )

        ProvideStrings(lyricist, LocalStrings) {
            Navigator(HomeScreen())
        }
    }
}
