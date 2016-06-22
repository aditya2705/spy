package com.spit.spy.health_records.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.AddMember3;
import com.spit.spy.health_records.activities.MembersListStep3Activity;
import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.health_records.activities.Steps_Urban;
import com.spit.spy.objects.MemberDetailObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step3Fragment extends Fragment

{

    @Bind(R.id.btn_view_list) AppCompatButton viewListButton;

    @Bind(R.id.choice_spinner) AppCompatSpinner step3_spinner;

    @Bind(R.id.save_button) AppCompatButton save;
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
   public String id,app_name;
int isChild;
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

        SharedPreferences sp = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        int flag = sp.getInt("record", 0);


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









        step3_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step3_spinner.getSelectedItem().toString().equals("नहीं")) {
                    isChild = 0;
                } else {

                    isChild = 1;
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
                intent.putExtra("id", id);
                intent.putExtra("app_name", app_name);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Database.SaveStep3().execute(id, isChild);

                if(isChild==1) {
    Intent i = new Intent(getActivity(), AddMember3.class);
    i.putExtra("id", id);
      i.putExtra("app_name",app_name);
                    i.putExtra("upOrAdd","add");
    startActivity(i);

}
            }
        });
        return rootView;
    }



}
