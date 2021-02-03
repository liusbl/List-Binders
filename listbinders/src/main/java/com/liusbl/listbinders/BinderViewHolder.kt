package com.liusbl.listbinders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Provides a proxy to RecyclerView.ViewHolder by implementing Binder.
 *
 * @param <T> the type of item being bound.
 * @param adapterBinder the adapter binder.
 * @param itemView      the item view.
 */
class BinderViewHolder<T : ListItem>(
    private val adapterBinder: ItemBinder<T>,
    itemView: View
) : ViewHolder(itemView) {
    private var isCreated = false
        get() {
            val previous = field
            isCreated = true
            return previous
        }

    /**
     * The current item bound to the viewHolder.
     */
    lateinit var item: T
        private set

    /**
     * Passes Binder#onCreate call to adapterBinder.
     */
    fun onCreate(item: T) {
        if (!isCreated) {
            this.item = item
            adapterBinder.onCreate(this)
        }
    }

    /**
     * Passes Binder#onBind call to adapterBinder.
     */
    fun onBind(item: T) {
        this.item = item
        adapterBinder.onBind(this, item)
    }
}