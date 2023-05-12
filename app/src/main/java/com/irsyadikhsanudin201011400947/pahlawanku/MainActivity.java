package com.irsyadikhsanudin201011400947.pahlawanku;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static ViewPager viewPager;
    private static TabLayout tabLayout;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("NAMA");

        Toast.makeText(MainActivity.this, "Hi, "+name+"\nMari kita mengetahui pahlawan yang ada di Indonesia",Toast.LENGTH_SHORT).show();

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);//setting tab over viewpager

        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//setting current selected item over viewpager
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","TAB1");
                        break;
                    case 1:
                        Log.e("TAG","TAB2");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    //Data Pahlawan
    String pahlawanPria[] = {"Achmad Soebardjo","Soepomo","RM Tirto Adi Soerjo","H.O.S Tjokroaminoto","Jenderal Soedirman",
            "Hasyim Asyari","Pangeran Diponegoro","Ki Hadjar Dewantara","Bung Tomo","Sutan Sjahrir"};
    String pahlawanWanita[] = {"Cut Nyak Dhien","Cut Meutia","Raden Dewi Sartika","Martha Christina Tijahahu","Maria Walanda Maramis","Maria Walanda Maramis",
            "Nyai Ahmad Dahlan","Nyai Ahmad Dahlan","Fatimah Siti Hartinah Soeharto","Fatmawati Soekarno"};

    //Setting View Pager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(pahlawanPria), "Pria");
        adapter.addFrag(new DummyFragment(pahlawanWanita), "Wanita");
        viewPager.setAdapter(adapter);
    }


    //View Pager fragments setting adapter class
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
        private final List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        //adding fragments and title method
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}