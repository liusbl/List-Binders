package com.liusbl.listbinderssample.single;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.liusbl.listbinderssample.R;

import java.util.Arrays;
import java.util.List;

public class SingleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(R.layout.item_single_person);
        recyclerView.setAdapter(adapter);

        List<Person> list = Arrays.asList(
                new Person("0", "Cartman"),
                new Person("1", "Stan"),
                new Person("2", "Kyle"),
                new Person("3", "Kenny"),
                new Person("4", "Gerald"),
                new Person("5", "Randy"),
                new Person("6", "Butters"),
                new Person("7", "Ike"),
                new Person("8", "Wendy"),
                new Person("9", "Ms. Chokesondick"),
                new Person("10", "Mackey"),
                new Person("11", "PC principal"),
                new Person("12", "Jimmy"),
                new Person("13", "Timmy"),
                new Person("14", "Garrison"),
                new Person("15", "Mr. Slave"),
                new Person("16", "Chef"),
                new Person("17", "Scott Tenorman"),
                new Person("18", "Cartman's mom"),
                new Person("19", "Craig"),
                new Person("20", "Token")
        );
        adapter.setItems(list);
    }
}
