package fr.ap7.mastermind.data.source.remote.service

import fr.ap7.mastermind.data.model.Album
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/photos")
    fun getPosts(): Single<List<Album>>

    // photos?albumId=1
    @GET("photos/{albumId}")
    fun getPost(@Path("albumId") postId: Int): Single<Album>
}
