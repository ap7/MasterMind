package fr.ap7.mastermind.utils.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * We know how to get the ViewModel associated to an Activity and because we add the View.getParentActivity() extension method,
 * it would be easy to get the instance of PostViewModel using ViewModelProviders.of(binding.root.getParentActivity()).get(PostViewModel::class.java).
 * The thing is the ViewModel associated to an Activity is a Singleton, so using it would make the list to display the same data to each row.
 *
 * @author Ap7
 */
fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}