package com.spit.spy.infant.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spit.spy.R;

import butterknife.ButterKnife;

public class PensionersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensioners_list);
        ButterKnife.bind(this);



    }
}
