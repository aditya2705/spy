package com.spit.spy.health_records.fragments;


import android.content.Intent;
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
import com.spit.spy.health_records.activities.MembersListStep2Activity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment{

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;
    @Bind(R.id.step2)
    LinearLayout step2_linear;
    @Bind(R.id.choice_spinner)
    AppCompatSpinner step2_spinner;
    @Bind(R.id.Female_name)EditText female_name;
    @Bind(R.id.Female_age) EditText female_age;
    @Bind(R.id.save_button)AppCompatButton save;
    private View rootView;


    public Step2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step2_hr, container, false);
        ButterKnife.bind(this, rootView);
        step2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            Bundle bundle = new Bundle();
            int flag[]=bundle.getIntArray("arr_flag");
            //Toast.makeText(getAppl,"Text!",Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(),flag[0],Toast.LENGTH_LONG).show();

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step2_spinner.getSelectedItem().toString().equals("नहीं")) {
                    step2_linear.setVisibility(View.GONE);
                } else {
                    step2_linear.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MembersListStep2Activity.class);
                startActivity(intent);
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

        if(!Validation.isText(female_name))
        {
            ret = false;
            female_name.requestFocus();

        }

        if (!Validation.isAge(female_age)) {
            ret = false;
            female_age.requestFocus();
        }


        return ret;
    }

}