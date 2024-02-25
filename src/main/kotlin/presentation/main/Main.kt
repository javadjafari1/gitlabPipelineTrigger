package presentation.main

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.navigator.Navigator
import common.AppConstants
import common.string.EnString
import common.string.FaString
import common.LocalResources
import common.string.LocalStrings
import common.appResources
import data.di.appModules
import org.koin.core.context.GlobalContext.get
import org.koin.core.context.GlobalContext.startKoin
import presentation.signup.LogInScreen
import presentation.theme.AppTheme

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
    AppTheme {
        CompositionLocalProvider(
            LocalLayoutDirection provides locale.toLayoutDirection(),
            LocalResources provides appResources
        ) {
            ProvideStrings(lyricist, LocalStrings) {
                val strings = LocalStrings.current
                Window(
                    onCloseRequest = ::exitApplication,
                    title = strings.appName,
                    state = rememberWindowState(
                        placement = WindowPlacement.Floating,
                        position = WindowPosition.Aligned(Alignment.Center),
                        size = DpSize(width = 1440.dp, height = 1024.dp),
                    ),
                ) {
                    Navigator(LogInScreen())
                }
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
