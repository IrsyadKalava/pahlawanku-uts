package com.irsyadikhsanudin201011400947.pahlawanku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DummyFragment extends Fragment {
    private View view;

    private String[] data;//String for tab title

    private static RecyclerView recyclerView;

    public DummyFragment(String[] data) {
        this.data = data;//Setting tab title
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment, container, false);

        setRecyclerView();
        return view;

    }
    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            arrayList.add(i+1+". "+data[i]);//Adding items to recycler view
        }
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
}
