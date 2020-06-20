package com.liusbl.listbinderssample.single;

import android.widget.TextView;

import com.liusbl.listbinders.BinderViewHolder;
import com.liusbl.listbinders.SingleViewTypeAdapter;
import com.liusbl.listbinderssample.R;

public class PersonAdapter extends SingleViewTypeAdapter<Person> {
    protected PersonAdapter(int itemLayout) {
        super(itemLayout);
    }

    @Override
    public void onCreate(BinderViewHolder<Person> viewHolder) {
        // Empty
    }

    @Override
    public void onBind(BinderViewHolder<Person> viewHolder, Person item) {
        TextView nameTextView = viewHolder.itemView.findViewById(R.id.nameTextView);
        nameTextView.setAlpha(0);
        nameTextView.animate()
                .setDuration(500)
                .alpha(1)
                .start();
        nameTextView.setText(item.getName());

    }
}
