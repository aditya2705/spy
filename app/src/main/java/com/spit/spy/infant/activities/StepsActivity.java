package com.spit.spy.infant.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.spit.spy.R;
import com.spit.spy.infant.fragments.BirthVaccinationFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StepsActivity extends AppCompatActivity {

    public static int position_1;
    @Bind(R.id.step_tabs) SmartTabLayout tabLayout;
    @Bind(R.id.viewpager) ViewPager pager;

    private TabsPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_infant);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Infant(s) Details Update");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pager.setOffscreenPageLimit(20);
        adapter = new TabsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setViewPager(pager);

        position_1=pager.getCurrentItem();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
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
        private final String[] tab_names = {"Birth Vaccination", "First Dose\n(1.5 Months)", "Second Dose 10 Weeks\n(2.5 Months)"
                , "Third Dose 14 Weeks\n(3.5 Months)", "9 to 12 Months", "Booster Second Dose\n16 to 24 Months"};


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
//Toast.makeText(StepsActivity.this,"position"+position,Toast.LENGTH_LONG).show();



            switch (position) {
                default :

                    return new BirthVaccinationFragment();
            }

        }
    }

}
