package com.spit.spy.health_records.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.MembersListStep1Activity;
import com.spit.spy.health_records.activities.Update;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    int flag[]={0,0,0,0,0,0,0};

    @Bind(R.id.btn_view_list)
    AppCompatButton viewMembersButton;

    @Bind(R.id.update)
    Button updateButton;

    @Bind(R.id.save_button)
    Button save;
    @Bind(R.id.adhaar_no) EditText adhaar_no;
    @Bind(R.id.mobile_no) EditText mobile_no;

    private View rootView;


    public Step1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step1_hr, container, false);
        ButterKnife.bind(this, rootView);
        /*viewMembersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MembersListStep1Activity.class);
                startActivity(intent);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(getActivity(), Update.class);
                startActivityForResult(intent_1,0);
            }
        });*/
        viewMembersButton.setText("VIEW MEMBERS LIST");
        viewMembersButton.setOnClickListener((View.OnClickListener) this);
        updateButton.setOnClickListener((View.OnClickListener) this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {

                    flag[0]=1;
                    Bundle bundle = new Bundle();
                    bundle.putIntArray("arr_flag",flag);

                    Step2Fragment fragment2 = new Step2Fragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }


            }
        });
        return rootView;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_list:
                Intent intent = new Intent(getActivity(), MembersListStep1Activity.class);
                startActivity(intent);

                break;
            case R.id.update:

                Intent intent1 = new Intent(getActivity(), Update.class);
                startActivity(intent1);

        }


    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isAdhaarNumber(adhaar_no)) {
            ret = false;
            adhaar_no.requestFocus();
        }

        if(!Validation.isPhoneNumber(mobile_no))
        {
            ret = false;
            mobile_no.requestFocus();

        }

        return ret;
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}