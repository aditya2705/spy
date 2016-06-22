package com.spit.spy.health_records.fragments;


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
import com.spit.spy.health_records.activities.Steps_Urban;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrbanStep7Fragment extends Fragment {
    @Bind(R.id.choice_spinner1)
    AppCompatSpinner step7_1;
    @Bind(R.id.choice_spinner2)
    AppCompatSpinner step7_2;
    @Bind(R.id.step7_urban1)
    LinearLayout step7_linear1;
    @Bind(R.id.step7_urban2)
    LinearLayout step7_linear2;
    private View rootView;
    @Bind(R.id.masik_kiraya)EditText masik_kiraya;
    @Bind(R.id.save_button)AppCompatButton save;
    @Bind(R.id.labharti_name)
    TextView labharti_name;
    @Bind(R.id.labharti_id)
    TextView labharti_id;
    @Bind(R.id.adhaar_no)
    TextView adhaar_no;
    @Bind(R.id.mobile_no) TextView mobile_no;
    public String id,app_name;
Steps_Urban obj1;

    int Isper_home,IsRent;
    String rent;

    public UrbanStep7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_step7_urban_hr, container, false);
        ButterKnife.bind(this,rootView);

        obj1 = (Steps_Urban) getActivity();
        id = obj1.id;
        app_name = obj1.name;
        labharti_id.setText(id);
        labharti_name.setText(app_name);
        adhaar_no.setText(obj1.aadhar);
        mobile_no.setText(obj1.mob);


        step7_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (step7_1.getSelectedItem().toString().equals("नहीं")) {
Isper_home=0;
                    step7_linear1.setVisibility(View.VISIBLE);
                } else {
                    step7_linear1.setVisibility(View.GONE);
                    Isper_home=1;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

if(Isper_home==0) {
    step7_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (step7_2.getSelectedItem().toString().equals("नहीं")) {
                step7_linear2.setVisibility(View.GONE);
                IsRent = 0;

            } else {
                step7_linear2.setVisibility(View.VISIBLE);
                IsRent = 1;
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

}

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {

                    if(IsRent==1){
rent=masik_kiraya.getText().toString();
                        new Database.Update_step7_Urban().execute(id,app_name,Isper_home,IsRent,rent);

                        Toast.makeText(getActivity(), "SAVED", Toast.LENGTH_SHORT).show();




                    }
                    // intent of save button
                }

            }
        });



        return rootView;
    }

    private boolean checkValidation() {
        boolean ret = true;

        if(!Validation.isNo_of_Child(masik_kiraya))
        {
            ret = false;
            masik_kiraya.requestFocus();

        }


        return ret;
    }
}
