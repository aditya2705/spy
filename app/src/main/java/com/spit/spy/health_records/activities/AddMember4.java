package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.rey.material.widget.Button;
import com.spit.spy.R;

import butterknife.Bind;

public class AddMember4 extends AppCompatActivity {

    @Bind(R.id.child_firstname) EditText child_first_name;
    @Bind(R.id.child_lastname) EditText child_last_name;
    @Bind(R.id.child_class) EditText child_class;
    @Bind(R.id.child_fees) EditText child_fees;
    @Bind(R.id.child_dress) EditText child_dress;
    @Bind(R.id.child_stationery) EditText child_stationery;

    @Bind(R.id.save_button) Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member4);
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

        if (!Validation.isText(child_first_name)) {
            ret = false;
            child_first_name.requestFocus();
        }
        if (!Validation.isText(child_last_name)) {
            ret = false;
            child_last_name.requestFocus();
        }
        if(!Validation.isClass(child_class))
        {
            ret = false;
            child_class.requestFocus();
        }

        if(!Validation.isAmount(child_fees))
        {
            ret = false;
            child_fees.requestFocus();
        }

        if(!Validation.isAmount(child_dress))
        {
            ret = false;
            child_dress.requestFocus();
        }

        if(!Validation.isAmount(child_stationery))
        {
            ret = false;
            child_stationery.requestFocus();
        }




        return ret;
    }
}
