package com.spit.spy.pregnant_women.activities;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.spit.spy.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SPIT-TISS.
 */


public class Add_women extends AppCompatActivity {

    @Bind(R.id.save_button) AppCompatButton saveButton;
    @Bind(R.id.person_name) EditText personNameEditText;
    @Bind(R.id.person_kendra) EditText personKendraEditText;
    @Bind(R.id.gender) EditText genderEditText;
    @Bind(R.id.age) EditText ageEditText;
    @Bind(R.id.class1) EditText classEditText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_women);
        ButterKnife.bind(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Save button clicked", "d1810");

                final String personName = personNameEditText.getText().toString();
                final String personKendra = personKendraEditText.getText().toString();
                final String personGender = genderEditText.getText().toString();
                final String personAge = ageEditText.getText().toString();
                final String personClass = classEditText.getText().toString();

                //Check if any of the details is empty;
                int flag = 1;
                flag *= personName.length();
                flag *= personKendra.length();
                flag *= personGender.length();
                flag *= personAge.length();
                flag *= personClass.length();


                if(flag == 0){
                    Toast.makeText(getApplicationContext(), "Please enter all values", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ConnectToDatabase(personName, personKendra, personGender, personAge, personClass);
                        }
                    }).start();
                    Toast.makeText(getApplicationContext(), "Values uploaded!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ConnectToDatabase(String personName, String personKendra, String personGender, String personAge, String personClass){

        try {

            // SET CONNECTIONSTRING
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String database = "tabfromtemp20_new";
            String username = "d1810";
            String password = "12345";
            String server = "172.16.31.111";
            String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/"+database;
            Log.i("d1810", "Conn: "+ connectionString);
//            Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/tabfromtemp20_new;user=" + username + ";password=" + password);
            Connection DbConn = DriverManager.getConnection(connectionString, username, password);

            Log.w("Connection","open");
            Statement stmt = DbConn.createStatement();
            String query = " select * from dbo.childrenlessthan5_rural ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (Exception e)
        {
//            Log.w("Error connection","" + e.printStackTrace());
            e.printStackTrace();
        }
    }
}

