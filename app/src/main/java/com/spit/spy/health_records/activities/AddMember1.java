package com.spit.spy.health_records.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spit.spy.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddMember1 extends AppCompatActivity {

    @Bind(R.id.head_name) EditText headNameEditText;
    @Bind(R.id.add_button) Button addButton;

    private String head_name_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member1);
        ButterKnife.bind(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                head_name_string = headNameEditText.getText().toString();

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
        });


    }

    public void ConnectToDatabase(String head_name_string){

        try {

            // SET CONNECTIONSTRING
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String database = "tabfromtemp20_new";
            String username = "d1810";
            String password = "12345";
            String server = "172.16.31.103";
            String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/"+database;
            Log.i("d1810", "Conn: " + connectionString);
//          Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/tabfromtemp20_new;user=" + username + ";password=" + password);
            Connection DbConn = DriverManager.getConnection(connectionString, username, password);

            Log.w("Connection", "open");
            Statement stmt = DbConn.createStatement();
            String query = " insert into dbo.childrenlessthan5_rural values("+head_name_string+")";

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
