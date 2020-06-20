package com.liusbl.listbinders;

/**
 * All list items used in MultiViewTypeAdapter and SingleViewTypeAdapter must extend ListItem.
 */
class ListItem {
    private int stableId;
    private Enum viewType;

    /**
     * @return id that's unique to an item
     */
    public int getStableId() {
        return stableId;
    }

    /**
     * @return Enum value that represents the item
     */
    public Enum getViewType() {
        return viewType;
    }
}
