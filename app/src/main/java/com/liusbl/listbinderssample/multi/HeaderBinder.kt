package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.item_multi_header.view.*

class HeaderBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.item_multi_header,
    PersonListType.HEADER
) {
    override fun onBind(
        viewHolder: BinderViewHolder<PersonListItem.Header>,
        item: PersonListItem.Header
    ) {
        viewHolder.itemView.headerTextView.text = item.title
    }
}