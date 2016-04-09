package com.spit.spy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.spit.spy.infant.StepsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    @Bind(R.id.btn_vac_infants) AppCompatButton infantRecordsButton;
    @Bind(R.id.btn_vac_women) AppCompatButton pregnantWomenRecordsButton;
    @Bind(R.id.btn_health_records) AppCompatButton healthRecordsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);


        infantRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, StepsActivity.class);
                startActivity(intent);
            }
        });


    }
}
