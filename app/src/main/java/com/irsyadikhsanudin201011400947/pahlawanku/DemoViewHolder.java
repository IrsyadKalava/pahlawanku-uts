package com.irsyadikhsanudin201011400947.pahlawanku;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class DemoViewHolder extends RecyclerView.ViewHolder {

    public TextView title;


    public DemoViewHolder(View view) {
        super(view);


        this.title = (TextView) view.findViewById(R.id.cardTitle);

    }
}
