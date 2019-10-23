package fr.ap7.mastermind.network

import fr.ap7.mastermind.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 *
 * PostApi in charge of retrieving posts
 */
interface PostApi {

    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}