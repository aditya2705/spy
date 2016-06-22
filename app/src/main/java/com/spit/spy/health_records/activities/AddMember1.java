package com.spit.spy.health_records.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.HealthRecordsObject;
import com.spit.spy.objects.InfantObject;
import com.spit.spy.objects.MemberDetailObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMember1 extends AppCompatActivity
        implements Database.DataReceiver <ArrayList<MemberDetailObject>>
{

    @Bind(R.id.head_firstname) EditText headFirstNameEditText;
     @Bind(R.id.add_button) Button addButton;
    @Bind(R.id.head_age) EditText headAge;
    @Bind(R.id.choice_spinner2)AppCompatSpinner spinner_relation;
    @Bind(R.id.choice_spinner3)AppCompatSpinner spinner_gender;
    @Bind(R.id.choice_spinner4)AppCompatSpinner spinner_edu;
    @Bind(R.id.choice_spinner5)AppCompatSpinner spinner_married;


    String member_name,relation,age,gender,edu,married;
    String name,id;
    Database.DataReceiver rec;
    String upOrAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member1);
        ButterKnife.bind(this);
        rec=AddMember1.this;
        Intent i=getIntent();
         name=i.getStringExtra("name");
         id=i.getStringExtra("id");
   upOrAdd=i.getStringExtra("upOrAdd");
        if(upOrAdd.equals("up"))
        {
            addButton.setText("UPDATE");
            MemberDetailObject.get_Member_Detail(this, this, id, name);

        }
        else
        {
            addButton.setText("ADD");



        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkValidation()) {
                     member_name=headFirstNameEditText.getText().toString();
                    relation=spinner_relation.getSelectedItem().toString();
                    age=headAge.getText().toString();
                    gender=spinner_gender.getSelectedItem().toString();
                     edu=spinner_edu.getSelectedItem().toString();
                    married=spinner_married.getSelectedItem().toString();

                    if(upOrAdd.equals("up"))
                    {
                        new Database.Update_step1().execute(member_name,relation,age,gender,edu,married,id,name);
//                        Intent i=new Intent(AddMember1.this,MembersListStep1Activity.class);
//                        startActivity(i);
                        finish();
                        Intent i=new Intent(AddMember1.this,MembersListStep1Activity.class);
                        i.putExtra("id",id);
                        startActivity(i);



                    }
                else if(upOrAdd.equals("add"))
                    {

                        MemberDetailObject.getAll(AddMember1.this, rec, id);


                    }


                    //currently commented as database connect code is incomplete (not all attributes put up)
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {




                        //ConnectToDatabase(head_name_string);

                    }
                }).start();*/

                    Toast.makeText(AddMember1.this, "Added", Toast.LENGTH_SHORT).show();
                    AddMember1.this.finish();


                }


            }
        });


    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(headFirstNameEditText)) {
            ret = false;
            headFirstNameEditText.requestFocus();
        }

        if(!Validation.isAge(headAge))
        {
            ret = false;
            headAge.requestFocus();

        }

        return ret;
    }


    @Override
    public void onDataReceived(ArrayList<MemberDetailObject> data) {

int size=data.size();
    Log.i("size is ",size+"");
        if((upOrAdd.equals("up"))){
        headFirstNameEditText.setText(data.get(0).getMember_name().toString());
        headAge.setText(data.get(0).getMember_age().toString());

        String s="";
        String rel =data.get(0).getMember_relation().toString() ;
        if(rel.equals("h"))
            s="पति";
        else if(rel.equals("w"))
            s="पत्नी";
        else if(rel.equals("m"))
            s="माता";
        else if(rel.equals("f"))
            s="पिता";
        else if(rel.equals("d"))
            s="पुत्री";
        else if(rel.equals("s"))
            s="पुत्र्";
        else if(rel.equals("b"))
            s="बहु";
        ArrayAdapter myAdap = (ArrayAdapter)spinner_relation.getAdapter(); //cast to an ArrayAdapter
        int spinnerPosition = myAdap.getPosition(s);
        spinner_relation.setSelection(spinnerPosition);


        rel=data.get(0).getMember_gen().toString() ;
        System.out.println("gender"+rel);
        if(rel.equals("F"))
            s="स्त्री";
        else if(rel.equals("M"))
            s="पुरुष";

        ArrayAdapter myAdap1  = (ArrayAdapter)spinner_gender.getAdapter();
        spinnerPosition = myAdap1.getPosition(s);
        spinner_gender.setSelection(spinnerPosition);

        rel=data.get(0).getIseducated().toString() ;
        System.out.println("edu"+rel);
        if(rel.equals("1"))
            s="साक्षर है";
        else if(rel.equals("0"))
            s="साक्षर नहीं है";

        ArrayAdapter myAdap2  = (ArrayAdapter)spinner_edu.getAdapter();
        spinnerPosition = myAdap2.getPosition(s);
        spinner_edu.setSelection(spinnerPosition);

        rel=data.get(0).getIsmarried().toString() ;
        System.out.println("marr"+rel);
        if(rel.equals("1"))
            s="विवाहित";
        else if(rel.equals("0"))
            s="अविवाहित";

        ArrayAdapter myAdap3  = (ArrayAdapter)spinner_married.getAdapter();
        spinnerPosition = myAdap3.getPosition(s);
        spinner_married.setSelection(spinnerPosition);


    }
    else  if((upOrAdd.equals("add")))
    {

        Log.i("in add ",upOrAdd);
        String District_Code=data.get(0).getDistrict_Code().toString();
        String Block_Town_Code=data.get(0).getBlock_Town_Code().toString();
        String Gram_Ward_Code=data.get(0).getGram_Ward_Code().toString();
        String R_U=data.get(0).getR_U().toString();
        String Applicant_ID=data.get(0).getApplicant_ID().toString();
        String Applicant_Name=data.get(0).getApplicant_Name().toString();
    /*    String m_name=data.get(0).getMember_name().toString();
        String member_relation=data.get(0).getMember_relation().toString();
        String member_age=data.get(0).getMember_age().toString();
        String member_gen=data.get(0).getMember_gen().toString();
        String Iseducated=data.get(0).getIseducated().toString();
        String Ismarried=data.get(0).getIsmarried().toString();
*/
        String m_name,member_relation,member_age,member_gen,Iseducated,Ismarried,member_id;
       m_name=member_name;
        member_relation=relation;
        member_age=age;
        member_gen=gender;
        Iseducated=edu;
        Ismarried=married;
        member_id=""+m_name+Applicant_ID+"";


        if(member_relation.equals("पति"))
            member_relation="h";
        else if(member_relation.equals("पत्नी"))
            member_relation="w";
        else if(member_relation.equals("माता"))
            member_relation="m";
        else if(member_relation.equals("पिता"))
            member_relation="f";
        else if(member_relation.equals("पुत्री"))
            member_relation="d";
        else if(member_relation.equals("पुत्र्"))
            member_relation="s";
        else if(member_relation.equals("बहु"))
            member_relation="b";

        if(member_gen.equals("स्त्री"))
            member_gen="F";
        else if(member_gen.equals("पुरुष"))
            member_gen="M";

        if(Iseducated.equals("साक्षर है"))
            Iseducated="1";
        else if(Iseducated.equals("साक्षर नहीं है"))
            Iseducated="0";

        if(Ismarried.equals("विवाहित"))
            Ismarried="1";
        else if(Ismarried.equals("अविवाहित"))
            Ismarried="0";


        Log.d("values"," "+Applicant_Name+" "+Applicant_ID+" ");


        new Database.Insert_Step1().execute(member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,m_name,
                member_relation,member_age,member_gen,Iseducated,Ismarried);
        finish();
        Intent i=new Intent(AddMember1.this,MembersListStep1Activity.class);
        i.putExtra("id", id);
        startActivity(i);








    }
//        else
//        {
//            Intent i=new Intent(AddMember1.this,MembersListStep1Activity.class);
//            i.putExtra("id",id);
//            startActivity(i);
//        }

}}
