package com.liusbl.listbinders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Provides a proxy to RecyclerView.ViewHolder by implementing Binder.
 *
 * @param <T> the type of item being bound.
 */
public class BinderViewHolder<T> extends RecyclerView.ViewHolder implements ItemBinder<T> {
    private final ItemBinder<T> adapterBinder;
    private T item;

    /**
     * Instantiates a new Bind view holder.
     *
     * @param adapterBinder the adapter binder
     * @param itemView      the item view
     */
    public BinderViewHolder(
            ItemBinder<T> adapterBinder,
            @NonNull View itemView
    ) {
        super(itemView);
        this.adapterBinder = adapterBinder;
    }

    /**
     * Passes Binder#onCreate call to adapterBinder.
     */
    @Override
    public void onCreate(BinderViewHolder<T> viewHolder) {
        adapterBinder.onCreate(viewHolder);
    }

    /**
     * Passes Binder#onBind call to adapterBinder.
     */
    @Override
    public void onBind(BinderViewHolder<T> viewHolder, T item) {
        adapterBinder.onBind(viewHolder, item);
    }

    /**
     * @return the current item bound to the viewHolder.
     */
    public T getItem() {
        return item;
    }
}
