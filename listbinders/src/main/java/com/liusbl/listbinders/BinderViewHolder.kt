package com.liusbl.listbinders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Using LayoutContainer allows directly accessing synthetics and also is more optimized.
 *
 * REQUIRES build.gradle(app) update:  androidExtensions { experimental = true }
 */
class BinderViewHolder<T : Any>(
    private val adapterBinder: ItemBinder<T>,
    itemView: View
) : RecyclerView.ViewHolder(itemView), ItemBinder<T> {
    private var isCreated = false
        get() {
            val previous = field
            isCreated = true
            return previous
        }
    lateinit var item: T

    /**
     * Only called once when viewHolder first calls onBindViewHolder
     */
    override fun onCreate(viewHolder: BinderViewHolder<T>) {
        if (!isCreated) {
            adapterBinder.onCreate(viewHolder)
        }
    }

    override fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        adapterBinder.onBind(viewHolder, item)
    }
}