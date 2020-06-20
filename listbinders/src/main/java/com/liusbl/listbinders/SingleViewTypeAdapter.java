package com.liusbl.listbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides simplified way to implement list with a single view type
 */
public abstract class SingleViewTypeAdapter<T extends ListItem>
        extends ListAdapter<T, BinderViewHolder<T>>
        implements ItemBinder<T> {
    @LayoutRes
    private final int itemLayout;

    protected SingleViewTypeAdapter(int itemLayout) {
        super(new DefaultDiffUtilItemCallback<T>());
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public BinderViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(itemLayout, parent, false);
        BinderViewHolder<T> viewHolder = new BinderViewHolder<>(this, itemView);
        viewHolder.onCreate(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BinderViewHolder<T> viewHolder, int position) {
        viewHolder.onBind(viewHolder, getCurrentList().get(position));
    }

    @Override
    public long getItemId(int position) {
        return getCurrentList().get(position).getStableId();
    }

    /**
     * This should be used instead of directly calling ListAdapter#submitList
     * <p>
     * Recreating the list with "toList()" is necessary,
     * because even if you provide the same instance of a list,
     * then AsyncListDiffer will not trigger.
     * <p>
     * All of the item IDs are adjusted to a more stable variant, in accordance to:
     * if the ID is a null - create a unique ID,
     * if the ID is not a null - append the ViewType and make it unique to that ViewType.
     */
    public void setItems(List<T> list) {
        submitList(new ArrayList<T>(list));
    }
}
