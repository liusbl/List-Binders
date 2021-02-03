package com.liusbl.listbinders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * Provides a proxy to RecyclerView.ViewHolder by implementing Binder.
 *
 * @param <T> the type of item being bound.
 * @param containerView      the item view.
 * @param binder the adapter binder.
 */
class BinderViewHolder<T : ListItem>(
    override val containerView: View,
    private val binder: ItemBinder<T>
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
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
            binder.onCreate(this)
        }
    }

    /**
     * Passes Binder#onBind call to binder.
     */
    fun onBind(item: T) {
        this.item = item
        binder.onBind(this, item)
    }
}