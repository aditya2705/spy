package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.rey.material.widget.Button;
import com.spit.spy.R;
import com.spit.spy.Validation;

import butterknife.Bind;

public class AddMember5 extends AppCompatActivity {


    @Bind(R.id.person_name) EditText person_name;
    @Bind(R.id.person_kendra) EditText person_kendra;
    @Bind(R.id.person_sankhya) EditText person_sankhya;
    @Bind(R.id.save_button) Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member5);
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

        if (!Validation.isText(person_name)) {
            ret = false;
            person_name.requestFocus();
        }

        if(!Validation.isClass(person_kendra))
        {
            ret = false;
            person_kendra.requestFocus();
        }

        if(!Validation.isAmount(person_sankhya))
        {
            ret = false;
            person_sankhya.requestFocus();
        }


        return ret;
    }

}
