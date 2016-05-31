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
import com.spit.spy.health_records.activities.MembersListStep4Activity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step4Fragment extends Fragment {

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;
    @Bind(R.id.step4)
    LinearLayout step4_linear;
    @Bind(R.id.choice_spinner)
    AppCompatSpinner step4_spinner;
    @Bind(R.id.child_count)EditText child_count;
    @Bind(R.id.save_button)
    AppCompatButton save;

    private View rootView;


    public Step4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step4_hr, container, false);
        ButterKnife.bind(this,rootView);


        step4_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (step4_spinner.getSelectedItem().toString().equals("नहीं")) {
                    step4_linear.setVisibility(View.GONE);
                } else {
                    step4_linear.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MembersListStep4Activity.class);
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

        if(!Validation.isNo_of_Child(child_count))
        {
            ret = false;
            child_count.requestFocus();

        }


        return ret;
    }

}
