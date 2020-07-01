package com.liusbl.listbinderssample.single

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.SingleViewTypeAdapter
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.activity_single.*
import kotlinx.android.synthetic.main.item_single_person.view.*

class SingleActivity : AppCompatActivity() {
    private val adapter by lazy { PersonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        recyclerView.adapter = adapter
        val list = listOf(
            Person("0", "Cartman"),
            Person("1", "Stan"),
            Person("2", "Kyle"),
            Person("3", "Kenny"),
            Person("4", "Gerald"),
            Person("5", "Randy"),
            Person("6", "Butters"),
            Person("7", "Ike"),
            Person("8", "Wendy"),
            Person("9", "Ms. Chokesondick"),
            Person("10", "Mackey"),
            Person("11", "PC principal"),
            Person("12", "Jimmy"),
            Person("13", "Timmy"),
            Person("14", "Garrison"),
            Person("15", "Mr. Slave"),
            Person("16", "Chef"),
            Person("17", "Scott Tenorman"),
            Person("18", "Cartman's mom"),
            Person("19", "Craig"),
            Person("20", "Token")
        )
        adapter.setItems(list)
    }

    private inner class PersonAdapter : SingleViewTypeAdapter<Person>(R.layout.item_single_person) {
        override fun onBind(viewHolder: BinderViewHolder<Person>, item: Person) {
            viewHolder.itemView.nameTextView.alpha = 0f
            viewHolder.itemView.nameTextView.animate()
                .setDuration(500)
                .alpha(1f)
                .start()
            viewHolder.itemView.nameTextView.text = item.name
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SingleActivity::class.java)
    }
}