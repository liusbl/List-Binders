package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.BinderViewHolder
import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import com.liusbl.listbinderssample.multi.PersonListItem.Header
import com.liusbl.listbinderssample.multi.PersonListItem.ListType
import kotlinx.android.synthetic.main.item_multi_header.*

class HeaderBinder : LayoutBinder<Header>(
    R.layout.item_multi_header,
    ListType.HEADER
) {
    override fun onBind(
        viewHolder: BinderViewHolder<Header>,
        item: Header
    ) {
        viewHolder.headerTextView.text = item.title
    }
}