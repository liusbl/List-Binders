package com.liusbl.listbinders

/**
 * Exception thrown when not all view types are provided
 */
class BinderNotFoundException(
    viewType: Int,
    binderList: List<LayoutBinder<*>>
) : RuntimeException(
    "A binder handling view type \"$viewType\" position was not found.\n" +
            "Currently the handled view types are: [${binderList.joinToString { it.viewType.name }}]"
)