package presentation.login

sealed interface LogInEffect {
    data object NavigateToSelectProject : LogInEffect
}
