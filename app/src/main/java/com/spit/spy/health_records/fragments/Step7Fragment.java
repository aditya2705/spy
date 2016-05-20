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
import android.widget.LinearLayout;

import com.spit.spy.R;
import com.spit.spy.health_records.activities.MembersListStep7Activity;

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



    private View rootView;


    public Step7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step7_hr, container, false);
        ButterKnife.bind(this,rootView);

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




        return rootView;
    }

}
