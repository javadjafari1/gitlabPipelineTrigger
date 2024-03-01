package common

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

suspend inline fun <reified T> HttpResponse.getOrThrow(): T {
    if (status.isSuccess()) {
        return body<T>()
    } else {
        throw ServerException(
            code = status.value,
            message = bodyAsText(),
        )
    }
}
