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
import com.spit.spy.health_records.activities.MembersListStep6Activity;

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


    private View rootView;


    public Step6Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step6_hr, container, false);
        ButterKnife.bind(this,rootView);

        step6_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step6_spinner1.getSelectedItem().toString().equals("नहीं")) {
                    step6_linear1.setVisibility(View.GONE);
                } else {
                    step6_linear1.setVisibility(View.VISIBLE);
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
                } else {
                    step6_linear2.setVisibility(View.VISIBLE);
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
                } else {
                    step6_linear3.setVisibility(View.VISIBLE);
                }

}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










        return rootView;
    }

}
