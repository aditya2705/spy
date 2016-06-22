package com.spit.spy.health_records.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.health_records.activities.Steps_Urban;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step6Fragment extends Fragment {


    @Bind(R.id.step6_1) LinearLayout step6_linear1;
    @Bind(R.id.choice_spinner1) AppCompatSpinner step6_spinner1;
    @Bind(R.id.step6_2) LinearLayout step6_linear2;
    @Bind(R.id.choice_spinner2) AppCompatSpinner step6_spinner2;
    @Bind(R.id.step6_3) LinearLayout step6_linear3;
    @Bind(R.id.choice_spinner3) AppCompatSpinner step6_spinner3;
    @Bind(R.id.choice_spinner4) AppCompatSpinner step6_spinner4;

    @Bind(R.id.vyavasay_name) EditText vyavasay_name;
    @Bind(R.id.kruti_bhoomi)EditText kruti_bhoomi;
    @Bind(R.id.karya)EditText karya;
    @Bind(R.id.masik) EditText masik;

    @Bind(R.id.btn_view_list)AppCompatButton save;
    @Bind(R.id.labharti_name)
    TextView labharti_name;
    @Bind(R.id.labharti_id)
    TextView labharti_id;
    @Bind(R.id.adhaar_no)
    TextView adhaar_no;
    @Bind(R.id.mobile_no) TextView mobile_no;
    Steps_Rural obj;
    Steps_Urban obj1;
    public String id,app_name;
    private View rootView;
String Land,Business,Desig,Salary;
int IsLand,IsBusiness,IsEmployee,JobType;
    public Step6Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step6_hr, container, false);
        ButterKnife.bind(this,rootView);

        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        int flag = sp.getInt("record", 0);

        if (flag == 0) {
            obj = (Steps_Rural) getActivity();
            id = obj.id;
            app_name = obj.name;
            labharti_id.setText(id);
            labharti_name.setText(app_name);
            adhaar_no.setText(obj.aadhar);
            mobile_no.setText(obj.mob);


        } else{
            obj1 = (Steps_Urban) getActivity();
            id = obj1.id;
            app_name = obj1.name;
            labharti_id.setText(id);
            labharti_name.setText(app_name);
            adhaar_no.setText(obj1.aadhar);
            mobile_no.setText(obj1.mob);
        }





        step6_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step6_spinner1.getSelectedItem().toString().equals("नहीं")) {
                    step6_linear1.setVisibility(View.GONE);
                    IsLand=0;
                } else {
                    step6_linear1.setVisibility(View.VISIBLE);
                    IsLand=1;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        step6_spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step6_spinner2.getSelectedItem().toString().equals("नहीं")) {
                    step6_linear2.setVisibility(View.GONE);
                    IsBusiness=0;
                } else {
                    step6_linear2.setVisibility(View.VISIBLE);
                    IsBusiness=1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        step6_spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step6_spinner3.getSelectedItem().toString().equals("नहीं")) {
                    step6_linear3.setVisibility(View.GONE);
                    IsEmployee = 0;
                } else {
                    step6_linear3.setVisibility(View.VISIBLE);
                    IsEmployee = 1;


                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(IsEmployee==1){

            step6_spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (step6_spinner4.getSelectedItem().toString().equals("सरकारी")) {

                        JobType=1;
                    } else {

                       JobType=0;


                    }

                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {


                    Land=kruti_bhoomi.getText().toString();
                    Business=vyavasay_name.getText().toString();
                    Desig=karya.getText().toString();
                    Salary=masik.getText().toString();

                  new Database.Update_step6().execute(id,app_name,IsLand,Land,IsBusiness,Business,IsEmployee,JobType,Desig,Salary);
                    Toast.makeText(getActivity(), "SAVED", Toast.LENGTH_SHORT).show();

                }

            }
        });






        return rootView;
    }

    private boolean checkValidation() {
        boolean ret = true;


        if( IsBusiness==1) {
            if (!Validation.isText(vyavasay_name)) {
                ret = false;
                vyavasay_name.requestFocus();

            }
        }
        if( IsEmployee ==1) {
            if (!Validation.isText(karya)) {
                ret = false;
                karya.requestFocus();

            }
        }

        return ret;
    }

}
