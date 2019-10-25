package fr.ap7.mastermind.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import fr.ap7.mastermind.R
import fr.ap7.mastermind.base.BaseViewModel
import fr.ap7.mastermind.model.Post
import fr.ap7.mastermind.model.PostDao
import fr.ap7.mastermind.network.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel component and injection
 *
 * get results from API then display it in the view
 *
 * @author Ap7
 */
class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    val postListAdapter: PostListAdapter = PostListAdapter()

    /**
     * A MutableLiveData the view will be able to observe in order to update the visibility of the ProgressBar we will show while retrieving the data from the API.
     */
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private lateinit var subscription: Disposable

    init {
        loadPosts()
        Timber.i("called to load post method")
    }

    /**
     * Android ViewModel provides the onCleared() method which will be called when this occurs.
     *
     *  @param "subscription" Is a property when the ViewModel is no longer used and will be destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
        Timber.i("onCleared is called")
    }

    private fun loadPosts() {
        subscription = Observable.fromCallable { postDao.selectAllPosts }
            .concatMap {
                    dbPostList ->
                if(dbPostList.isEmpty()) {
                    postApi.getPosts().concatMap { apiPostList -> postDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                } else {
                    Observable.just(dbPostList)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
        Timber.i("Retrieve data is beginning")
    }

    fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
        Timber.i("Retrieve data is finished")
    }

    private fun onRetrievePostListSuccess(postList:List<Post>) {
        // set the PostListAdapter to the RecyclerView
        postListAdapter.updatePostList(postList)
        Timber.i("Retrieve data is succeed: $postList")
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
        Timber.i("Failed to retrieve data")
    }
}