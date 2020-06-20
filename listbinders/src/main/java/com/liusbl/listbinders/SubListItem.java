package com.liusbl.listbinders;

/**
 * All list items used in MultiViewTypeAdapter and SingleViewTypeAdapter must extend ListItem.
 */
public class SubListItem extends ListItem {
    private Enum viewType;

    public SubListItem(Enum viewType, int stableId) {
        super(stableId);
        this.viewType = viewType;
    }

    /**
     * @return Enum value that represents the item
     */
    public Enum getViewType() {
        return viewType;
    }
}
