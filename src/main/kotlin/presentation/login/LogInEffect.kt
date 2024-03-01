package presentation.login

import common.Text

sealed interface LogInEffect {
    data object NavigateToSelectProject : LogInEffect
    data class ShowSnackbar(
        val message: Text
    ) : LogInEffect
}
