package com.spit.spy.pregnant_women.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.spit.spy.R;

import butterknife.ButterKnife;

public class WomanDetailsUpdateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_update);
        ButterKnife.bind(this);


    }

}
