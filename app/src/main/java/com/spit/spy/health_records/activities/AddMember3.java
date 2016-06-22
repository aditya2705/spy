package com.spit.spy.health_records.activities;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.Infant;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMember3 extends AppCompatActivity implements
        Database.DataReceiver <ArrayList<Infant>>

{


public String id;
   @Bind(R.id.choice_spinner) AppCompatSpinner spinner;
    @Bind(R.id.step3_add) LinearLayout add;
   @Bind(R.id.child_name) EditText child_name;
    @Bind(R.id.child_health_card) EditText health_card_no;
    @Bind(R.id.save_button)
    Button save_button;
    Database.DataReceiver rec;
    String upOrAdd,name;
    Context context;
    public String District_Code,Block_Town_Code,Gram_Ward_Code,R_U;
public String childName,HealthCardNo,app_name;
    int isHealthCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member3);
        ButterKnife.bind(this);
        rec=this;
        context=AddMember3.this;
        Intent i = getIntent();
        name = i.getStringExtra("name");

        id=i.getStringExtra("id");
       app_name=i.getStringExtra("app_name");
      //  Log.i("app name start",app_name);
        upOrAdd = i.getStringExtra("upOrAdd");

        if (upOrAdd.equals("up")) {
            save_button.setText("UPDATE");
          Infant.Info(context,rec,id,name);

        } else {
            save_button.setText("ADD");

        }


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("नहीं")){
                    add.setVisibility(View.GONE);
                    isHealthCard=0;
                    HealthCardNo=" ";
   }
                else {
                    add.setVisibility(View.VISIBLE);

                    isHealthCard=1;

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


                    childName = child_name.getText().toString();
                    HealthCardNo=health_card_no.getText().toString();


                    if (upOrAdd.equals("up")) {

                        new Database.Update_step3().execute(id,name,isHealthCard,HealthCardNo,childName);
                        finish();
                        Intent i = new Intent(AddMember3.this, MembersListStep3Activity.class);
                        Log.i("value of id,app name",id+" -"+app_name);
                        i.putExtra("id", id);
                        i.putExtra("app_name",app_name);
                        startActivity(i);

                    } else if (upOrAdd.equals("add")) {

                        Infant.get_infantDetail(AddMember3.this, rec, id, app_name);

                    }





                    Toast.makeText(AddMember3.this, "Added", Toast.LENGTH_SHORT).show();
                    AddMember3.this.finish();



                }


            }
        });

    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.isText(child_name)) {
            ret = false;
            child_name.requestFocus();
        }


        return ret;
    }

    @Override
    public void onDataReceived(ArrayList<Infant> data) {

        int size=data.size();
        Log.i("sizze is",size+"");

        if (upOrAdd.equals("add")){
            District_Code = data.get(0).getDistrict_code().toString();
            Block_Town_Code = data.get(0).getBlock_town_code().toString();
            Gram_Ward_Code = data.get(0).getGram_Ward_Code().toString();
            R_U = data.get(0).getRural().toString();

            new Database.Insert_Step2().execute(District_Code, Block_Town_Code, Gram_Ward_Code, R_U, app_name, id, 1, childName, isHealthCard, HealthCardNo, 1);
            finish();
            Intent i = new Intent(AddMember3.this, MembersListStep3Activity.class);
            Log.i("value of id,app name",id+" -"+app_name);
            i.putExtra("id", id);
            i.putExtra("app_name",app_name);
            startActivity(i);
        }
       else if (upOrAdd.equals("up"))
        {

            child_name.setText(data.get(0).getChild_name().toString());
            String IsHealth_card=data.get(0).getIshealth_card().toString();
            String s="";
            if(IsHealth_card.equals(0)){
                s="नहीं";
            }
            else {
                s = "हाँ";
            health_card_no.setText(data.get(0).getHealth_crd_no().toString());
            }
            ArrayAdapter myAdap = (ArrayAdapter)spinner.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap.getPosition(s);
            spinner.setSelection(spinnerPosition);



        }
//        else
//        {
//
//            Intent i=new Intent(AddMember3.this,MembersListStep3Activity.class);
//            i.putExtra("id",id);
//            i.putExtra("app_name",app_name);
//            startActivity(i);
//        }


    }
}
