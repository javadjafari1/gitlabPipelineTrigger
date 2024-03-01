package presentation.common

import common.ServerException
import common.Text
import common.string.Strings
import kotlinx.serialization.SerializationException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable?.getErrorMessage(): Text {
    return when (this) {
        is ServerException -> Text.DynamicString(message)
        is SerializationException -> Text.StringResource(Strings::serializationErrorMessage)
        is SocketTimeoutException -> Text.StringResource(Strings::timeoutErrorMessage)
        is UnknownHostException, is ConnectException -> Text.StringResource(Strings::cantConnectToServerErrorMessage)
        else -> Text.StringResource(Strings::unexpectedErrorMessage)
    }
}
