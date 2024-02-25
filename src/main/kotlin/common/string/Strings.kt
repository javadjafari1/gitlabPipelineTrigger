package common.string

import androidx.compose.runtime.staticCompositionLocalOf

val LocalStrings = staticCompositionLocalOf {
    EnString
}

data class Strings(
    val hello: String,
    val appName: String,
    val welcomeToGitFast: String,
    val enterYourGitlabAddress: String,
    val correctYourAddress: String,
    val enterYourToken: String,
    val enterTokenCorrectly: String,
    val howToCreateToken: String,
    val signIn: String,
)
