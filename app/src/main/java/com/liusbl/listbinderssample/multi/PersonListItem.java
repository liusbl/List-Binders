package com.liusbl.listbinderssample.multi;

public class PersonListItem extends PersonSubListItem {
    private final String name;

    public PersonListItem(String id, String name) {
        super("PersonListType.PERSON");
        this.name = name;
    }

    @Override
    public Enum getViewType() {
        return PersonListType.PERSON;
    }

    public String getName() {
        return name;
    }
}
