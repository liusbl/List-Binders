package com.liusbl.listbinders

/**
 * LayoutBinder provides ItemBinder logic for a specific layout
 *
 * @param itemLayout layout resource to bind the items to
 * @param viewType item layout resource to bind the items to
 */
abstract class LayoutBinder<T : ListItem>(
    val itemLayout: Int,
    val viewType: Enum<*>
) : ItemBinder<T>