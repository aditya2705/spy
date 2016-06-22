package com.spit.spy.objects;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 - * Created by Aditya Rathi on 10-Apr-16.
 + * Created by  on 10-Apr-16.
 */

public class LoginValidationObject {
    static Connection DbConn;
    static boolean connectionInProgress = false;
    static Context context1;

    public static final String TABLE_NAME = "UserDetail_Education";
    public static final String PRIMARY_KEY = "id";
    public static String database = "sps";
    public static String username = "sa";
    public static String password = "tiss123";
    public static String server="192.168.43.104";
    public static String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/" + database;

    private int id;


    ArrayList<LoginCredentialObject> validation_list = new ArrayList<LoginCredentialObject>();

    public ArrayList<LoginCredentialObject> validation(String DistrictCode, String R_U, String BlockTownCode) {
        new RetrieveFromBackground().execute(DistrictCode, R_U, BlockTownCode);
        int size=validation_list.size();
        Log.i("sizw is", size + "");

        return validation_list;
    }

    public class RetrieveFromBackground extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {


            // SET CONNECTIONSTRING
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            String District_Code = "District_Code";
            String R_U = "R_U";
            String Block_Town_Code = "Block_Town_Code";
            String block_town_name ="block_town_name";
            String UserName="UserName";
            String Password="Password";




            Log.w("Connection", "open");
            Statement stmt = null;
            try {
                stmt = DbConn.createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String query = "select District_Code,R_U,Block_Town_Code,block_town_name,UserName,Password from "+TABLE_NAME+" where District_Code='"+params[0]+"' and R_U ='"+params[1]+"' and Block_Town_Code ='"+
                    params[2]+"'";
    Log.i("query is",query);
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(query);
            } catch (SQLException e1) {
                e1.printStackTrace();
          }
         int x = 0;
            try {
                while (rs.next()) {
                    validation_list.add(new LoginCredentialObject(rs.getString(District_Code),rs.getString(R_U),rs.getString(Block_Town_Code),rs.getString(block_town_name),rs.getString(UserName), rs.getString(Password)));

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


return null;
        }



        }
 }




