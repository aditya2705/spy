package com.spit.spy.health_records.fragments;


import android.content.Context;
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
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.Validation;
import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.health_records.activities.Steps_Urban;

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
    @Bind(R.id.choice_spinner3) AppCompatSpinner step7_spinner3;
    @Bind(R.id.choice_spinner4) AppCompatSpinner step7_spinner4;
    @Bind(R.id.reg)EditText reg;
    @Bind(R.id.reg_number)EditText reg_number;
    @Bind(R.id.btn_view_list)AppCompatButton save;

    @Bind(R.id.labharti_name)
    TextView labharti_name;
    @Bind(R.id.labharti_id)
    TextView labharti_id;
    @Bind(R.id.adhaar_no)
    TextView adhaar_no;

    @Bind(R.id.mobile_no) TextView mobile_no;
    Steps_Rural obj;
    Steps_Urban obj1;
    public String id,app_name;
    private View rootView;

int Ismotorcycle,Isother_mc,IsTractor,other_mc_type;
    String mc_number,other_mc_reg;
    public Step7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step7_hr, container, false);
        ButterKnife.bind(this, rootView);



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

        step7_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step7_spinner1.getSelectedItem().toString().equals("नहीं")) {
                    step7_linear1.setVisibility(View.GONE);
                    Ismotorcycle=0;
                } else {
                    step7_linear1.setVisibility(View.VISIBLE);
                    Ismotorcycle=1;
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
                    Isother_mc = 0;

                } else {
                    step7_linear2.setVisibility(View.VISIBLE);
                    Isother_mc = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(Isother_mc==1)
{

    step7_spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (step7_spinner3.getSelectedItem().toString().equals("कार")) {

               other_mc_type=1;

            } else {

                other_mc_type=0;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}
        step7_spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step7_spinner4.getSelectedItem().toString().equals("नही")) {

                    IsTractor=0;

                } else {

                    IsTractor=1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {

                    // intent of save button

                    mc_number=reg.getText().toString();
                            other_mc_reg=reg_number.getText().toString();

                    new Database.Update_step7().execute(id,app_name,Ismotorcycle,mc_number,Isother_mc,other_mc_type,other_mc_reg,IsTractor);

                    Toast.makeText(getActivity(),"SAVED",Toast.LENGTH_SHORT).show();



                }

            }
        });




        return rootView;
    }
    private boolean checkValidation() {
        boolean ret = true;

//        if(!Validation.isReg(reg))
//        {
//            ret = false;
//            reg.requestFocus();
//
//        }
//
//        if(!Validation.isReg(reg_number))
//        {
//            ret = false;
//            reg_number.requestFocus();
//
//        }


        return ret;
    }

}
