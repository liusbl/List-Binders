package com.liusbl.listbinders

import androidx.recyclerview.widget.DiffUtil
import java.util.*

/**
 * Provides a default implementation of DiffUtil.ItemCallback for usage in ListAdapter.
 */
internal class DefaultDiffUtilItemCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    /**
     * Compares stableIds.
     */
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    /**
     * Compares item contents.
     */
    override fun areContentsTheSame(oldItem: T, newItem: T) = Objects.equals(oldItem, newItem)
}