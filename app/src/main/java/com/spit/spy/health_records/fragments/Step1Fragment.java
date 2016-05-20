package com.spit.spy.health_records.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.spit.spy.R;
import com.spit.spy.health_records.activities.MembersListStep1Activity;
import com.spit.spy.health_records.activities.Update;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    @Bind(R.id.btn_view_list)
    AppCompatButton viewMembersButton;

    @Bind(R.id.update)
    Button updateButton;
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
        viewMembersButton.setOnClickListener((View.OnClickListener) this);
        updateButton.setOnClickListener((View.OnClickListener) this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}