package fr.ap7.mastermind.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * DAO class to allow us to insert and retrievePosts
 *
 * I use a PostDao instance in the PostViewModel to retrieve Post from the database and insert them.
 * we will add a PostDao argument to the constructor of PostListViewModel
 *
 * @author Ap7
 */
@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val selectAllPosts: List<Post>

    @Insert
    fun insertAll(vararg users: Post)
}