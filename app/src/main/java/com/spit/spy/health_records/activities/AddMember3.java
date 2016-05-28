package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.rey.material.widget.Button;
import com.spit.spy.R;
import com.spit.spy.Validation;

import butterknife.Bind;

public class AddMember3 extends AppCompatActivity {
AppCompatSpinner spinner;
    LinearLayout add;

   /* @Bind(R.id.choice_spinner) AppCompatSpinner spinner;
    @Bind(R.id.step3_add) LinearLayout add;*/
   @Bind(R.id.child_name) EditText child_name;
    @Bind(R.id.save_button) Button save_button;
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
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidation()) {

                    // intent of save button
                }


            }
        });

    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(child_name)) {
            ret = false;
            child_name.requestFocus();
        }


        return ret;
    }
}
