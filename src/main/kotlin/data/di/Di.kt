package data.di

import data.datasource.remote.MainRemoteDataSource
import data.datasource.remote.MainRemoteDataSourceImpl
import data.MainRepositoryImpl
import data.datasource.local.MainLocalDataSource
import data.datasource.local.MainLocalDataSourceImpl
import data.preference.PreferenceManager
import data.preference.PreferenceManagerImpl
import domain.repo.MainRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import org.koin.dsl.module
import presentation.main.MainScreenModel
import presentation.home.HomeScreenModel
import java.util.prefs.Preferences

val homeModule = module {
    single { Preferences.userRoot().node("ir.thatsmejavad.pipelinetrigger") }
    single<PreferenceManager> { PreferenceManagerImpl(get()) }
    single<MainLocalDataSource> { MainLocalDataSourceImpl(get()) }
    single<MainRemoteDataSource> { MainRemoteDataSourceImpl(get()) }
    single<MainRepository> {
        MainRepositoryImpl(
            mainRemoteDataSource = get(),
            mainLocalDataSource = get()
        )
    }
    factory { HomeScreenModel(get()) }
    factory { MainScreenModel(get()) }
}

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    single {
        HttpClient(CIO) {
            install(Logging)
            install(ContentNegotiation) {
                json(get())
            }
        }
    }
    single {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            namingStrategy = JsonNamingStrategy.SnakeCase
        }
    }
}

fun appModules() = listOf(homeModule, networkModule)
