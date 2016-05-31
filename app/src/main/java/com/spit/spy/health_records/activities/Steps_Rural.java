package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.spit.spy.R;
import com.spit.spy.health_records.fragments.Step1Fragment;
import com.spit.spy.health_records.fragments.Step2Fragment;
import com.spit.spy.health_records.fragments.Step3Fragment;
import com.spit.spy.health_records.fragments.Step4Fragment;
import com.spit.spy.health_records.fragments.Step5Fragment;
import com.spit.spy.health_records.fragments.Step6Fragment;
import com.spit.spy.health_records.fragments.Step7Fragment;

public class Steps_Rural extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps__rural);
        ViewPager viewpager = (ViewPager)findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Step 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 5"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 6"));
        tabLayout.addTab(tabLayout.newTab().setText("Step 7"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        //final MyViewPager viewPage = new MyViewPager(this);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        /*{
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        };*/
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Step1Fragment tab1 = new Step1Fragment();
                    return tab1;
                case 1:
                    Step2Fragment tab2 = new Step2Fragment();
                    return tab2;
                case 2:
                    Step3Fragment tab3 = new Step3Fragment();
                    return tab3;
                case 3:
                    Step4Fragment tab4 = new Step4Fragment();
                    return tab4;
                case 4:
                    Step5Fragment tab5 = new Step5Fragment();
                    return tab5;
                case 5:
                    Step6Fragment tab6 = new Step6Fragment();
                    return tab6;
                case 6:
                    Step7Fragment tab7 = new Step7Fragment();
                    return tab7;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
