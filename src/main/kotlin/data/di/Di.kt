package data.di

import data.datasource.remote.MainRemoteDataSource
import data.datasource.remote.MainRemoteDataSourceImpl
import data.MainRepositoryImpl
import data.datasource.local.MainLocalDataSource
import data.datasource.local.MainLocalDataSourceImpl
import domain.repo.MainRepository
import org.koin.dsl.module
import presentation.home.HomeScreenModel

val homeModule = module {
    single<MainLocalDataSource> { MainLocalDataSourceImpl() }
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