package com.liusbl.listbinders;

import androidx.annotation.LayoutRes;

/**
 * LayoutBinder provides ItemBinder logic for a specific layout
 */
@SuppressWarnings("rawtypes")
abstract class LayoutBinder<T> implements ItemBinder<T> {
    @LayoutRes
    private final int itemLayout;
    private final Enum viewType;

    public LayoutBinder(
            @LayoutRes int itemLayout,
            Enum viewType
    ) {
        this.itemLayout = itemLayout;
        this.viewType = viewType;
    }

    /**
     * @return item layout resource to bind the items to
     */
    public int getItemLayout() {
        return itemLayout;
    }

    /**
     * @return item layout resource to bind the items to
     */
    public Enum getViewType() {
        return viewType;
    }
}
