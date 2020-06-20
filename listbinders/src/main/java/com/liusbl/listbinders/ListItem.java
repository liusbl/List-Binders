package com.liusbl.listbinders;

/**
 * All single view type list items must extend this class to provide stable ids.
 */
public class ListItem {
    private int stableId;

    public ListItem(int stableId) {
        this.stableId = stableId;
    }

    /**
     * @return id that's unique to an item
     */
    public int getStableId() {
        return stableId;
    }
}
