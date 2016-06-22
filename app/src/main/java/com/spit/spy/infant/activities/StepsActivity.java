package com.spit.spy.infant.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.health_records.fragments.Step1Fragment;
import com.spit.spy.health_records.fragments.Step2Fragment;
import com.spit.spy.health_records.fragments.Step3Fragment;
import com.spit.spy.health_records.fragments.Step4Fragment;
import com.spit.spy.health_records.fragments.Step5Fragment;
import com.spit.spy.health_records.fragments.Step6Fragment;
import com.spit.spy.health_records.fragments.Step7Fragment;
import com.spit.spy.infant.fragments.BirthVaccinationFragment;
import com.spit.spy.infant.fragments.BoosterFragment;
import com.spit.spy.infant.fragments.NineTo12Fragment;
import com.spit.spy.infant.fragments.First_To_ThirdDoseFragment;
import com.spit.spy.objects.InfantObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.spit.spy.Database.*;

public class StepsActivity extends AppCompatActivity implements Database.DataReceiver<ArrayList<InfantObject>> {

    public static int position_tab;
    @Bind(R.id.step_tabs)
    SmartTabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager pager;
    @Bind(R.id.mukhya_name)
    AppCompatTextView mukhya_name;
    @Bind(R.id.beneficiary_id)
    AppCompatTextView beneficiary_id;
    @Bind(R.id.spinner)
    AppCompatSpinner spinner;
    @Bind(R.id.child_name)
    AppCompatTextView child_name;
    @Bind(R.id.child_dob)
    AppCompatTextView child_dob;
    Context context;
    DataReceiver receiver;
    private TabsPagerAdapter adapter;
    String child_name1_spin;

    ArrayList<InfantObject> infants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        infants = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_infant);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Infant(s) Details Update");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pager.setOffscreenPageLimit(20);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {

                position_tab = position;


            }
        });

        adapter = new TabsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setViewPager(pager);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("mukhya_name");


        mukhya_name.setText(name);
        beneficiary_id.setText(id);

        InfantObject.getLabharti_Child(this, this, id);

        context = this;
        receiver = this;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem search;
        MenuItem register = menu.findItem(R.id.action_add);
        register.setVisible(false);
        search = menu.findItem(R.id.action_search);
        search.setVisible(false);
        return true;


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDataReceived(final ArrayList<InfantObject> data) {

        ArrayList<String> child = new ArrayList<String>();
        int i = 0;
        int size = data.size();

        while (i < size) {
            child.add(data.get(i).getChild_name());
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, child);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//            child_name1_spin = spinner.getSelectedItem().toString();

                //   int id1 = (int) spinner.getSelectedItemId();
                InfantObject.getChild_Info(getApplicationContext(), receiver, child_name1_spin);

                String name = data.get((int) id).getChild_name().toString();
                String dob = data.get((int) id).getDateOfBirth().toString();
                child_name1_spin = name;


                child_name.setText(name);
                child_dob.setText(dob);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    public static int Position_frag() {

        return position_tab;

    }

    public String Child_name() {

        try {
            Spinner sp = (Spinner) findViewById(R.id.spinner);
            return sp.getSelectedItem().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NONE!";
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

        switch (position) {
                case 0 :
                    Bundle bundle = new Bundle();
                    bundle.putString("child_name", child_name1_spin);
                    BirthVaccinationFragment bvf = new BirthVaccinationFragment();
                    bvf.setArguments(bundle);
                    return bvf;
                case 1 :
                case 2 :
                case 3 :
                 Bundle bundle1 = new Bundle();
                    bundle1.putString("child_name", child_name1_spin);
                    First_To_ThirdDoseFragment bvf1 = new First_To_ThirdDoseFragment();
                    bvf1.setArguments(bundle1);
                    return bvf1;
                case 4:
                  Bundle bundle2 = new Bundle();
                    bundle2.putString("child_name", child_name1_spin);
                    NineTo12Fragment bvf2 = new NineTo12Fragment();
                    bvf2.setArguments(bundle2);
                    return bvf2;
                case 5:
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("child_name", child_name1_spin);
                    BoosterFragment bvf3 = new BoosterFragment();
                    bvf3.setArguments(bundle3);
                    return bvf3;

                default: return null;


            }
        }
    }


}
