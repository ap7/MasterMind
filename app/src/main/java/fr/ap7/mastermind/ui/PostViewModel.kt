package fr.ap7.mastermind.ui

import androidx.lifecycle.MutableLiveData
import fr.ap7.mastermind.base.BaseViewModel
import fr.ap7.mastermind.model.Post

/**
 * PostViewModel associated to an PostListActivity
 *
 * Displaying the list of Posts.
 *
 * To do so, I created a ViewModel for each item of the list
 * Here I have just one
 *
 * @author Ap7
 */
class PostViewModel : BaseViewModel() {

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}