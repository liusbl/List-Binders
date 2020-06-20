package com.liusbl.listbinders;

/**
 * Provides a definition for the simplest operations expected when binding list items.
 */
public interface Binder<T> {
    void onBind(BindViewHolder<T> viewHolder, T item);
}
