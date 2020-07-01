package com.liusbl.listbinderssample.multi;

class HeaderListItem extends PersonSubListItem {
    private final String title;

    public HeaderListItem(String title) {
        super("PersonListType.HEADER, 0");
        this.title = title;
    }

    @Override
    public Enum getViewType() {
        return PersonListType.HEADER;
    }

    public String getTitle() {
        return title;
    }
}
