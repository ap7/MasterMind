package fr.ap7.mastermind.base

import androidx.lifecycle.ViewModel
import fr.ap7.mastermind.injection.component.DaggerViewModelInjector
import fr.ap7.mastermind.injection.component.ViewModelInjector
import fr.ap7.mastermind.injection.module.NetworkModule
import fr.ap7.mastermind.ui.PostListViewModel
import fr.ap7.mastermind.ui.PostViewModel
import timber.log.Timber

/**
 * Use it for dependency injection only
 *
 * ViewModel class is an Android Architecture Components
 * I added dependency to the lifecycle extension library (which includes both ViewModel and LiveData libraries)
 *
 * Help me to inject data model to my android view
 *
 * @author Ap7
 */

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> {
                injector.inject(this)
                Timber.i("postlist view model was injected")
            }
            is PostViewModel -> {
                injector.inject(this)
                Timber.i("post view model was injected")
            }
        }
    }
}