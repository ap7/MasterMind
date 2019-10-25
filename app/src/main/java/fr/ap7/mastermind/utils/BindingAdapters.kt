package fr.ap7.mastermind.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import fr.ap7.mastermind.utils.extension.getParentActivity

/**
 * Here we create such attribute.
 *
 * To bind the progress bar with onRetrievePostListStart & onRetrievePostListFinish when loadPosts is called: the data is not here
 * To bind the RecyclerView with onRetrievePostListSuccess when loadPosts is called: the data is here
 *
 * @author Ap7
 */

/**
 * This attribute does not exist, so we will have to define it with a dedicated BindingAdapter
 *
 *  Come from activity_post_list.xml
 *
 * @param "adapter" is an attribute that I'm create
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

/**
 * This attribute does not exist, so we will have to define it with a dedicated BindingAdapter
 *
 *  Come from activity_post_list.xml
 *
 * @param "mutableVisibility" is an attribute that I'm create
 */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View,  visibility: MutableLiveData<Int>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

/**
 * This attribute does not exist, so we will have to define it with a dedicated BindingAdapter
 *
 * Come from item_post.xml
 *
 * @param "mutableText" is an attribute that I'm create
 */
@BindingAdapter("mutableText")
fun setMutableText(view: TextView,  text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}