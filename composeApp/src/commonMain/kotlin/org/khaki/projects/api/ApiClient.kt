package org.khaki.projects.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// TODO: DIをしてください。
val apiClient = HttpClient {

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }

    // JSONの通信しか行わないため、デフォルトのリクエストを定義している
    defaultRequest {
        header("Content-Type", "application/json")
    }
}
