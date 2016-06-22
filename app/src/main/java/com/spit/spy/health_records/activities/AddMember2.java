package com.spit.spy.health_records.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.MemberDetailObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMember2 extends AppCompatActivity
        implements Database.DataReceiver <ArrayList<PregnentWomenObject>> {

    @Bind(R.id.female_name)
    EditText female_name;

    @Bind(R.id.Female_age)
    EditText female_age;
    @Bind(R.id.save_button)
    Button save_button;


    String femaleName, femaleAge;
    String name,id,app_name;
    Database.DataReceiver rec;
   public String upOrAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member2);
        ButterKnife.bind(this);
        rec = AddMember2.this;
        Intent i = getIntent();
        name = i.getStringExtra("name");
        id = i.getStringExtra("id");
        app_name=i.getStringExtra("app_name");
         upOrAdd = i.getStringExtra("upOrAdd");

        if (upOrAdd.equals("up")) {
            save_button.setText("UPDATE");
            PregnentWomenObject.get_Women_Detail(this, this, id, name);

        } else {
            save_button.setText("ADD");

        }
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidation()) {
                    femaleName = female_name.getText().toString();
                    femaleAge = female_age.getText().toString();




                    if (upOrAdd.equals("up")) {

                        new Database.Update_step2().execute(femaleName,femaleAge,id,name);
                        finish();
                        Intent i = new Intent(AddMember2.this, MembersListStep2Activity.class);
                        i.putExtra("id", id);
                        i.putExtra("app_name",app_name);
                        startActivity(i);

                    } else if (upOrAdd.equals("add")) {

                        PregnentWomenObject.getAll(AddMember2.this, rec, id);


                    }


                    //currently commented as database connect code is incomplete (not all attributes put up)
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {




                        //ConnectToDatabase(head_name_string);

                    }
                }).start();*/

                    Toast.makeText(AddMember2.this, "Added", Toast.LENGTH_SHORT).show();
                    AddMember2.this.finish();


                }


            }
        });

    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(female_name)) {
            ret = false;
            female_name.requestFocus();
        }
        if (!Validation.isAge(female_age)) {
            ret = false;
            female_age.requestFocus();

        }

        return ret;
    }

    @Override
    public void onDataReceived(ArrayList<PregnentWomenObject> data) {

        int size=data.size();
        Log.i("size is",size+"");

        if ((upOrAdd.equals("up"))) {


            female_name.setText(data.get(0).getPregnentwomen_name().toString());
            female_age.setText(data.get(0).getPregnentwomen_age().toString());

        }
        else  if((upOrAdd.equals("add"))){

            String District_Code=data.get(0).getDistrict_Code().toString();
            String Block_Town_Code=data.get(0).getBlock_Town_Code().toString();
            String Gram_Ward_Code=data.get(0).getGram_Ward_Code().toString();
            String R_U=data.get(0).getRural().toString();
            String Applicant_ID=data.get(0).getApplicant_ID().toString();

            String female_name,female_age;
            female_name=femaleName;
            female_age=femaleAge;

// obj.id, var_isPregnant,fl_age,fl_name,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name


            new Database.Update_InsertPregnantWomen_Step2().execute(id,1,female_age,female_name,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name);

            finish();
            Intent i = new Intent(AddMember2.this, MembersListStep2Activity.class);
            i.putExtra("id", id);
            i.putExtra("app_name",app_name);
            startActivity(i);


        }
//        else
//        {
//
//            Intent i=new Intent(AddMember2.this,MembersListStep2Activity.class);
//            i.putExtra("id",id);
//           i.putExtra("app_name",app_name);
//            startActivity(i);
//        }
//


    }
}
