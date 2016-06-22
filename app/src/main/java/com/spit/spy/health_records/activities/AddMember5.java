package com.spit.spy.health_records.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.FamilyDetailObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMember5 extends AppCompatActivity implements
        Database.DataReceiver <ArrayList<FamilyDetailObject>>{


    @Bind(R.id.person_name) EditText person_name;
@Bind(R.id.choice_spinner)
    AppCompatSpinner step5_spinner;
    @Bind(R.id.step5_linear)LinearLayout step5_linear;
    @Bind(R.id.person_kendra) EditText person_kendra;
    @Bind(R.id.person_sankhya) EditText person_sankhya;
    @Bind(R.id.save_button) AppCompatButton save_button;
String edu_p_name,Edu_centre,centre_reg_no,name;
    int Isregno_centre;
    Database.DataReceiver rec;
    public String upOrAdd,app_name,id;
    Context context;
    public String District_Code,Gram_Ward_Code,R_U,Block_Town_Code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member5);
        ButterKnife.bind(this);
        rec=this;
        context=AddMember5.this;
        Intent i = getIntent();
        name=i.getStringExtra("name");
//        Log.i("name is",name);
        id=i.getStringExtra("id");
        app_name=i.getStringExtra("app_name");
        upOrAdd = i.getStringExtra("upOrAdd");

        if (upOrAdd.equals("up")) {
            save_button.setText("UPDATE");
            FamilyDetailObject.getAll(context, rec,id,name);

        } else {
            save_button.setText("ADD");

        }

        step5_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (step5_spinner.getSelectedItem().toString().equals("नहीं")) {
                    step5_linear.setVisibility(View.GONE);
                    Isregno_centre=0;
                } else {
                    step5_linear.setVisibility(View.VISIBLE);
                    Isregno_centre=1;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidation()) {

             edu_p_name=person_name.getText().toString();
               if(Isregno_centre==1){
                   Edu_centre=person_kendra.getText().toString();
                   centre_reg_no=person_sankhya.getText().toString();
               }



                    if (upOrAdd.equals("up")) {

                        new Database.Update_step5().execute(id,name,Isregno_centre,Edu_centre,centre_reg_no,edu_p_name);
                        finish();
                        Intent i = new Intent(AddMember5.this, MembersListStep5Activity.class);
                        Log.i("value of id,app name",id+" -"+app_name);
                        i.putExtra("id", id);
                        i.putExtra("app_name",app_name);
                        startActivity(i);

                    } else if (upOrAdd.equals("add")) {

                        FamilyDetailObject.getAllAdd(AddMember5.this, rec, id, app_name);


                    }





                    Toast.makeText(AddMember5.this, "Added", Toast.LENGTH_SHORT).show();
                    AddMember5.this.finish();


                    // intent of save button
                }


            }
        });


    }
    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(person_name)) {
            ret = false;
            person_name.requestFocus();
        }
        if(Isregno_centre==1) {
            if (!Validation.isText(person_kendra)) {
                ret = false;
                person_kendra.requestFocus();
            }

            if (!Validation.isAmount(person_sankhya)) {
                ret = false;
                person_sankhya.requestFocus();
            }
        }

        return ret;
    }

    @Override
    public void onDataReceived(ArrayList<FamilyDetailObject> data) {


        int size=data.size();
        Log.i("addmem5 size",size+"");

        if (upOrAdd.equals("add")){
            Log.i("add","inside add");
           District_Code = data.get(0).getDistrict_Code().toString();
            Block_Town_Code =data.get(0).getBlock_town_code().toString();
            Gram_Ward_Code = data.get(0).getGram_ward_code().toString();
            R_U = data.get(0).getRural().toString();

            String family_id=""+app_name+id+"";
            Log.i("id is",family_id);


            Date dNow = new Date( );
            SimpleDateFormat ft =
                    new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

            String date=ft.format(dNow);
            Log.i("date is",date);

           new Database.Insert_Step5().execute(family_id, District_Code, Block_Town_Code, Gram_Ward_Code, R_U, app_name, id, Isregno_centre, Edu_centre, centre_reg_no, edu_p_name, date);

            finish();
            Intent i = new Intent(AddMember5.this, MembersListStep5Activity.class);
            Log.i("value of id,app name",id+" -"+app_name);
            i.putExtra("id", id);
            i.putExtra("app_name", app_name);
            startActivity(i);
        }
        else if (upOrAdd.equals("up"))
        {

            int size1=data.size();
            Log.i("size in update",size1+"");

            person_name.setText(data.get(0).getEdu_p_name().toString());
            String IsReg=data.get(0).getIsregno_center().toString();
            String s="";
            if(IsReg.equals(0)){
                s="नहीं";
                step5_linear.setVisibility(View.GONE);

            }
            else {
                s = "हाँ";
                step5_linear.setVisibility(View.VISIBLE);
                person_kendra.setText(data.get(0).getEducenter_name());
                person_sankhya.setText(data.get(0).getEducenter_no());
            }
            ArrayAdapter myAdap = (ArrayAdapter)step5_spinner.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap.getPosition(s);
            step5_spinner.setSelection(spinnerPosition);



        }
//        else
//        {
//
//            Intent i=new Intent(AddMember5.this,MembersListStep5Activity.class);
//            i.putExtra("id",id);
//            i.putExtra("app_name",app_name);
//            startActivity(i);
//        }


    }
}
