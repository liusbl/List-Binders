package com.liusbl.listbinders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Provides a proxy to RecyclerView.ViewHolder by implementing Binder.
 *
 * @param <T> the type parameter
 */
public class BindViewHolder<T> extends RecyclerView.ViewHolder implements Binder<T> {
    private final Binder<T> adapterBinder;

    /**
     * Instantiates a new Bind view holder.
     *
     * @param adapterBinder the adapter binder
     * @param itemView      the item view
     */
    public BindViewHolder(
            Binder<T> adapterBinder,
            @NonNull View itemView
    ) {
        super(itemView);
        this.adapterBinder = adapterBinder;
    }

    /**
     * Called each time when viewHolder onBindViewHolder
     *
     * @param viewHolder The viewHolder for which to bind the item
     * @param item       The current item being binded
     */
    @Override
    public void onBind(BindViewHolder<T> viewHolder, T item) {
        adapterBinder.onBind(viewHolder, item);
    }
}
