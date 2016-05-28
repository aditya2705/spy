package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.rey.material.widget.Button;
import com.spit.spy.R;
import com.spit.spy.Validation;

import butterknife.Bind;

public class AddMember2 extends AppCompatActivity {

    @Bind(R.id.Female_name) EditText female_name;
    @Bind(R.id.Female_age) EditText female_age;
    @Bind(R.id.save_button) Button save_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member2);
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

        if (!Validation.isText(female_name)) {
            ret = false;
            female_name.requestFocus();
        }

        if(!Validation.isAge(female_age))
        {
            ret = false;
            female_age.requestFocus();

        }

        return ret;
    }
}
