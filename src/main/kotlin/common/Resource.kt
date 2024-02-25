package common

import androidx.compose.runtime.staticCompositionLocalOf

val LocalResources = staticCompositionLocalOf { appResources }

data class Resource(
    val logo: String,
    val visibilityOn: String,
    val visibilityOff: String,
    val loginIllustration: String,
)

internal val appResources = Resource(
    logo = "drawable/ic_logo.png",
    visibilityOn = "drawable/ic_visibility_on.xml",
    visibilityOff = "drawable/ic_visibility_off.xml",
    loginIllustration = "drawable/login_illustration.png"
)
