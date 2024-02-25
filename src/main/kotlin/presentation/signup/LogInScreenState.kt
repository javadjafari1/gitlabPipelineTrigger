package presentation.signup

import presentation.common.Result

data class LogInScreenState(
    val token: String = "",
    val address: String = "gitlab.com",
    val tokenFieldHasError: Boolean? = null,
    val addressFieldHasError: Boolean? = null,
    val loginResult: Result<Unit> = Result.Idle,
)
