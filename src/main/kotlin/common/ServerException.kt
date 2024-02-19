package common

data class ServerException(
    val code: Int,
    override val message: String,
) : Exception()
