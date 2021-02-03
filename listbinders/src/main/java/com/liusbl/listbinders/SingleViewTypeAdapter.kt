package com.liusbl.listbinders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Provides simplified way to implement list with a single view type
 */
abstract class SingleViewTypeAdapter<T : ListItem> protected constructor(
    @field:LayoutRes private val itemLayout: Int,
    diffCallback: DiffUtil.ItemCallback<T> = DefaultDiffUtilItemCallback()
) : ListAdapter<T, BinderViewHolder<T>>(diffCallback), ItemBinder<T> {
    init {
        @Suppress("LeakingThis") // The argument comes via the constructor and this is not a usually overridden function
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(itemLayout, parent, false)
        return BinderViewHolder(itemView, this)
    }

    override fun onBindViewHolder(
        viewHolder: BinderViewHolder<T>,
        position: Int
    ) {
        val item = currentList[position]
        viewHolder.onCreate(item)
        viewHolder.onBind(item)
    }

    override fun getItemId(position: Int) = currentList[position]!!.stableId

    /**
     * This should be used instead of directly calling ListAdapter#submitList
     *
     * Recreating the list with "toList()" is necessary,
     * because even if you provide the same instance of a list,
     * then AsyncListDiffer will not trigger.
     *
     * All of the item IDs are adjusted to a more stable variant, in accordance to:
     * if the ID is a null - create a unique ID,
     * if the ID is not a null - append the ViewType and make it unique to that ViewType.
     */
    fun setItems(list: List<T>?) {
        submitList(list?.toList()?.adjustIds())
    }
}