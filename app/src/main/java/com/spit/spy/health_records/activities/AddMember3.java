package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.spit.spy.R;

import butterknife.Bind;

public class AddMember3 extends AppCompatActivity {
AppCompatSpinner spinner;
    LinearLayout add;

   /* @Bind(R.id.choice_spinner) AppCompatSpinner spinner;
    @Bind(R.id.step3_add) LinearLayout add;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member3);
spinner=(AppCompatSpinner)findViewById(R.id.choice_spinner);
        add=(LinearLayout)findViewById(R.id.step3_add);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("नहीं")){
                    add.setVisibility(View.GONE);
                }
                else {
                    add.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
