package com.liusbl.listbinderssample.multi;

import android.widget.TextView;

import com.liusbl.listbinders.BinderViewHolder;
import com.liusbl.listbinders.LayoutBinder;
import com.liusbl.listbinderssample.R;

class HeaderBinder extends LayoutBinder<HeaderListItem> {
    protected HeaderBinder() {
        super(R.layout.item_multi_header, PersonListType.HEADER);
    }

    @Override
    public void onCreate(BinderViewHolder<HeaderListItem> viewHolder) {
        // Empty
    }

    @Override
    public void onBind(BinderViewHolder<HeaderListItem> viewHolder, HeaderListItem item) {
        TextView headerTextView = viewHolder.itemView.findViewById(R.id.headerTextView);
        headerTextView.setAlpha(0);
        headerTextView.animate()
                .setDuration(500)
                .alpha(1)
                .start();
        headerTextView.setText(item.getTitle());
    }
}
