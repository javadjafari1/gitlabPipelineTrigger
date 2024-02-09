package data.di

import data.datasource.remote.MainRemoteDataSource
import data.datasource.remote.MainRemoteDataSourceImpl
import data.MainRepositoryImpl
import data.datasource.local.MainLocalDataSource
import data.datasource.local.MainLocalDataSourceImpl
import data.preference.PreferenceManager
import data.preference.PreferenceManagerImpl
import domain.repo.MainRepository
import org.koin.dsl.module
import presentation.home.HomeScreenModel
import java.util.prefs.Preferences

val homeModule = module {
    single { Preferences.userRoot().node("ir.thatsmejavad.pipelinetrigger") }
    single<PreferenceManager> { PreferenceManagerImpl(get()) }
    single<MainLocalDataSource> { MainLocalDataSourceImpl(get()) }
    single<MainRemoteDataSource> { MainRemoteDataSourceImpl() }
    single<MainRepository> {
        MainRepositoryImpl(
            mainRemoteDataSource = get(),
            mainLocalDataSource = get()
        )
    }
    factory { HomeScreenModel(get()) }
}

fun appModules() = listOf(homeModule)