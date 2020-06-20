package com.liusbl.listbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Provides simplified way to implement list with multiple view types
 */
@SuppressWarnings("rawtypes")
public abstract class MultiViewTypeAdapter<T extends SubListItem>
        extends ListAdapter<T, BinderViewHolder<T>>
        implements ItemBinder<T> {
    private final List<LayoutBinder> binderList;

    protected MultiViewTypeAdapter(List<LayoutBinder> binderList) {
        super(new DefaultDiffUtilItemCallback<T>());
        this.binderList = binderList;
    }

    @NonNull
    @Override
    public BinderViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutBinder currentLayoutBinder = getLayoutBinder(viewType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(currentLayoutBinder.getItemLayout(), parent, false);
        BinderViewHolder<T> viewHolder = new BinderViewHolder<>(this, itemView);
        viewHolder.onCreate(viewHolder);
        return viewHolder;
    }

    private LayoutBinder getLayoutBinder(int viewType) {
        LayoutBinder currentLayoutBinder = null;
        for (LayoutBinder layoutBinder : binderList) {
            if (layoutBinder.getViewType().ordinal() == viewType) {
                currentLayoutBinder = layoutBinder;
                break;
            }
        }
        if (currentLayoutBinder == null) throw new BinderNotFoundException(viewType, binderList);
        return currentLayoutBinder;
    }

    @Override
    public void onBindViewHolder(@NonNull BinderViewHolder<T> viewHolder, int position) {
        viewHolder.onBind(viewHolder, getCurrentList().get(position));
    }

    /**
     * When using multiple viewTypes, getItemViewType must be implemented.
     * Here we provide the Enum value.
     */
    @Override
    public int getItemViewType(int position) {
        return getCurrentList().get(position).getStableId();
    }

    /**
     * Providing stableId values allows some viewHolder optimizations
     */
    @Override
    public long getItemId(int position) {
        return getCurrentList().get(position).getViewType().ordinal();
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
