package fr.ap7.mastermind.data.source.remote

import fr.ap7.mastermind.data.model.Album
import fr.ap7.mastermind.data.source.AlbumDataSource
import fr.ap7.mastermind.data.source.remote.service.AlbumService
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsRemoteRepository(baseUrl: String) : AlbumDataSource {

    private val retrofit = lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private val albumsService = lazy {
        retrofit.value.create<AlbumService>(AlbumService::class.java)
    }

    override fun getPosts(): Single<List<Album>> {
        return albumsService.value.getPosts()
    }

    override fun getPost(id: Int): Single<Album> {
        return albumsService.value.getPost(id)
    }
}