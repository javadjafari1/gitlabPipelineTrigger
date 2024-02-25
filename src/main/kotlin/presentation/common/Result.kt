package presentation.common

sealed class Result<out T>(
    private val value: T?
) {
    data class Success<out T>(
        private val value: T
    ) : Result<T>(value) {
        operator fun invoke(): T {
            return value
        }
    }

    data class Fail<out T>(
        val error: Throwable,
        private val value: T? = null
    ) : Result<T>(value)

    data class Loading<out T>(
        private val value: T? = null
    ) : Result<T>(value)

    data object Idle : Result<Nothing>(null)
}
