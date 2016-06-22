package com.spit.spy.health_records.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.MembersListStep2Activity;
import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.health_records.activities.Steps_Urban;
import com.spit.spy.infant.activities.StepsActivity;
import com.spit.spy.objects.MemberDetailObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment implements
        Database.DataReceiver <ArrayList<MemberDetailObject>>{

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;
    @Bind(R.id.step2)
    LinearLayout step2_linear;
    @Bind(R.id.choice_spinner)
    AppCompatSpinner step2_spinner;
    @Bind(R.id.Female_name)EditText female_name;
    @Bind(R.id.Female_age) EditText female_age;
    @Bind(R.id.save_button)AppCompatButton save;
    private View rootView;
    @Bind(R.id.labharti_name)
    TextView labharti_name;
    @Bind(R.id.labharti_id)
    TextView labharti_id;
    @Bind(R.id.adhaar_no)
    TextView adhaar_no;
Database.DataReceiver rec;
    @Bind(R.id.mobile_no) TextView mobile_no;
    Steps_Rural obj;
    Steps_Urban obj1;
int var_isPregnant=0;
String id,app_name,fl_age,fl_name;

  public String District_Code,Block_Town_Code,Gram_Ward_Code,R_U;


    public Step2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step2_hr, container, false);
        ButterKnife.bind(this, rootView);

        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        int flag = sp.getInt("record", 0);

        Log.i("flag selected", flag + "");

        rec = (Database.DataReceiver) this;
        if (flag == 0) {
            obj = (Steps_Rural) getActivity();
            id = obj.id;
            app_name = obj.name;
            labharti_id.setText(id);
            labharti_name.setText(app_name);
            adhaar_no.setText(obj.aadhar);
            mobile_no.setText(obj.mob);


        } else{
        obj1 = (Steps_Urban) getActivity();
        id = obj1.id;
        app_name = obj1.name;
        labharti_id.setText(id);
        labharti_name.setText(app_name);
        adhaar_no.setText(obj1.aadhar);
        mobile_no.setText(obj1.mob);
    }




        step2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {




            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step2_spinner.getSelectedItem().toString().equals("नहीं")) {
                    var_isPregnant=0;
                    step2_linear.setVisibility(View.GONE);
                } else {
                    step2_linear.setVisibility(View.VISIBLE);

              var_isPregnant=1;

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
                intent.putExtra("id",id);
                intent.putExtra("app_name",app_name);
                startActivity(intent);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {
                    MemberDetailObject.getAll(getActivity(), rec, id);

                    fl_name=female_name.getText().toString();
                    fl_age=female_age.getText().toString();
                    new Database.Update_InsertPregnantWomen_Step2().execute(id,var_isPregnant,fl_age,fl_name,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name);

                }

            }
        });
        return rootView;
    }

    private boolean checkValidation() {
        boolean ret = true;
        if(var_isPregnant==1) {
            if (!Validation.isText(female_name)) {
                ret = false;
                female_name.requestFocus();

            }

            if (!Validation.isAge(female_age)) {
                ret = false;
                female_age.requestFocus();
            }
        }

        return ret;
    }

    @Override
    public void onDataReceived(ArrayList<MemberDetailObject> data) {


        District_Code= data.get(0).getDistrict_Code().toString();
        Block_Town_Code= data.get(0).getBlock_Town_Code().toString();
        Gram_Ward_Code=data.get(0).getGram_Ward_Code().toString();
        R_U=data.get(0).getR_U().toString();
Log.i("distr code : ",District_Code+"");



    }
}