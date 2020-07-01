package com.liusbl.listbinders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Provides simplified way to implement list with multiple view types
 */
abstract class MultiViewTypeAdapter<T : ListItem>(
    private val binderList: List<LayoutBinder<*>>,
    diffCallback: DiffUtil.ItemCallback<T> = DefaultDiffUtilItemCallback()
) : ListAdapter<T, BinderViewHolder<T>>(diffCallback) {
    init {
        @Suppress("LeakingThis") // The argument comes via the constructor and this is not a usually overridden function
        setHasStableIds(true)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinderViewHolder<T> {
        val binder = binderList.firstOrNull { it.viewType.ordinal == viewType }
            ?: throw BinderNotFoundException(viewType, binderList)
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(binder.itemLayout, parent, false)
        val viewHolder = BinderViewHolder(binder as LayoutBinder<T>, itemView)
        viewHolder.onCreate(viewHolder)
        return viewHolder
    }

    override fun onBindViewHolder(
        viewHolder: BinderViewHolder<T>,
        position: Int
    ) {
        viewHolder.onBind(viewHolder, currentList[position])
    }

    /**
     * When using multiple viewTypes, getItemViewType must be implemented.
     * Here we provide the Enum value.
     */
    override fun getItemViewType(position: Int) = currentList[position]!!.viewType.ordinal

    /**
     * Providing stableId values allows some viewHolder optimizations
     */
    override fun getItemId(position: Int) = currentList[position]!!.viewType.ordinal.toLong()

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