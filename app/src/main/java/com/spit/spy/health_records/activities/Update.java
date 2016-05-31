package com.spit.spy.health_records.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.spit.spy.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Twinklee on 29-04-2016.
 */
public class Update  extends AppCompatActivity implements View.OnClickListener {


    private DatePicker datePicker;
    Calendar calendar;
    @Bind(R.id.save_button) Button update;
    @Bind(R.id.textView3) EditText dateView;
    @Bind(R.id.person_name) EditText name;

    @Bind(R.id.mobile) EditText mobile_no;
    @Bind(R.id.person_sankhya) EditText adhaar_no;




    int year, month, day;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.update);
        ButterKnife.bind(this);
        //dateView = (EditText) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
        update.setOnClickListener(this);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
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
            // intent of update
        }



    }


    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(name)) {
            ret = false;
            name.requestFocus();
        }
        if (!Validation.isPhoneNumber(mobile_no)) {
            ret = false;
            mobile_no.requestFocus();
        }
        if (!Validation.isAdhaarNumber(adhaar_no)) {
            ret = false;
            adhaar_no.requestFocus();
        }
        if (!Validation.isDate(dateView)) {
            ret = false;
            dateView.requestFocus();
        }


        return ret;
    }
}

