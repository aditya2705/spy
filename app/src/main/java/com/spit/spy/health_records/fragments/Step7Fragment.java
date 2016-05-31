package com.spit.spy.health_records.fragments;


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

import com.spit.spy.R;
import com.spit.spy.Validation;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step7Fragment extends Fragment {


    @Bind(R.id.step7_1) LinearLayout step7_linear1;
    @Bind(R.id.choice_spinner1) AppCompatSpinner step7_spinner1;
    @Bind(R.id.step7_2) LinearLayout step7_linear2;
    @Bind(R.id.choice_spinner2) AppCompatSpinner step7_spinner2;
    @Bind(R.id.reg)EditText reg;
    @Bind(R.id.reg_number)EditText reg_number;
    @Bind(R.id.btn_view_list)AppCompatButton save;


    private View rootView;


    public Step7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step7_hr, container, false);
        ButterKnife.bind(this, rootView);

        step7_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step7_spinner1.getSelectedItem().toString().equals("नहीं")) {
                    step7_linear1.setVisibility(View.GONE);
                } else {
                    step7_linear1.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        step7_spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step7_spinner2.getSelectedItem().toString().equals("नहीं")) {
                    step7_linear2.setVisibility(View.GONE);
                } else {
                    step7_linear2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {

                    // intent of save button
                }

            }
        });




        return rootView;
    }
    private boolean checkValidation() {
        boolean ret = true;

        if(!Validation.isReg(reg))
        {
            ret = false;
            reg.requestFocus();

        }

        if(!Validation.isReg(reg_number))
        {
            ret = false;
            reg_number.requestFocus();

        }


        return ret;
    }

}
