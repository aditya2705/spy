package com.spit.spy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.spit.spy.health_records.activities.HealthRecordsListActivity;
import com.spit.spy.infant.activities.PensionersListInfantActivity;
import com.spit.spy.pregnant_women.activities.PensionersListWomenActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    @Bind(R.id.btn_vac_infants) AppCompatButton infantRecordsButton;
    @Bind(R.id.btn_vac_women) AppCompatButton pregnantWomenRecordsButton;
    @Bind(R.id.btn_health_records) AppCompatButton healthRecordsButton;

    int records_type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        records_type = getIntent().getIntExtra("records_type",0);

        getSupportActionBar().setTitle("Dashboard - " + ((records_type==0)?"Rural":"Urban"));


        infantRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PensionersListInfantActivity.class);
                startActivity(intent);
            }
        });

        pregnantWomenRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PensionersListWomenActivity.class);
                startActivity(intent);
            }
        });

        healthRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, HealthRecordsListActivity.class);
                intent.putExtra("records_type",records_type);
                startActivity(intent);
            }
        });

    }
}
