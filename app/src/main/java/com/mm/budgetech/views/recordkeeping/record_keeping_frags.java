package com.mm.budgetech.views.recordkeeping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.fragments.paidFragment;
import com.mm.budgetech.views.loans.fragments.received_Fragment;
import com.mm.budgetech.views.recordkeeping.add_record;
import com.mm.budgetech.views.recordkeeping.show_all_rec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class record_keeping_frags extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private add_record add_recordFragment;
    private show_all_rec show_all_rec1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_keeping_frags);

//        toolbar = findViewById(R.id.appbar_loan);
        //setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        //actionBar.hide();

        // setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager_rec);
        tabLayout = findViewById(R.id.tab_rec);

        add_recordFragment = new add_record();
        show_all_rec1 = new show_all_rec();

        tabLayout.setBackgroundColor(getResources().getColor(R.color.appPrimaryColor));
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter vpa = new viewPagerAdapter(getSupportFragmentManager(), 0);
        vpa.addFragment(add_recordFragment, "Add New Record");
        vpa.addFragment(show_all_rec1, "View All Records");
        viewPager.setAdapter(vpa);

    }

    private class viewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments  = new ArrayList<>();
        private List<String> fragmentsTitle = new ArrayList<>();

        public viewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment (Fragment fragment, String s)
        {
            fragments.add(fragment);
            fragmentsTitle.add(s);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }
    }
}