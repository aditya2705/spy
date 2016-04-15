package com.spit.spy.health_records.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spit.spy.R;
import com.spit.spy.health_records.activities.MembersListStep4Activity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step4Fragment extends Fragment {

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;


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

        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MembersListStep4Activity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
