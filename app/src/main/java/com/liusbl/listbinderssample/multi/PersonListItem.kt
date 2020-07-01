package com.liusbl.listbinderssample.multi

import com.liusbl.listbinders.ListItem

sealed class PersonListItem(
    id: String?,
    viewType: Enum<*>
) : ListItem(id, viewType) {
    data class Header(val title: String) : PersonListItem(null, PersonListType.HEADER)

    class Person(id: String, val name: String) : PersonListItem(id, PersonListType.PERSON)
}

enum class PersonListType {
    PERSON, HEADER
}
