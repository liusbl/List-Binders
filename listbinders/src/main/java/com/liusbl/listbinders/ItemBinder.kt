package com.liusbl.listbinders

/**
 * Provides a definition for the simplest operations expected when binding list items.
 */
interface ItemBinder<T : ListItem> {
    /**
     * Called only when viewHolder is created in onCreateViewHolder.
     * Typically used to bind listeners.
     *
     * @param viewHolder The viewHolder being created
     */
    fun onCreate(viewHolder: BinderViewHolder<T>) {
        // Empty
    }

    /**
     * Called each time when viewHolder calls onBindViewHolder.
     *
     * @param viewHolder The viewHolder for which to bind the item
     * @param item       The current item being bound
     */
    fun onBind(viewHolder: BinderViewHolder<T>, item: T) {
        // Empty
    }
}