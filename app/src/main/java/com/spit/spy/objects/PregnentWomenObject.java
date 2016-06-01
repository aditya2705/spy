package com.spit.spy.objects;

import android.content.Context;

import com.spit.spy.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 - * Created by Aditya Rathi on 10-Apr-16.
 + * Created by  on 10-Apr-16.
 */
public class PregnentWomenObject implements ResultSetConvertible {

    public static final String TABLE_NAME = "pregnent_women_details_rural";
    public static final String PRIMARY_KEY = "id";
    private static int currentId = 0;

    private int id;
    String labharti_id;
    private String labharti_name, father_name, gender;
    private int age;
    private String category;
    private String applicant_name;
    private String rural;
    private String block_town_code;
    private String district_code;
    //opv,bcg,hepatitis b

    public PregnentWomenObject(int id, String labharti_id, String labharti_name, String father_name, String gender, int age, String category, String applicant_name, String rural, String block_town_code, String district_code) {
        this.id = id;
        this.labharti_id = labharti_id;
        this.labharti_name = labharti_name;
        this.father_name = father_name;
        this.gender = gender;
        this.age = age;
        this.category = category;
        this.applicant_name = applicant_name;
        this.rural = rural;
        this.block_town_code = block_town_code;
        this.district_code = district_code;
    }

    public PregnentWomenObject(int id, String labharti_id, String labharti_name, String father_name, String gender, int age, String category) {
        this.id = id;
        this.labharti_id = labharti_id;
        this.labharti_name = labharti_name;
        this.father_name = father_name;
        this.gender = gender;
        this.age = age;
        this.category = category;
    }

    public PregnentWomenObject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabharti_id() {
        return labharti_id;
    }

    public void setLabharti_id(String labharti_id) {
        this.labharti_id = labharti_id;
    }
    public String getRural() {
        return rural;
    }

    public void setRural(String rural) {
        this.rural = rural;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public String getBlock_town_code() {
        return block_town_code;
    }
    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getLabharti_name() {
        return labharti_name;
    }

    public void setLabharti_name(String labharti_name) {
        this.labharti_name = labharti_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBlock_town_code(String block_town_code) {
        this.block_town_code = block_town_code;
    }

    private static String makeLabarthiID (String districtCode, int rural, int srNo) {
        String lbID = "";

        lbID += String.valueOf(districtCode);
        if (rural == 1)
            lbID += "1";
        else
            lbID += "2";
        lbID += srNo;
        lbID += "S";
        return lbID;
    }

    public static List<PregnentWomenObject> getAll (Context context) {
        int currentId = 1;
        ArrayList<PregnentWomenObject> pregnentWomenObjects = new ArrayList();

        if (!Database.isConnected())
            Database.connect(context);

        pregnentWomenObjects = Database.execQueryWithDialog(
                context,
                new PregnentWomenObject(),
                "select category_name, Form_Sr, Block_Town_Code, District_Code, R_U, Gender, Age, Applicant_Fname, Applicant_Name from " + TABLE_NAME
        );

//        try {
//            while (resultSet.next()) {
//                PregnentWomenObject pregnentWomenObject = new PregnentWomenObject(
//                        currentId++,
//                        makeLabarthiID(resultSet.getString("District_Code"),
//                                resultSet.getInt("R_U"),
//                                resultSet.getInt("Form_Sr")),
//                        resultSet.getString("Applicant_Name"),
//                        resultSet.getString("Applicant_Fname"),
//                        resultSet.getString("Gender"),
//                        resultSet.getInt("Age"),
//                        resultSet.getString("category"),
//                        resultSet.getString("Applicant_Name"),
//                        resultSet.getString("R_U"),
//                        resultSet.getString("Block_Town_Code"),
//                        resultSet.getString("District_Code")
//                );
//                pregnentWomenObjects.add(pregnentWomenObject);
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
        return pregnentWomenObjects;
    }



    public static void update (Context context, String id, PensionerObject pensioner) {
        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                new PregnentWomenObject(),
                "update " + TABLE_NAME + " set category_name = " + pensioner.getCategory() + "," +
                        " District_Code = " + pensioner.getDistrict_code() + "," +
                        " R_U = " + pensioner.getRural() + "," +
                        " Gender = " + pensioner.getGender() + "," +
                        " Age = " + pensioner.getAge() + "," +
                        " Applicant_Fname = " + pensioner.getFather_name() + "," +
                        " Applicant_Name = " + pensioner.getApplicant_name() +
                        " where " + PRIMARY_KEY + " = " + id
        );
    }

    public PregnentWomenObject convert (ResultSet resultSet) {
        PregnentWomenObject pregnentWomenObject = null;
            try {
                pregnentWomenObject = new PregnentWomenObject(
                        PregnentWomenObject.currentId++,
                        makeLabarthiID(resultSet.getString("District_Code"),
                                resultSet.getInt("R_U"),
                                resultSet.getInt("Form_Sr")),
                        resultSet.getString("Applicant_Name"),
                        resultSet.getString("Applicant_Fname"),
                        resultSet.getString("Gender"),
                        resultSet.getInt("Age"),
                        resultSet.getString("category"),
                        resultSet.getString("Applicant_Name"),
                        resultSet.getString("R_U"),
                        resultSet.getString("Block_Town_Code"),
                        resultSet.getString("District_Code")
                );
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        return pregnentWomenObject;
    }
}
