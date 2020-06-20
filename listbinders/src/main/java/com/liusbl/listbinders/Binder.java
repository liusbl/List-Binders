package com.liusbl.listbinders;

/**
 * Provides a definition for the simplest operations expected when binding list items.
 */
public interface Binder<T> {
    /**
     * Called only when viewHolder is created in onCreateViewHolder
     *
     * @param viewHolder The viewHolder being created
     */
    void onCreate(BindViewHolder<T> viewHolder);

    /**
     * Called each time when viewHolder onBindViewHolder
     *
     * @param viewHolder The viewHolder for which to bind the item
     * @param item       The current item being bound
     */
    void onBind(BindViewHolder<T> viewHolder, T item);
}
