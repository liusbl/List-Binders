package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.item_multi_person.view.*

class PersonBinder : LayoutBinder<PersonListItem.Person>(
    R.layout.item_multi_person,
    PersonListType.PERSON
) {
    override fun onBind(
        viewHolder: BinderViewHolder<PersonListItem.Person>,
        item: PersonListItem.Person
    ) {
        viewHolder.itemView.nameTextView.alpha = 0f
        viewHolder.itemView.nameTextView.animate()
            .setDuration(500)
            .alpha(1f)
            .start()
        viewHolder.itemView.nameTextView.text = item.name
    }
}