package fr.ap7.mastermind.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Class which provides a model for post
 *
 * Defining Post object as it is in the JSONPlaceholder API.
 *
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 *
 *  @author Ap7
 */
@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)
