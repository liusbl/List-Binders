package com.liusbl.listbinders;

import java.util.List;

/**
 * Exception thrown when not all view types are provided
 */
@SuppressWarnings("rawtypes")
class BinderNotFoundException extends RuntimeException {
    public BinderNotFoundException(
            int viewType,
            List<LayoutBinder> binderList
    ) {
        super("Binder not found"); // TODO add information about viewType and binderList
    }
}
