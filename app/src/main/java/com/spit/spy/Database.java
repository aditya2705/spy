package com.spit.spy;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by admin on 5/27/2016.
 */
public class Database {
    static Connection DbConn;

    public static boolean isConnected() {
        return DbConn == null;
    }

    public static void connect () {

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
            Database.DbConn = DriverManager.getConnection(connectionString, username, password);

            Log.w("Connection", "open");
            Statement stmt = DbConn.createStatement();


//            //main
//            String query = " insert into dbo.childrenlessthan5_rural values("+head_name_string+")";
//
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + " " + rs.getString(2));
//            }


        } catch (Exception e)
        {
//            Log.w("Error connection","" + e.printStackTrace());
            e.printStackTrace();
        }
    }

    public static ResultSet execQuery(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = DbConn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (Exception e)
        {
    //            Log.w("Error connection","" + e.printStackTrace());
            e.printStackTrace();
        }
        return rs;
    }
}
