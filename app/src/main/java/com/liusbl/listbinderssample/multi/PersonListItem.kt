package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.ListItem

sealed class PersonListItem(id: String?, type: ListType) : ListItem(id, type) {
    data class Person(
        val id: String,
        val name: String
    ) : PersonListItem(id, ListType.PERSON)

    data class Header(
        val title: String
    ) : PersonListItem(title, ListType.HEADER)

    object Footer : PersonListItem(null, ListType.FOOTER)

    enum class ListType {
        PERSON,
        HEADER,
        FOOTER
    }
}