package common.string

import androidx.compose.runtime.staticCompositionLocalOf

val LocalStrings = staticCompositionLocalOf {
    EnString
}

data class Strings(
    val hello: String,
)
