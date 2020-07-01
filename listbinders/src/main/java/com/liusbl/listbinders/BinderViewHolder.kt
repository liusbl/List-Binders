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
) : ViewHolder(itemView), ItemBinder<T> {
    /**
     * The current item bound to the viewHolder.
     */
    lateinit var item: T

    /**
     * Passes Binder#onCreate call to adapterBinder.
     */
    override fun onCreate(viewHolder: BinderViewHolder<T>) {
        adapterBinder.onCreate(viewHolder)
    }

    /**
     * Passes Binder#onBind call to adapterBinder.
     */
    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapterBinder.onBind(viewHolder, item)
    }
}