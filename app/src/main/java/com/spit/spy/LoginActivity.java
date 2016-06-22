package com.spit.spy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.spit.spy.objects.InfantObject;
import com.spit.spy.objects.LoginCredentialObject;
import com.spit.spy.objects.LoginObject;
import com.spit.spy.objects.LoginValidationObject;
import com.spit.spy.objects.PregnentWomenObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity
        implements Database.DataReceiver <ArrayList<LoginObject>>{

    @Bind(R.id.input_password) EditText passwordEditText;
    @Bind(R.id.username) EditText usernamedEditText;
    @Bind(R.id.btn_login) AppCompatButton loginButton;
    @Bind(R.id.btn_reset) AppCompatButton resetButton;
    @Bind(R.id.area_type_spinner) AppCompatSpinner areaTypeSpinner;
    @Bind(R.id.town_spinner) AppCompatSpinner townSpinner;
    @Bind(R.id.ward_spinner) AppCompatSpinner wardSpinner;
    @Bind(R.id.block_spinner) AppCompatSpinner blockSpinner;
    @Bind(R.id.gram_spinner) AppCompatSpinner gramSpinner;

    @Bind(R.id.spinner) AppCompatSpinner janpadSpinner;
    @Bind(R.id.area_layout) LinearLayout areaLayout;
    @Bind(R.id.town_spinner_layout) LinearLayout townSpinnerLayout;
    @Bind(R.id.rural_spinner_layout) LinearLayout ruralSpinnerLayout;

  public String username,password,BlockTownCode,R_U,GramWardCode;
   public static int  flag_janpad=0,flag_login=0,flag_block=0,flag_gram=0,flag_pass;
    public static String DistrictCode;
    String District_Name,Block_Town,Gram_Ward;
Database.DataReceiver rec;
    ArrayList<LoginCredentialObject> credential_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
          rec=this;
        getSupportActionBar().setTitle("UPSPS :Health Department - Login");

        final ProgressDialog progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");


        janpadSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                District_Name = janpadSpinner.getSelectedItem().toString();
                Log.i("district_name is", District_Name);
              //  LoginObject.getDistrict_Code(LoginActivity.this, rec, District_Name);
            //    flag_janpad=0;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    blockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            Block_Town = blockSpinner.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });




        gramSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Gram_Ward = gramSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        areaTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        townSpinnerLayout.setVisibility(View.GONE);
                        ruralSpinnerLayout.setVisibility(View.VISIBLE);
                        R_U = "1";

                        break;
                    case 1:
                        townSpinnerLayout.setVisibility(View.VISIBLE);
                        ruralSpinnerLayout.setVisibility(View.GONE);
                        R_U = "2";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


     Log.i("after call","after call");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {


                                check_validation();

if(flag_login==1)
                                {   // On complete call either onLoginSuccess or onLoginFailed
                                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                                if (areaTypeSpinner.getSelectedItemPosition() == 0) {

                                    intent.putExtra("records_type", 0);
                                } else {

                                    intent.putExtra("records_type", 1);
                                }
                                startActivity(intent);
                            }
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 2500);

            }
        });


    }

void check_validation()
{
    username=usernamedEditText.getText().toString();
    password=passwordEditText.getText().toString();
    flag_janpad=1;
     LoginObject.getDistrict_Code(LoginActivity.this, rec, District_Name);



}

    @Override
    public void onDataReceived(ArrayList<LoginObject> data) {

    if(flag_janpad==1){

        System.out.println("inside flag 1.............");
         int size=data.size();
         Log.i("size is",size+"");
         DistrictCode=data.get(0).getdistrict_code().toString();
         Log.i("District code is",DistrictCode);
        flag_janpad=0;
        flag_block=1;
        LoginObject.getBlock_TownCode(LoginActivity.this, rec, Block_Town,R_U,DistrictCode);


   }
   else if(flag_block==1){
        flag_block=0;
        BlockTownCode=data.get(0).getBlock_Town_Code().toString();
         Log.i("Block town code is",BlockTownCode);
      flag_gram=1;
        LoginObject.getGram_WardCode(LoginActivity.this, rec,Gram_Ward,R_U,DistrictCode);
 }

    else if(flag_gram==1) {
flag_gram=0;
        GramWardCode=data.get(0).getGram_Ward_Code().toString();
        Log.i("Gram ward code is",GramWardCode);
        flag_login=1;


        LoginValidationObject io = new LoginValidationObject();	//infant object
        credential_list = io.validation(DistrictCode, R_U, BlockTownCode);

Log.i("before get","before get");
        int size=credential_list.size();
        Log.i("size isss ",size+"");
        String username_check=credential_list.get(0).getUserName().toString();
        if(username_check.equals(username)) {

            String password_check = credential_list.get(0).getPassword().toString();
            if (password_check.equals(password)) {
                flag_login = 1;
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                flag_login = 0;
                Toast.makeText(LoginActivity.this,"Enter Valid Password", Toast.LENGTH_SHORT).show();
                passwordEditText.setText("");
            }

        }
        else
        {
            flag_login=0;
            Toast.makeText(LoginActivity.this,"Enter Valid Username", Toast.LENGTH_SHORT).show();
            usernamedEditText.setText("");
        }














//
//        LoginObject.Login_Validation(LoginActivity.this, rec, DistrictCode, R_U, BlockTownCode);
    }
//    else if (flag_login ==1) {
//        flag_login=0;
//        int size=data.size();
//        Log.i("login size is ",size+"");
//    }
}
    }



