package presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun <VM : BaseScreenModel<*, *, Effect>, Effect> VM.ObserveEffect(
    block: suspend (Effect) -> Unit
) {
    LaunchedEffect(true) {
        effect.collect(block)
    }
}
