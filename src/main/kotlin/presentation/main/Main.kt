package presentation.main

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
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
import org.koin.core.context.GlobalContext.get
import org.koin.core.context.GlobalContext.startKoin
import presentation.home.HomeScreen

fun main() = application {
    startKoin {
        modules(appModules())
    }

    val screenModel = get().get<MainScreenModel>()
    val locale by screenModel.locale.collectAsState()
    val lyricist = rememberStrings(
        currentLanguageTag = locale,
        translations = mapOf(
            Pair(AppConstants.EN_LOCAL, EnString),
            Pair(AppConstants.FA_LOCAL, FaString)
        )
    )
    CompositionLocalProvider(LocalLayoutDirection provides locale.toLayoutDirection()) {
        ProvideStrings(lyricist, LocalStrings) {
            val strings = LocalStrings.current
            Window(
                onCloseRequest = ::exitApplication,
                title = strings.appName
            ) {
                Navigator(HomeScreen())
            }
        }
    }
}

private fun String.toLayoutDirection(): LayoutDirection {
    return when (this) {
        AppConstants.FA_LOCAL -> LayoutDirection.Rtl
        else -> LayoutDirection.Ltr
    }
}
