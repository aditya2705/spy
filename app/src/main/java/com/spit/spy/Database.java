package com.spit.spy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.spit.spy.health_records.activities.Steps_Rural;
import com.spit.spy.objects.ResultSetConvertible;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Database {
    static Connection DbConn;
    static boolean connectionInProgress = false;
    static Context context1;
    public static String database = "sps";
    public static String username = "sa";
    public static String password = "tiss123";
    public static String server="192.168.43.104";
    public static String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/" + database;

    public static boolean isConnected() {
        return DbConn != null;
    }

    public static void connect(Context contex) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Database.connectionInProgress = true;
                        // SET CONNECTIONSTRING
                        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();

//
                        //120.138.109.125 - public IP - database name-upsps_spit
//                        String username = "SPROJ";
//                        String password = "drk123";


                        //database name-sps - wifi IP String username = "d1810";
                        //String password = "12345";

                        Database.DbConn = DriverManager.getConnection(connectionString, username, password);

                        Log.w("Connection", "open");
                        Statement stmt = DbConn.createStatement();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();

//            new Connect(contex).execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execQueryWithDialog(Context context, Database.DataReceiver receiver, ResultSetConvertible factory, String query) {
        context1=context;
        String params[] = new String[1];
        params[0] = query;
        try {
            new Database.RetrieveFromBackground(context, receiver, factory).execute(params);

        } catch (Exception e) {
            //            Log.w("Error connection","" + e.printStackTrace());
            e.printStackTrace();
        }
        params[0] = query;
    }


        public static class StoreDate extends AsyncTask {

        String query;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Log.i("params value is",params[0].toString());
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                if((int)params[0]==0) {
                     query = "update childrenlessthan5_rural set birth_opv_date='" + params[1] + "',birth_hepatitis_date='" + params[2] + "',birth_bcg_date='" + params[3] +
                            "' where child5_name='" + params[4] + "'";
                }
                if((int)params[0]==1){
                    query = "update childrenlessthan5_rural set first_dpt_date='" + params[1] + "',first_opv_date='" + params[2] + "',first_hepatitis_date='" + params[3] +
                            "' where child5_name='" + params[4] + "'";
                }
                if((int)params[0]==2){
                    query = "update childrenlessthan5_rural set second_dpt_date='" + params[1] + "',second_opv_date='" + params[2] + "',second_hepatitis_date='" + params[3] +
                            "' where child5_name='" + params[4] + "'";
                }
                if((int)params[0]==3){
                    query = "update childrenlessthan5_rural set third_dpt_date='" + params[1] + "',third_opv_date='" + params[2] + "',third_hepatitis_date='" + params[3] +
                            "' where child5_name='" + params[4] + "'";
                }
                if((int)params[0]==5){
                    query = "update childrenlessthan5_rural set booster_dpt_date='" + params[1] + "',booster_opv_date='" + params[2] + "',booster_khasra_date='" + params[3] +
                            "' where child5_name='" + params[4] + "'";
                }

                Log.i("query is ",query);

                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class StoreDate_NineTo12 extends AsyncTask {

        String query;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                    query = "update childrenlessthan5_rural set nineTo12_khasra_date='" + params[0] +
                            "' where child5_name='" + params[1] + "'";




                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }







    public static class Insert_Step1 extends AsyncTask {

        String query;
        int member_no=1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query="SET IDENTITY_INSERT member_detail_m_3132005_27052016 ON insert into member_detail_m_3132005_27052016(member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,member_name,member_relation,member_age,member_gen,Iseducated,Ismarried,member_auto_no,Is_family_planning,family_planning_type,family_planning_type_description,family_planning_type_other_description)"
                        +" values('"+params[0]+"', '"+params[1]+"', '"+params[2]+"', '"+params[3]+"', '"+params[4]+"', '"+params[5]+"', '"
                        +params[6] + "','" +params[7] + "','" + params[8] + "','" + params[9] + "','" + params[10] + "','" + params[11] + "','" +params[12] + "','" +member_no+ "',NULL,NULL,NULL,NULL)";
                member_no++;

                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }
    public static class Update_step1 extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(params[1].equals("पति"))
                params[1]="h";
            else if(params[1].equals("पत्नी"))
                params[1]="w";
            else if(params[1].equals("माता"))
                params[1]="m";
            else if(params[1].equals("पिता"))
                params[1]="f";
            else if(params[1].equals("पुत्री"))
                params[1]="d";
            else if(params[1].equals("पुत्र्"))
                params[1]="s";
            else if(params[1].equals("बहु"))
                params[1]="b";

            if(params[3].equals("स्त्री"))
                params[3]="F";
            else if(params[3].equals("पुरुष"))
                params[3]="M";

            if(params[4].equals("साक्षर है"))
                params[4]="1";
            else if(params[4].equals("साक्षर नहीं है"))
                params[4]="0";

            if(params[5].equals("विवाहित"))
                params[5]="1";
            else if(params[5].equals("अविवाहित"))
                params[5]="0";

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update member_detail_m_3132005_27052016 set member_name= '" + params[0] + "',member_relation = '" +params[1]  +"',member_age='"+params[2]+"',member_gen='"+params[3]+"',Iseducated='"+params[4]+"',Ismarried='"+params[5]+"' where Applicant_ID ='"+params[6]+"' and member_name='"+params[7]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }
    public static class Delete_Step1 extends AsyncTask {

        String query;

        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query="Delete from member_detail_m_3132005_27052016 where Applicant_ID ='"+params[0]+"' and member_name='"+params[1]+"'";
                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class Update_InsertPregnantWomen_Step2 extends AsyncTask {

int auto_no=1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();


                // obj.id, var_isPregnant,fl_age,fl_name,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name


                String query = "update family_detail_m_lucknow set Ispregnent= '" + params[1] + "'," +
                        " fl_age = '" +params[2]  +"', fl_name = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"'";



                String  query1="SET IDENTITY_INSERT pregnent_women_details_rural ON insert into pregnent_women_details_rural(auto_no,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_ID,pregnentwomen_name,pregnentwomen_age"+
                        ",pregnentwomen_relation ,pregnentwomen_dob ,Is_tt ,Is_tt1 ,tt1_date ,Is_tt2 ,tt2_date ,Is_iron_t ,iron_t_date ,Is_four_checkup ,Is_I_checkup ,I_checkup_date, expected_date,Is_II_checkup ,II_checkup_date ,Is_III_checkup ,III_checkup_date ,Is_IIII_checkup,"+
                        "IIII_checkup_date ,delivery_place ,delivery_place_pri ,delivery_place_pri_per ,jb_card_no ,delivery_date ,jsy ,submitdatetime)"+
                        " values('"+auto_no+"','"+params[4]+"', '"+params[5]+"', '"+params[6]+"', '"+params[7]+"', '"+params[0]
                        + "','" +params[3] + "','" + params[2] + "','','','' ,'','','','','','','','','','','','','','','','','','','','','','',''" +
                        ")";
                auto_no++;
                System.out.println("query1 is"+ query1);
                Log.i("query", query1);
                stmt.executeQuery(query1);
               stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


//            String  query1="SET IDENTITY_INSERT pregnent_women_details_rural ON insert into pregnent_women_details_rural(auto_no,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_ID,pregnentwomen_name,pregnentwomen_age"+
//                    ",pregnentwomen_relation ,pregnentwomen_dob ,Is_tt ,Is_tt1 ,tt1_date ,Is_tt2 ,tt2_date ,Is_iron_t ,iron_t_date ,Is_four_checkup ,Is_I_checkup ,I_checkup_date, expected_date,Is_II_checkup ,II_checkup_date ,Is_III_checkup ,III_checkup_date ,Is_IIII_checkup,"+
//                    "IIII_checkup_date ,delivery_place ,delivery_place_pri ,delivery_place_pri_per ,jb_card_no ,delivery_date ,jsy ,submitdatetime)"+
//                    " values('"+auto_no+"','"+params[4]+"', '"+params[5]+"', '"+params[6]+"', '"+params[7]+"', '"+params[0]
//                    + "','" +params[3] + "','" + params[2] + "','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL','NULL')";

            return null;
        }

    }
    public static class Delete_Step2 extends AsyncTask {

        String query;

        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query="Delete from pregnent_women_details_rural where Applicant_ID ='"+params[0]+"' and pregnentwomen_name='"+params[1]+"'";
                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Update_mob_aadhaar extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update family_detail_m_lucknow set Applicant_adhar= '" + params[0] + "'," +
                        " Applicant_mob = '" +params[1]  +"' where Applicant_ID ='"+params[2]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Update_step2 extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update pregnent_women_details_rural set pregnentwomen_name= '" + params[0] + "',pregnentwomen_age = '" +params[1]  +"' where Applicant_ID ='"+params[2]+"' and pregnentwomen_name='"+params[3]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class SaveStep3 extends AsyncTask {

        String query,query1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query = "update family_detail_m_lucknow set ischild5='" + params[1] +
                        "' where Applicant_ID='" + params[0] + "'";
                query1="";

                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Insert_Step2 extends AsyncTask {

        String query;
        int member_no=1;
        int child5_auto_no=1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");

            try {
                stmt = DbConn.createStatement();
              //  District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name,id,1,childName,isHealthCard,HealthCardNo,1
                query="SET IDENTITY_INSERT childrenlessthan5_rural ON insert into childrenlessthan5_rural(District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,Ischild5,child5_name,Ishealth_card,health_crd_no,health_card_type,child5_auto_no,DateOfBirth,birth_opv,birth_opv_date,birth_hepatitis,birth_hepatitis_date,birth_bcg,birth_bcg_date,first_opv,first_opv_date,first_hepatitis,first_hepatitis_date,first_dpt,first_dpt_date,second_opv,second_opv_date,second_hepatitis,second_hepatitis_date,second_dpt,second_dpt_date,third_opv,third_opv_date,third_hepatitis,third_hepatitis_date,third_dpt,third_dpt_date,nineTo12_khasra,nineTo12_khasra_date,booster_opv,booster_opv_date,booster_dpt,booster_dpt_date,booster_khasra,booster_khasra_date)"
                        +" values('"+params[0]+"', '"+params[1]+"', '"+params[2]+"', '"+params[3]+"', '"+params[4]+"', '"+params[5]+"', '"
                        +params[6] + "','" +params[7] + "','" + params[8] + "','" + params[9] + "','" + params[10] + "','" +child5_auto_no++ + "','','','' ,'','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''" +");";

Log.i("insert infant ",query);
                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Delete_Step3 extends AsyncTask {

        String query;

        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query="Delete from childrenlessthan5_rural  where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class Update_step3 extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query1 = "update childrenlessthan5_rural set child5_name= '" + params[4] + "',Ishealth_card = '" +params[2] + "',health_crd_no = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
            Log.i("query1 is", query1);

            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update childrenlessthan5_rural set child5_name= '" + params[4] + "',Ishealth_card = '" +params[2] + "',health_crd_no = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class SaveStep4 extends AsyncTask {

        String query,query1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query = "update family_detail_m_lucknow set ischild614='" + params[1] +
                        "' where Applicant_ID='" + params[0] + "'";
                query1="";

                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class SaveStep5 extends AsyncTask {

        String query,query1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query = "update family_detail_m_lucknow set Iseducated_15='" + params[1] +
                        "' where Applicant_ID='" + params[0] + "'";
                query1="";

                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }
    public static class Insert_Step5 extends AsyncTask {

        String query;
        int family_auto_no=1;
        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Log.i("add", "inside update");


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
        //   family_id,District_Code, Block_Town_Code, Gram_Ward_Code, R_U,app_name,id,Isregno_centre,Edu_centre,centre_reg_no,name,date
            try {
                stmt = DbConn.createStatement();
                //  District_Code,Block_Town_Code,Gram_Ward_Code,R_U,app_name,id,1,childName,isHealthCard,HealthCardNo,1
                query="SET IDENTITY_INSERT family_detail_m_lucknow ON insert into family_detail_m_lucknow(family_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_adhar,Applicant_ID,Applicant_mob,Ispregnent,fl_name,fl_age,Iseducated_15,Isregno_center,educenter_name,educenter_no,edu_p_name,Isagricul_land,how_land,Isbusiness,business_name,Isjob,job_type,job_desig,job_salary,Isprsnl_home,home_land,home_type,Is_home_rent, home_month_rent,Ismotorcycle,mc_number,Isother_mc,other_mc_type,other_mc_reg,Istructor_ptiler,tab_no,f_time,family_auto_no,save_ip,ischild5,ischild614)"
                        +" values('"+params[0]+"', '"+params[1]+"', '"+params[2]+"', '"+params[3]+"', '"+params[4]+"','"+params[5]+"','', '"
                        +params[6] + "','','','','','','" +params[7] + "','" + params[8] + "','" + params[9] + "','" + params[10] + "','','','','','','','','','','','','','','','','','','','','','" + params[11] + "',"+family_auto_no++ + ",'','','' " +");";

                Log.i("insert family ", query);
               stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Delete_Step5 extends AsyncTask {

        String query;

        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

                query="Delete from family_detail_m_lucknow where Applicant_ID ='"+params[0]+"' and edu_p_name='"+params[1]+"'";
                stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }
    public static class Update_step5 extends AsyncTask {

        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query1 = "update childrenlessthan5_rural set child5_name= '" + params[4] + "',Ishealth_card = '" +params[2] + "',health_crd_no = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
            Log.i("query1 is", query1);

            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update family_detail_m_lucknow set Isregno_center= '" + params[2] + "',educenter_name = '" +params[3] + "',educenter_no = '" +params[4]  +"',edu_p_name = '" +params[5]  +"' where Applicant_ID ='"+params[0]+"' and edu_p_name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Update_step6 extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query1 = "update childrenlessthan5_rural set child5_name= '" + params[4] + "',Ishealth_card = '" +params[2] + "',health_crd_no = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
            Log.i("query1 is", query1);

            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update family_detail_m_lucknow set Isagricul_land= '" + params[2] + "',how_land = '" +params[3] + "',Isbusiness = '" +params[4]  +"',business_name = '" +params[5]  +"',Isjob = '" +params[6]  +"',job_type = '" +params[7]  +"',job_desig = '" +params[8]  +"',job_salary = '" +params[9]  +"' where Applicant_ID ='"+params[0]+"' and Applicant_Name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class Update_step7 extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String query1 = "update childrenlessthan5_rural set child5_name= '" + params[4] + "',Ishealth_card = '" +params[2] + "',health_crd_no = '" +params[3]  +"' where Applicant_ID ='"+params[0]+"' and child5_name='"+params[1]+"'";
            Log.i("query1 is", query1);

            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update family_detail_m_lucknow set Ismotorcycle= '" + params[2] + "',mc_number = '" +params[3] + "',Isother_mc = '" +params[4]  +"',other_mc_type = '" +params[5]  +"',other_mc_reg = '" +params[6]  +"',Istructor_ptiler = '" +params[7]  +"' where Applicant_ID ='"+params[0]+"' and Applicant_Name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    public static class Update_step7_Urban extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();
                String query = "update family_detail_m_lucknow set Isprsnl_home= '" + params[2] + "',Is_home_rent = '" +params[3] + "',home_month_rent = '" +params[4]  +"' where Applicant_ID ='"+params[0]+"' and Applicant_Name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }


    public static class Update_women extends AsyncTask {


        @Override
        protected Object doInBackground(Object... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection DbConn = null;
            try {
                DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            Log.w("Connection", "open");
            try {
                stmt = DbConn.createStatement();

//                                    app_id,women_name,s,date1,isTT,istt1,date2,istt2,date3,isIron,date4,
//                                   isCheckup,ischeckup_1,date5,ischeckup_2,date6,ischeckup_3,date7,ischeckup_4,date8,date9,place,place_sanstha,place_niji,jb,isJsy
                String query = "update pregnent_women_details_rural set pregnentwomen_relation ='" + params[2] + "',expected_date = '" +params[3]  +"',Is_tt = '" +params[4]  +"',Is_tt1 = '" +params[5]  +"',tt1_date = '" +params[6]  +
                        "',Is_tt2 = '" +params[7]  +"',tt2_date = '" +params[8]  +"',Is_iron_t = '" +params[9]  +"',iron_t_date = '" +params[10]  +
                        "',Is_four_checkup = '" +params[11]  +"',Is_I_checkup = '" +params[12]  +"',I_checkup_date = '" +params[13]  +"',Is_II_checkup = '" +params[14]  +
                        "',II_checkup_date = '" +params[15]  + "',Is_III_checkup = '" +params[16]  +"',III_checkup_date = '" +params[17]  +
                        "',Is_IIII_checkup = '" +params[18]  +"',IIII_checkup_date = '" +params[19]  +"',delivery_place = '" +params[20]  +
                        "',delivery_place_pri = '" +params[21]  +"',delivery_place_pri_per = '" +params[22]  +"',jb_card_no = '" +params[23]  +
                        "',delivery_date = '" +params[24]  +"',jsy = '" +params[25]  +"',submitdatetime = '" +params[26]  +"' where Applicant_ID ='"+params[0]+"' and pregnentwomen_name='"+params[1]+"'";
                Log.i("query is", query);

                stmt.executeQuery(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return null;
        }

    }







    public static class RetrieveFromBackground<T extends ResultSetConvertible> extends AsyncTask<String, Void, ArrayList<T>> {
        private ProgressDialog dialog;
        private Context context;
        private ResultSetConvertible factory;
        private DataReceiver receiver;

        public RetrieveFromBackground(Context context, Database.DataReceiver receiver, ResultSetConvertible factory) {
            RetrieveFromBackground.this.context = context;
            RetrieveFromBackground.this.factory = factory;
            this.receiver = receiver;
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
            while (!Database.isConnected())
                if (!Database.connectionInProgress)
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
            receiver.onDataReceived(rs);
        }
    }

    public static class Connect extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog;
        private Context context;

        Connect(Context context) {
            Connect.this.context = context;
        }

        //        /** progress dialog to show user that the backup is processing. */
//        /**
//         * application context.
//         */
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }

        protected Void execInBackground(Void... params) {
            try {

                Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/sps;user=" + username + ";password=" + password);
                Database.DbConn = DriverManager.getConnection(connectionString, username, password);

                Log.w("Connection", "open");
                Statement stmt = DbConn.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }
//
            return null;
        }

        //
        @Override
        protected Void doInBackground(Void... params) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    execInBackground();
                }
            }).start();
            return null;
        }

        //
        @Override
        protected void onPostExecute(final Void rs) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public static interface DataReceiver<T> {
        public void onDataReceived(T data);
    }
}