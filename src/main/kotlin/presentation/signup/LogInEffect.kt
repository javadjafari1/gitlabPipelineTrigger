package presentation.signup

sealed interface LogInEffect {
    data object NavigateToSelectProject : LogInEffect
}
