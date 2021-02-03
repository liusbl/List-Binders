package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.LayoutBinder
import com.liusbl.listbinderssample.R

class FooterBinder : LayoutBinder<PersonListItem.Header>(
    R.layout.activity_list_final_footer_item,
    PersonListItem.ListType.FOOTER
)
