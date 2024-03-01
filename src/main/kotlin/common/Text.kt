package common

import androidx.compose.runtime.Composable
import common.string.LocalStrings
import common.string.Strings
import kotlin.reflect.KProperty1

@Suppress("SpreadOperator")
sealed interface Text {
    data class DynamicString(val value: String) : Text
    data class StringResource(
        val property: KProperty1<Strings, String>
    ) : Text

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> property.get(LocalStrings.current)
        }
    }

    fun asString(strings: Strings): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> property.get(strings)
        }
    }
}
