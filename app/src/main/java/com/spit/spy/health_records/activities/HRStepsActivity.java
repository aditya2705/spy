package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.spit.spy.R;
import com.spit.spy.health_records.fragments.Step1Fragment;
import com.spit.spy.health_records.fragments.Step2Fragment;
import com.spit.spy.infant.fragments.BirthVaccinationFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HRStepsActivity extends AppCompatActivity {

    @Bind(R.id.step_tabs) SmartTabLayout tabLayout;
    @Bind(R.id.viewpager) ViewPager pager;

    private TabsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_health_records);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Health Record Update");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pager.setOffscreenPageLimit(20);
        adapter = new TabsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setViewPager(pager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"Step 1","Step 2","Step 3","Step 4", "Step 5", "Step 6", "Step 7"};

        private TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }

        @Override
        public int getCount() {
            return tab_names.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Step1Fragment();
                case 1:
                    return new Step2Fragment();
                default:
                    return new BirthVaccinationFragment();
            }
        }
    }

}
