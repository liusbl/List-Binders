package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R
import com.liusbl.listbinderssample.multi.PersonListItem.Header
import com.liusbl.listbinderssample.multi.PersonListItem.ListType

class FooterBinder : LayoutBinder<Header>(R.layout.item_multi_footer, ListType.FOOTER)
