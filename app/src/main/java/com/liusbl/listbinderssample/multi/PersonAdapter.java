package com.liusbl.listbinderssample.multi;

import com.liusbl.listbinders.MultiViewTypeAdapter;

import java.util.Arrays;
import java.util.List;

public class PersonAdapter extends MultiViewTypeAdapter<PersonSubListItem> {
    private static List a = Arrays.asList(
            new PersonBinder(),
            new HeaderBinder()
    );

    protected PersonAdapter() {
        super(a, null);
    }
}
