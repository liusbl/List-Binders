package com.liusbl.listbinderssample.multi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liusbl.listbinders.MultiViewTypeAdapter
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.activity_multi.*

class MultiActivity : AppCompatActivity(), MultiView {
    private val adapter by lazy { PersonAdapter() }
    private val presenter by lazy { MultiPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi)
        personRecyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    override fun setPersonList(list: List<PersonListItem>) {
        adapter.setItems(list)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MultiActivity::class.java)
    }

    private inner class PersonAdapter : MultiViewTypeAdapter<PersonListItem>(
        listOf(
            PersonBinder(),
            HeaderBinder(),
            FooterBinder()
        )
    )
}