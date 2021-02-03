package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import com.liusbl.listbinderssample.multi.PersonListItem.ListType
import com.liusbl.listbinderssample.multi.PersonListItem.Person
import kotlinx.android.synthetic.main.item_multi_person.*

class PersonBinder : LayoutBinder<Person>(
    R.layout.item_multi_person,
    ListType.PERSON
) {
    override fun onBind(
        viewHolder: BinderViewHolder<Person>,
        item: Person
    ) {
        viewHolder.nameTextView.alpha = 0f
        viewHolder.nameTextView.animate()
            .apply { duration = 500 }
            .alpha(1f)
            .start()
        viewHolder.nameTextView.text = item.name
    }
}