package com.liusbl.listbinderssample.multi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.liusbl.listbinderssample.R;

import java.util.Arrays;
import java.util.List;

public class MultiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);

        List<PersonSubListItem> list = Arrays.asList(
                new PersonListItem("0", "Cartman"),
                new PersonListItem("1", "Stan"),
                new PersonListItem("2", "Kyle"),
                new PersonListItem("3", "Kenny"),
                new PersonListItem("4", "Gerald"),
                new PersonListItem("5", "Randy"),
                new PersonListItem("6", "Butters"),
                new HeaderListItem("FIRST HEADER"),
                new PersonListItem("7", "Ike"),
                new PersonListItem("8", "Wendy"),
                new PersonListItem("9", "Ms. Chokesondick"),
                new PersonListItem("10", "Mackey"),
                new PersonListItem("11", "PC principal"),
                new PersonListItem("12", "Jimmy"),
                new PersonListItem("13", "Timmy"),
                new PersonListItem("14", "Garrison"),
                new PersonListItem("15", "Mr. Slave"),
                new HeaderListItem("SECOND HEADER"),
                new PersonListItem("16", "Chef"),
                new PersonListItem("17", "Scott Tenorman"),
                new PersonListItem("18", "Cartman's mom"),
                new PersonListItem("19", "Craig"),
                new PersonListItem("20", "Token")
        );
        adapter.setItems(list);
    }
}
