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
import com.spit.spy.health_records.activities.MembersListStep3Activity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step3Fragment extends Fragment {

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;
    @Bind(R.id.step3)
    LinearLayout step3_linear;
    @Bind(R.id.choice_spinner)
    AppCompatSpinner step3_spinner;


    private View rootView;


    public Step3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step3_hr, container, false);
        ButterKnife.bind(this,rootView);
        step3_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step3_spinner.getSelectedItem().toString().equals("नहीं")) {
                    step3_linear.setVisibility(View.GONE);
                } else {
                    step3_linear.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MembersListStep3Activity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
