package com.irsyadikhsanudin201011400947.pahlawanku;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;

public class RecyclerView_Adapter extends
        RecyclerView.Adapter<DemoViewHolder> {
    private ArrayList<String> arrayList;
    private Context context;


    public RecyclerView_Adapter(Context context,
                                ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder,
                                 int position) {


        final DemoViewHolder mainHolder = (DemoViewHolder) holder;
        //Setting text over textview
        mainHolder.title.setText(arrayList.get(position));

    }

    @Override
    public DemoViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_row, viewGroup, false);
        DemoViewHolder mainHolder = new DemoViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }


}
