package com.liusbl.listbinders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

/**
 * Provides a default implementation of DiffUtil.ItemCallback for usage in ListAdapter.
 */
class DefaultDiffUtilItemCallback<T extends ListItem> extends DiffUtil.ItemCallback<T> {
    /**
     * Compares stableIds.
     */
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.getStableId() == newItem.getStableId();
    }

    /**
     * Compares item contents.
     */
    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
