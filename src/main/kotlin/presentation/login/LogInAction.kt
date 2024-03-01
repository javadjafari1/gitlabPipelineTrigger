package presentation.login

sealed interface LogInAction

sealed interface LogInUiAction : LogInAction {
    data object ToggleTokenVisibility : LogInUiAction
    data object OpenCreateTokenUrl : LogInUiAction
}

sealed interface LogInNonUiAction : LogInAction {
    data object SigIn : LogInNonUiAction
    data class UpdateTokenTextInput(val input: String) : LogInNonUiAction
    data class UpdateAddressTextInput(val input: String) : LogInNonUiAction
}
