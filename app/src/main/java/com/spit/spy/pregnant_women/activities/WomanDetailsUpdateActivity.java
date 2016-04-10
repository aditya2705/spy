package com.spit.spy.pregnant_women.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.spit.spy.R;
import com.spit.spy.infant.fragments.BirthVaccinationFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WomanDetailsUpdateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_update);
        ButterKnife.bind(this);


    }

}
