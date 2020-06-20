package com.liusbl.listbinders;

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
