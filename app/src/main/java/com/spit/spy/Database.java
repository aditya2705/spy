package com.spit.spy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.spit.spy.objects.Infant;
import com.spit.spy.objects.ResultSetConvertible;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by admin on 5/27/2016.
 */
public class Database {
    static Connection DbConn;

    public static boolean isConnected() {
        return DbConn != null;
    }

    public static void connect (Context contex) {
        try {
            new Connect(contex).execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> execQueryWithDialog (Context context, ResultSetConvertible factory, String query) {
        String params[] = new String[1];
        params[0] = query;
        ArrayList<T> rs = null;
        try {
            rs = (ArrayList<T>) new Database.RetrieveFromBackground(context, factory).execute(params).get();

        } catch (Exception e)
        {
            //            Log.w("Error connection","" + e.printStackTrace());
            e.printStackTrace();
        }
        params[0] = query;
        return rs;
    }

    public static class RetrieveFromBackground<T extends ResultSetConvertible> extends AsyncTask<String, Void, ArrayList<T>> {
        private ProgressDialog dialog;
        private Context context;
        private ResultSetConvertible factory;

        RetrieveFromBackground(Context context, ResultSetConvertible factory) {
            RetrieveFromBackground.this.context = context;
            RetrieveFromBackground.this.factory = factory;
        }

        /** progress dialog to show user that the backup is processing. */
        /**
         * application context.
         */
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }

        @Override
        protected ArrayList<T> doInBackground(String... params) {
            if (!Database.isConnected())
                Database.connect(context);
            String query = params[0];
            ResultSet rs = null;
            ArrayList<T> objects = new ArrayList<>();
            try {
                Statement stmt = Database.DbConn.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    T object = (T) factory.convert(rs);
                    objects.add(object);
                }
            } catch (Exception e) {
                //            Log.w("Error connection","" + e.printStackTrace());
                e.printStackTrace();
            }
            return objects;
        }

        @Override
        protected void onPostExecute(final ArrayList<T> rs) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public static class Connect extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog;
        private Context context;

        Connect(Context context) {
            Connect.this.context = context;
        }

        /** progress dialog to show user that the backup is processing. */
        /**
         * application context.
         */
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                // SET CONNECTIONSTRING
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                String database = "tabfromtemp20_new";
                String username = "d1810";
                String password = "12345";
                String server = "172.16.31.62";

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
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(final Void rs) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }
}