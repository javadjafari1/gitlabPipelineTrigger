package common

import androidx.compose.runtime.staticCompositionLocalOf

val LocalResources = staticCompositionLocalOf { appResources }

data class Resource(
    val logo: String,
    val visibilityOn: String,
    val visibilityOff: String,
    val loginIllustration: String,
    val world: String,
)

internal val appResources = Resource(
    logo = "drawable/ic_logo.svg",
    visibilityOn = "drawable/ic_visibility_on.xml",
    visibilityOff = "drawable/ic_visibility_off.xml",
    loginIllustration = "drawable/login_illustration.svg",
    world = "drawable/ic_world.svg",
)
