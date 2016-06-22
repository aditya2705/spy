

package com.spit.spy.pregnant_women.activities;

import android.app.FragmentManager;
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
import android.widget.Switch;
import android.widget.TextView;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.DialogFragment;
import com.spit.spy.Database;
import com.spit.spy.R;
import com.spit.spy.objects.InfantObject;
import com.spit.spy.objects.PregnentWomenObjectNew;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WomanDetailsUpdateActivity extends AppCompatActivity
        implements Database.DataReceiver<ArrayList<PregnentWomenObjectNew>>,View.OnClickListener
{
public String age;
    TextView et_mukhya,et_app_ID,et_age;
    String app_id;
    @Bind(R.id.spinner_women) AppCompatSpinner spinner;
    @Bind(R.id.sr_no) TextView sr_no;
    @Bind(R.id.women_name) TextView women_name;
    @Bind(R.id.women_age) TextView women_age;
    @Bind(R.id.relation_spinner) AppCompatSpinner spinner_relation;
    @Bind(R.id.expected_date) EditText expected_date;
    @Bind(R.id.choice_spinner) AppCompatSpinner spinner_Is_tt;
    @Bind(R.id.tt1) EditText tt1;
    @Bind(R.id.tt2) EditText tt2;
    @Bind(R.id.iron_spinner) AppCompatSpinner spinner_Is_iron;
    @Bind(R.id.iron_date) EditText iron_date;
    @Bind(R.id.four_choice_spinner) AppCompatSpinner spinner_Is_four;
    @Bind(R.id.checkup1) EditText checkup1;
    @Bind(R.id.checkup2) EditText checkup2;
    @Bind(R.id.checkup3) EditText checkup3;
    @Bind(R.id.checkup4)EditText checkup4;
    @Bind(R.id.delivery_date) EditText delivery_date;
    @Bind(R.id.prasav_sthan_spinner) AppCompatSpinner spinner_prasav;
    @Bind(R.id.prasav_sthan_niji_spinner) AppCompatSpinner spinner_niji;
    @Bind(R.id.prasav_sthan_sansthagat_spinner) AppCompatSpinner spinner_sansthagat;
    @Bind(R.id.prasav_sthan_niji) LinearLayout prasav_sthan_niji_linear;
    @Bind(R.id.prasav_sthan_sansthagat) LinearLayout prasav_sthan_sanstha_linear;
    @Bind(R.id.jb) EditText jb_card_no;
    @Bind(R.id.jsy_choice_spinner) AppCompatSpinner spinner_jsy;
    @Bind(R.id.btn_update) AppCompatButton btn_update;
    DatePickerDialog.Builder datePickerDialogBuilder;
   public String women;
String date1,date2,date3,date4,date5,date6,date7,date8,date9;
    String isTT,isCheckup,place,place_sanstha,place_niji,isJsy,isIron;
    String istt1,istt2,ischeckup_1,ischeckup_2,ischeckup_3,ischeckup_4,datetime;
    Database.DataReceiver rec;
    public static int flag, date_selected;
    public int position1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_update);
        ButterKnife.bind(this);
        rec=WomanDetailsUpdateActivity.this;
        Intent i=getIntent();
        app_id=i.getStringExtra("id");
        String name=i.getStringExtra("name");
        String age=i.getStringExtra("age");

        et_mukhya=(TextView)findViewById(R.id.mukhya_name);
        et_app_ID=(TextView)findViewById(R.id.Applicant_ID);
        et_age=(TextView)findViewById(R.id.age);
        et_mukhya.setText(name);
        et_app_ID.setText(app_id);
        et_age.setText(age);



        expected_date.setOnClickListener(this);
        tt1.setOnClickListener(this);
        tt2.setOnClickListener(this);
        iron_date.setOnClickListener(this);
        checkup1.setOnClickListener(this);
        checkup2.setOnClickListener(this);
        checkup3.setOnClickListener(this);
        checkup4.setOnClickListener(this);
        delivery_date.setOnClickListener(this);
        btn_update.setOnClickListener(this);

        flag=0;
        PregnentWomenObjectNew.getAllWomen(this, rec, app_id);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                women = spinner.getSelectedItem().toString();
                position1 = position;
                Log.i("women selected", women + "");
                flag=1;
                PregnentWomenObjectNew.getWomen_Info(WomanDetailsUpdateActivity.this, rec, app_id, women);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinner_prasav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinner_prasav.getSelectedItem().toString().equals("घरेलु")) {
                    prasav_sthan_sanstha_linear.setVisibility(View.GONE);
                    place = "0";
                } else {
                    prasav_sthan_sanstha_linear.setVisibility(View.VISIBLE);
                    place = "1";


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


            spinner_sansthagat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if (spinner_sansthagat.getSelectedItem().toString().equals("सरकारी")) {
                            prasav_sthan_niji_linear.setVisibility(View.GONE);
                            place_sanstha="0";
                        } else {
                            prasav_sthan_niji_linear.setVisibility(View.VISIBLE);
                            place_sanstha = "1";


                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        spinner_niji.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinner_niji.getSelectedItem().toString().equals("गैर मान्यता प्राप्त")) {

                    place_niji="0";
                } else {

                  place_niji = "1";


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        datePickerDialogBuilder = new DatePickerDialog.Builder(R.style.Material_App_Dialog_DatePicker_Light) {

        @Override
            public void onPositiveActionClicked(DialogFragment fragment) {

                DatePickerDialog dialog = (DatePickerDialog) fragment.getDialog();

                if (date_selected == 1) {

                   Date parsedDate = null;
                      parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date1 = print1.format(parsedDate).toString();

                    expected_date.setText(date1);

                } else if (date_selected == 2) {

                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date2 = print1.format(parsedDate).toString();
                        tt1.setText(date2);
                    istt1="1";

                } else if(date_selected==3){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date3 = print1.format(parsedDate).toString();
                       tt2.setText(date3);
                    istt2="1";

                }
                else if(date_selected==4){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date4 = print1.format(parsedDate).toString();
                    iron_date.setText(date4);

                }
                else if(date_selected==5){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date5 = print1.format(parsedDate).toString();
                    checkup1.setText(date5);
                         ischeckup_1="1";
                }
                else if(date_selected==6){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date6 = print1.format(parsedDate).toString();
                    checkup2.setText(date6);
                         ischeckup_2="1";
                }
                else if(date_selected==7){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date7 = print1.format(parsedDate).toString();
                    checkup3.setText(date7);
                          ischeckup_3="1";
                }
                else if(date_selected==8){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date8 = print1.format(parsedDate).toString();
                    checkup4.setText(date8);
                            ischeckup_4="1";
                }

                else if(date_selected==9){
                    Date parsedDate = null;
                    parsedDate = new Date(this.getYear() - 1900, this.getMonth(), this.getDay());
                    SimpleDateFormat print1 = new SimpleDateFormat("yyyy-MM-dd");
                    date9 = print1.format(parsedDate).toString();
                    delivery_date.setText(date9);

                }



                super.onPositiveActionClicked(fragment);
            }

            @Override
            public void onNegativeActionClicked(DialogFragment fragment) {


                if (date_selected == 1) {
                    expected_date.setText("");

                } else if (date_selected == 2) {

                    tt1.setText("");
                     istt1="0";
                } else if(date_selected==3){
                    tt2.setText("");
                    istt2="0";
                }

                else if(date_selected==4){
                    iron_date.setText("");
                }
                else if(date_selected==5){
                    checkup1.setText("");
             ischeckup_1="0";
                }
                else if(date_selected==6){
                    checkup2.setText("");
            ischeckup_2="0";
                }
                else if(date_selected==7){
                    checkup3.setText("");
              ischeckup_3="0";
                }

                else if(date_selected==8){
                    checkup4.setText("");
                   ischeckup_4="0";
                }

                else if(date_selected==9){
                    delivery_date.setText("");

                }




                super.onNegativeActionClicked(fragment);
            }
        };

        datePickerDialogBuilder
                .positiveAction("OK")
                .negativeAction("CANCEL");







    }

    @Override
    public void onDataReceived(final ArrayList<PregnentWomenObjectNew> data) {

        if(flag==0) {
            ArrayList<String> womenList = new ArrayList<String>();
            int i = 0;
            int size = data.size();
            Log.i("size is", size + "");
            while (i < size) {
                womenList.add(data.get(i).getpregnentwomen_name());
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, womenList);
            spinner.setAdapter(adapter);
               flag=1;

        }
        else if(flag==1) {

            age = data.get(0).getpregnentwomen_age().toString();
            Log.i("age selected", age);
            position1++;
            Log.i("position is", position1 + "");
            sr_no.setText(position1+"");
            women_name.setText(data.get(0).getpregnentwomen_name().toString());
            women_age.setText(data.get(0).getpregnentwomen_age().toString());

     }





    }
    public String Child_name() {

        try {
            Spinner sp = (Spinner) findViewById(R.id.spinner);
            Log.i("Women name in steps", sp.getSelectedItem().toString());
            return sp.getSelectedItem().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NONE!";
    }

    @Override
    public void onClick(View v) {
        DialogFragment fragment = DialogFragment.newInstance(datePickerDialogBuilder);

        switch(v.getId())
        {
            case R.id.expected_date :
                  date_selected = 1;
                fragment.show(this.getSupportFragmentManager(),null);
                 break;

            case R.id.tt1 :
                date_selected = 2;
                fragment.show(this.getSupportFragmentManager(),null);

                break;

          case R.id.tt2 :
              date_selected = 3;
              fragment.show(this.getSupportFragmentManager(),null);

            break;

           case R.id.iron_date :
               date_selected = 4;
               fragment.show(this.getSupportFragmentManager(),null);

            break;

           case R.id.checkup1 :
               date_selected = 5;
               fragment.show(this.getSupportFragmentManager(),null);

            break;

           case R.id.checkup2 :
               date_selected = 6;
               fragment.show(this.getSupportFragmentManager(),null);

            break;

           case R.id.checkup3  :
               date_selected = 7;
               fragment.show(this.getSupportFragmentManager(),null);

            break;

         case R.id.checkup4 :
             date_selected = 8;
             fragment.show(this.getSupportFragmentManager(),null);

            break;

          case R.id.delivery_date :
              date_selected = 9;
              fragment.show(this.getSupportFragmentManager(),null);

            break;

            case R.id.btn_update:

                String rel;
                String s="";
                rel=spinner_relation.getSelectedItem().toString();

                if(rel.equals("पत्नी"))
                    s="w";
                else if(rel.equals("माता"))
                    s="m";
                else if(rel.equals("पुत्री"))
                    s="d";
                else if(rel.equals("बहु"))
                    s="b";

                 rel=spinner_Is_tt.getSelectedItem().toString();
                if(rel.equals("हाँ"))
                    isTT="1";
                else
                    isTT="0";


                rel=spinner_Is_iron.getSelectedItem().toString();
                if(rel.equals("हाँ"))
                    isIron="1";
                else
                    isIron="0";


                rel=spinner_Is_four.getSelectedItem().toString();
                if(rel.equals("हाँ"))
                    isCheckup="1";
                else
                    isCheckup="0";

                rel=spinner_jsy.getSelectedItem().toString();
                if(rel.equals("हाँ"))
                    isJsy="1";
                else
                    isJsy="0";

                rel=spinner_prasav.getSelectedItem().toString();
                if(rel.equals("घरेलु"))
                    place="1";
                else
                place="0";
                rel=spinner_niji.getSelectedItem().toString();
                if(rel.equals("हाँ"))
                    isJsy="1";
                else
                    isJsy="0";


                Date dNow = new Date( );
                SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
                String date=ft.format(dNow);
                Log.i("date is",date);



                String jb=jb_card_no.getText().toString();
                new Database.Update_women().execute(
                        app_id,women,s,date1,isTT,istt1,date2,istt2,date3,isIron,date4,isCheckup,ischeckup_1,date5,ischeckup_2,date6,ischeckup_3,date7,ischeckup_4,date8,place,place_sanstha,place_niji,jb,date9,isJsy,date);


        }


    }
}
