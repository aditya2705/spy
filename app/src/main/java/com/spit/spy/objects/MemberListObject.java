package com.spit.spy.objects;

/**
 * Created by admin on 6/20/2016.
 */

import android.content.Context;

        import com.spit.spy.Database;

        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * Created by Varsha Shetty on 6/16/2016.
 */
public class MemberListObject implements ResultSetConvertible {
    private static int currentID = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MemberListObject(int id, String ID_FORIDCARD, String applicant_Name, String age, String gender, String category_name) {
        this.id = id;
        this.ID_FORIDCARD = ID_FORIDCARD;
        Applicant_Name = applicant_Name;
        Age = age;
        Gender = gender;
        this.category_name = category_name;
    }

    public MemberListObject() {}

    private int id;
    String ID_FORIDCARD;
    String Applicant_Name;
    String Age;
    String Gender;
    String category_name;


    public String getID_FORIDCARD() {
        return ID_FORIDCARD;
    }

    public void setID_FORIDCARD(String ID_FORIDCARD) {
        this.ID_FORIDCARD = ID_FORIDCARD;
    }

    public String getApplicant_Name() {
        return Applicant_Name;
    }

    public void setApplicant_Name(String applicant_Name) {
        Applicant_Name = applicant_Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }



    public static void getAll(final Context context, final Database.DataReceiver receiver) {
        int currentId = 1;


        if (!Database.isConnected())
        {
            Database.connect(context);
        }


        Database.execQueryWithDialog(
                context,
                receiver,
                new MemberListObject(),
                "select ID_FORIDCARD,Applicant_Name,Age,Gender,category_name from samajwadi_paid_lucknow"



        );


    }

    public static void getDetails(final Context context, final Database.DataReceiver receiver,String name) {
        int currentId = 1;


        if (!Database.isConnected())
        {
            Database.connect(context);
        }


        Database.execQueryWithDialog(
                context,
                receiver,
                new MemberListObject(),
                "select ID_FORIDCARD,Applicant_Name,Age,Gender,category_name from samajwadi_paid_lucknow where Applicant_Name='"+name+"'"



        );


    }

    public MemberListObject convert (ResultSet resultSet) {
        MemberListObject women = null;
        try {
            women = new MemberListObject(
                    MemberListObject.currentID++,
                    resultSet.getString("ID_FORIDCARD"),
                    resultSet.getString("Applicant_Name"),
                    resultSet.getString("Age"),
                    resultSet.getString("Gender"),
                    resultSet.getString("category_name")
            );


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


        return women;
    }




}
