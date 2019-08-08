package fr.ap7.mastermind.data.source

import fr.ap7.mastermind.data.model.Album
import io.reactivex.Single

data class AlbumsRepository(val remote: AlbumDataSource) :
    AlbumDataSource {

    override fun getPosts(): Single<List<Album>> {
        return remote.getPosts()
    }

    override fun getPost(id: Int): Single<Album> {
        return remote.getPost(id)
    }

}
