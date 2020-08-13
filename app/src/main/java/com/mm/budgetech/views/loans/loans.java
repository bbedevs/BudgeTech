package com.mm.budgetech.views.loans;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class loans extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private paidFragment paidFragment1;
    private received_Fragment receivedFragment1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans);

//        toolbar = findViewById(R.id.appbar_loan);
        //setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        //actionBar.hide();

     // setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager_loan);
        tabLayout = findViewById(R.id.tab_loan);

        paidFragment1 = new paidFragment();
        receivedFragment1 = new received_Fragment();

        tabLayout.setBackgroundColor(getResources().getColor(R.color.appPrimaryColor));
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter vpa = new viewPagerAdapter(getSupportFragmentManager(), 0);
        vpa.addFragment(paidFragment1, "Loans to Be Paid");
        vpa.addFragment(receivedFragment1, "Loans to Be Received");
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