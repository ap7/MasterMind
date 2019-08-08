package fr.ap7.mastermind.data.source

import fr.ap7.mastermind.data.model.Album
import io.reactivex.Single

interface AlbumDataSource {

    fun getPosts(): Single<List<Album>>
    fun getPost(id: Int): Single<Album>
}