package com.spit.spy.health_records.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.spit.spy.Database;
import com.spit.spy.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Twinklee on 29-04-2016.
 */
public class Update extends AppCompatActivity implements View.OnClickListener {


    private DatePicker datePicker;
    Calendar calendar;
    @Bind(R.id.save_button) Button update;

    @Bind(R.id.person_name)
    TextView name;

    @Bind(R.id.mobile_no) EditText mobile_no;
    @Bind(R.id.aadhaar_no) EditText adhaar_no;

String p_name,aadhar,mob,id;


    int year, month, day;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update);
        ButterKnife.bind(this);
        //dateView = (EditText) findViewById(R.id.textView3);
        Intent intent=getIntent();
        p_name=intent.getStringExtra("name");
        id=intent.getStringExtra("id");
        aadhar=intent.getStringExtra("aadhar");
        mob=intent.getStringExtra("mob");

        name.setText(p_name);
        adhaar_no.setText(aadhar);
        mobile_no.setText(mob);
        update.setOnClickListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        return true;
    }

    @Override
    public void onClick(View v) {

        if (checkValidation())
        {

            new Database.Update_mob_aadhaar().execute(adhaar_no.getText().toString(),mobile_no.getText().toString(),id);
            Intent intent=new Intent(this, Steps_Rural.class);
            intent.putExtra("id",id);
            intent.putExtra("name",p_name);
            intent.putExtra("aadhar",adhaar_no.getText().toString());
            intent.putExtra("mob",mobile_no.getText().toString());
            startActivity(intent);
        }



    }


    private boolean checkValidation() {
        boolean ret = true;


        if (!Validation.isPhoneNumber(mobile_no)) {
            ret = false;
            mobile_no.requestFocus();
        }
        if (!Validation.isAdhaarNumber(adhaar_no)) {
            ret = false;
            adhaar_no.requestFocus();
        }



        return ret;
    }
}

