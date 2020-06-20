package com.liusbl.listbinderssample.multi;

import android.widget.TextView;

import com.liusbl.listbinders.BinderViewHolder;
import com.liusbl.listbinders.LayoutBinder;
import com.liusbl.listbinderssample.R;

class PersonBinder extends LayoutBinder<PersonListItem> {
    protected PersonBinder() {
        super(R.layout.item_multi_person, PersonListType.PERSON);
    }

    @Override
    public void onCreate(BinderViewHolder<PersonListItem> viewHolder) {
        // Empty
    }

    @Override
    public void onBind(BinderViewHolder<PersonListItem> viewHolder, PersonListItem item) {
        TextView nameTextView = viewHolder.itemView.findViewById(R.id.nameTextView);
        nameTextView.setAlpha(0);
        nameTextView.animate()
                .setDuration(500)
                .alpha(1)
                .start();
        nameTextView.setText(item.getName());
    }
}
