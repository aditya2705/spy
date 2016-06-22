package com.spit.spy.health_records.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.HealthRecordsListActivity;
import com.spit.spy.health_records.activities.MembersListStep1Activity;
import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.health_records.activities.Steps_Urban;
import com.spit.spy.health_records.activities.Update;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    int flag[]={0,0,0,0,0,0,0};

    @Bind(R.id.btn_view_list)
    AppCompatButton viewMembersButton;

    @Bind(R.id.update)
    Button updateButton;


    @Bind(R.id.labharti_name)
    TextView labharti_name;
    @Bind(R.id.labharti_id)
    TextView labharti_id;
    @Bind(R.id.adhaar_no)
    TextView adhaar_no;
    @Bind(R.id.mobile_no) TextView mobile_no;

    Steps_Rural obj;
    Steps_Urban obj1;

String id,app_name,aadhar,mobile;
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
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(getActivity(), Update.class);
                startActivityForResult(intent_1,0);
            }
        });*/



        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        int flag = sp.getInt("record", 0);

        Log.i("flag selected", flag + "");

        viewMembersButton.setText("VIEW MEMBERS LIST");



        if (flag == 0) {
            obj = (Steps_Rural) getActivity();
            id = obj.id;
            app_name = obj.name;
            aadhar=obj.aadhar;
            mobile=obj.mob;
            labharti_id.setText(id);
            labharti_name.setText(app_name);
            adhaar_no.setText(aadhar);
            mobile_no.setText(mobile);


        } else{
            obj1 = (Steps_Urban) getActivity();
            id = obj1.id;
            app_name = obj1.name;
            aadhar=obj1.aadhar;
            mobile=obj1.mob;
            labharti_id.setText(id);
            labharti_name.setText(app_name);
            adhaar_no.setText(aadhar);
            mobile_no.setText(mobile);
        }







        viewMembersButton.setOnClickListener((View.OnClickListener) this);
        updateButton.setOnClickListener((View.OnClickListener) this);

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkValidation()) {
//
//                    flag[0]=1;
//                    Bundle bundle = new Bundle();
//                    bundle.putIntArray("arr_flag",flag);
//
//                    Step2Fragment fragment2 = new Step2Fragment();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment_container, fragment2);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//
//                }
//
//
//            }
//        });
        return rootView;
    }




    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_list:
                Intent intent = new Intent(getActivity(), MembersListStep1Activity.class);
                intent.putExtra("id",id);
                startActivity(intent);

                break;
            case R.id.update:

                Intent intent1 = new Intent(getActivity(), Update.class);
                intent1.putExtra("id",id);
                intent1.putExtra("name",app_name);
                intent1.putExtra("aadhar",aadhar);
                intent1.putExtra("mob",mobile);
                startActivity(intent1);

        }


    }

//    private boolean checkValidation() {
//        boolean ret = true;
//
//        if (!Validation.isAdhaarNumber(adhaar_no)) {
//            ret = false;
//            adhaar_no.requestFocus();
//        }
//
//        if(!Validation.isPhoneNumber(mobile_no))
//        {
//            ret = false;
//            mobile_no.requestFocus();
//
//        }
//
//        return ret;
//    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}