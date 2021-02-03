package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import kotlinx.android.synthetic.main.activity_list_final_header_item.*

class HeaderBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_final_header_item,
    PersonListItem.ListType.HEADER
) {
    override fun onBind(
        viewHolder: BinderViewHolder<PersonListItem.Header>,
        item: PersonListItem.Header
    ) {
        viewHolder.headerTextView.text = item.title
    }
}