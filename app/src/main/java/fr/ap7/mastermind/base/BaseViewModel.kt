package fr.ap7.mastermind.base

import androidx.lifecycle.ViewModel
import fr.ap7.mastermind.injection.component.DaggerViewModelInjector
import fr.ap7.mastermind.injection.component.ViewModelInjector
import fr.ap7.mastermind.injection.module.NetworkModule
import fr.ap7.mastermind.ui.PostListViewModel
import fr.ap7.mastermind.ui.PostViewModel

/**
 * use it for dependency injection only
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
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}