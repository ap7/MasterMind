package fr.ap7.mastermind.network

import fr.ap7.mastermind.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 *
 * PostApi in charge of retrieving posts
 *
 * @author Ap7
 */
interface PostApi {

    /**
     * Get the list of the posts from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}