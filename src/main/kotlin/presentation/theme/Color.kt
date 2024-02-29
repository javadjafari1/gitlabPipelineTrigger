package presentation.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val primary10 = Color(0xFF001D32)
private val primary20 = Color(0xFF003352)
private val primary30 = Color(0xFF094B72)
private val primary40 = Color(0xFF2D628B)
private val primary80 = Color(0xFF99CCFA)
private val primary90 = Color(0xFFCDE5FF)

private val secondary10 = Color(0xFF221533)
private val secondary20 = Color(0xFF233240)
private val secondary30 = Color(0xFF394857)
private val secondary40 = Color(0xFF51606F)
private val secondary80 = Color(0xFFB8C8DA)
private val secondary90 = Color(0xFFD4E4F6)

private val tertiary10 = Color(0xFF221533)
private val tertiary20 = Color(0xFF382A4A)
private val tertiary30 = Color(0xFF4F4061)
private val tertiary40 = Color(0xFF67587A)
private val tertiary80 = Color(0xFFD2BFE7)
private val tertiary90 = Color(0xFFEDDCFF)

private val error10 = Color(0xFF410002)
private val error20 = Color(0xFF690005)
private val error30 = Color(0xFF93000A)
private val error40 = Color(0xFFBA1A1A)
private val error80 = Color(0xFFFFB4AB)
private val error90 = Color(0xFFFFDAD6)

private val neutral10 = Color(0xFF181C20)
private val neutral80 = Color(0xFFE0E2E8)
private val neutral99 = Color(0xFFF7F9FF)

private val neutralVariant30 = Color(0xFF42474E)
private val neutralVariant50 = Color(0xFF72787E)
private val neutralVariant60 = Color(0xFF8C9198)
private val neutralVariant80 = Color(0xFFC2C7CE)
private val neutralVariant90 = Color(0xFFDEE3EB)

internal val darkColors = darkColorScheme(
    primary = primary80,
    onPrimary = primary20,
    primaryContainer = primary30,
    onPrimaryContainer = primary90,
    secondary = secondary80,
    onSecondary = secondary20,
    secondaryContainer = secondary30,
    onSecondaryContainer = secondary90,
    tertiary = tertiary80,
    onTertiary = tertiary20,
    tertiaryContainer = tertiary30,
    onTertiaryContainer = tertiary90,
    error = error80,
    onError = error20,
    errorContainer = error30,
    onErrorContainer = error90,
    background = neutral10,
    onBackground = neutral80,
    surface = neutral10,
    onSurface = neutral80,
    surfaceVariant = neutralVariant30,
    onSurfaceVariant = neutralVariant80,
    outline = neutralVariant60,
    inversePrimary = primary40,
    inverseSurface = neutral80,
    inverseOnSurface = Color(0xFF2D3135),
    outlineVariant = neutralVariant30,
    scrim = Color.Black,
    surfaceBright = neutral99,
    surfaceContainer = Color(0xFF1C2024),
    surfaceContainerHigh = Color(0xFF272A2E),
    surfaceContainerHighest = Color(0xFF313539),
    surfaceContainerLow = neutral10,
    surfaceContainerLowest = Color(0xFF0B0F12),
    surfaceDim = Color(0xFF101418),
)

internal val lightColor = lightColorScheme(
    primary = primary40,
    onPrimary = Color.White,
    primaryContainer = primary90,
    onPrimaryContainer = primary10,
    secondary = secondary40,
    onSecondary = Color.White,
    secondaryContainer = secondary90,
    onSecondaryContainer = secondary10,
    tertiary = tertiary40,
    onTertiary = Color.White,
    tertiaryContainer = tertiary90,
    onTertiaryContainer = tertiary10,
    error = error40,
    onError = Color.White,
    errorContainer = error90,
    onErrorContainer = error10,
    background = neutral99,
    onBackground = neutral10,
    surface = neutral99,
    onSurface = neutral10,
    surfaceVariant = neutralVariant90,
    onSurfaceVariant = neutralVariant30,
    outline = neutralVariant50,
    inversePrimary = primary80,
    surfaceTint = neutralVariant80,
    inverseSurface = Color(0xFF2D3135),
    inverseOnSurface = Color(0xFFEEF1F6),
    scrim = Color.Black,
    outlineVariant = neutralVariant80,
    surfaceContainer = Color(0xFFEBEEF3),
    surfaceContainerHigh = Color(0xFFE6E8EE),
    surfaceContainerHighest = neutral80,
    surfaceContainerLow = Color(0xFFF1F4F9),
    surfaceContainerLowest = Color.White,
    surfaceDim = Color(0xFFD7DADF),
)
