package presentation.login

import presentation.common.Result

data class LogInScreenState(
    val token: String = "",
    val address: String = "https://www.gitlab.com",
    val tokenFieldHasError: Boolean? = null,
    val addressFieldHasError: Boolean? = null,
    val loginResult: Result<Unit> = Result.Idle,
)
