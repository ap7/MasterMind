package fr.ap7.mastermind.ui

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import fr.ap7.mastermind.R
import fr.ap7.mastermind.databinding.ActivityPostListBinding
import fr.ap7.mastermind.injection.ViewModelFactory

/**
 * Android view
 *
 * I Used Livedata thanks to data binding
 *
 * @author Ap7
 */
class PostListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding

    // Provider to use this factory to instantiate the PostViewModel class
    private lateinit var viewModel: PostListViewModel

    // Observe the value of errorMessage in the PostListActivity to display the SnackBar when it is not null, and hide it when the value is null
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.postList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) {
                showError(errorMessage)
            } else hideError()
        })
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}