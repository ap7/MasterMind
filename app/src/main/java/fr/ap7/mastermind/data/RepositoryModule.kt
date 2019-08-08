package fr.ap7.mastermind.data

import fr.ap7.mastermind.data.source.AlbumsRepository
import fr.ap7.mastermind.data.source.remote.AlbumsRemoteRepository
import org.koin.dsl.module.module


// https://insert-koin.io/
val repositoryModule = module {
    single { AlbumsRemoteRepository("http://jsonplaceholder.typicode.com") }
    single { AlbumsRepository(get()) }
}