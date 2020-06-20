package com.liusbl.listbinderssample.single;

import com.liusbl.listbinders.ListItem;

class Person extends ListItem {
    private final String id;
    private final String name;

    public Person(String id, String name) {
        super(id.hashCode());
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
