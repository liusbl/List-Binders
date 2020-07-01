package com.liusbl.listbinderssample.multi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liusbl.listbinders.MultiViewTypeAdapter
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.activity_single.*

class MultiActivity : AppCompatActivity() {
    private val adapter by lazy { PersonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi)
        recyclerView.adapter = adapter
        val list = listOf(
            PersonListItem.Person("0", "Cartman"),
            PersonListItem.Person("1", "Stan"),
            PersonListItem.Person("2", "Kyle"),
            PersonListItem.Person("3", "Kenny"),
            PersonListItem.Person("4", "Gerald"),
            PersonListItem.Person("5", "Randy"),
            PersonListItem.Person("6", "Butters"),
            PersonListItem.Header("FIRST HEADER"),
            PersonListItem.Person("7", "Ike"),
            PersonListItem.Person("8", "Wendy"),
            PersonListItem.Person("9", "Ms. Chokesondick"),
            PersonListItem.Person("10", "Mackey"),
            PersonListItem.Person("11", "PC principal"),
            PersonListItem.Person("12", "Jimmy"),
            PersonListItem.Person("13", "Timmy"),
            PersonListItem.Person("14", "Garrison"),
            PersonListItem.Person("15", "Mr. Slave"),
            PersonListItem.Header("SECOND HEADER"),
            PersonListItem.Person("16", "Chef"),
            PersonListItem.Person("17", "Scott Tenorman"),
            PersonListItem.Person("18", "Cartman's mom"),
            PersonListItem.Person("19", "Craig"),
            PersonListItem.Person("20", "Token")
        )
        adapter.setItems(list)
    }

    private inner class PersonAdapter : MultiViewTypeAdapter<PersonListItem>(
        listOf(
            HeaderBinder(),
            PersonBinder()
        )
    )

    companion object {
        fun createIntent(context: Context) = Intent(context, MultiActivity::class.java)
    }
}