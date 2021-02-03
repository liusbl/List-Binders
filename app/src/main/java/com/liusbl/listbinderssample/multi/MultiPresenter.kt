package com.liusbl.listbinderssample.multi

class MultiPresenter(
    private val view: MultiView
) {
    private val initialList = listOf(
        PersonListItem.Person("0", "Cartman"),
        PersonListItem.Person("1", "Stan"),
        PersonListItem.Person("2", "Kyle"),
        PersonListItem.Person("3", "Kenny"),
        PersonListItem.Person("4", "Gerald"),
        PersonListItem.Person("5", "Randy"),
        PersonListItem.Person("6", "Butters"),
        PersonListItem.Person("7", "Ike"),
        PersonListItem.Person("8", "Wendy"),
        PersonListItem.Person("9", "Ms. Chokesondick"),
        PersonListItem.Person("10", "Mackey"),
        PersonListItem.Person("11", "PC principal"),
        PersonListItem.Person("12", "Jimmy"),
        PersonListItem.Person("13", "Timmy"),
        PersonListItem.Person("14", "Garrison"),
        PersonListItem.Person("15", "Mr. Slave"),
        PersonListItem.Person("16", "Chef"),
        PersonListItem.Person("17", "Scott Tenorman"),
        PersonListItem.Person("18", "Craig")
    )
    private var personList = emptyList<PersonListItem>()

    fun onViewCreated() {
        personList = initialList.sortedBy { it.name }
            .groupBy { person -> person.name[0] }
            .map { entry ->
                listOf(PersonListItem.Header(entry.key.toString())) + entry.value
            }.flatten() + listOf(PersonListItem.Footer)
        view.setPersonList(personList)
    }
}