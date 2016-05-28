//package com.spit.spy.objects;
//
//import com.spit.spy.Database;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by admin on 5/28/2016.
// */
//public class InfantObject {
//
//    public static final String TABLE_NAME = "samajwadi_paid_lucknow";
//    public static final String PRIMARY_KEY = "id";
//
//    private int id;
//    private String applicant_name;
//    private String rural;
//    private String block_town_code;
//    private String district_code;
//    private String gram_ward_code;
//    private String applicant_id;
//    private int is_child_5;
//    private int is_health_card;
//    private int auto_no;
//    private String date_of_birth;
//    private int birth_opv;
//    private String opv_date;
//    private int birth_hepatitis;
//    private String hepatitis_date;
//    private
//
//
//
//    private static String makeLabarthiID (String districtCode, int rural, int srNo) {
//        String lbID = "";
//        lbID += String.valueOf(districtCode);
//        if (rural == 1)
//            lbID += "1";
//        else
//            lbID += "2";
//        lbID += srNo;
//        return lbID;
//    }
//
//    public static List<PensionerObject> getAll () {
//        int currentId = 1;
//        ArrayList<PensionerObject> pensioners = new ArrayList();
//
//        if (!Database.isConnected())
//            Database.connect();
//
//        ResultSet resultSet = Database.execQuery(
//                "select category_name, Form_Sr, Block_Town_Code, District_Code, R_U, Gender, Age, Applicant_Fname, Applicant_Name from " + TABLE_NAME
//        );
//
//        try {
//            while (resultSet.next()) {
//                PensionerObject pensioner = new PensionerObject(
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
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        return pensioners;
//    }
//
//    public static void add (PensionerObject pensioner) {
//        String valueString =
//                String.valueOf(pensioner.getId()) + ", " +
//                        String.valueOf(pensioner.getLabharti_id()) + ", " +
//                        String.valueOf(pensioner.getLabharti_id());
//
//        if (!Database.isConnected())
//            Database.connect();
//
//        Database.execQuery(
//                "insert into " + TABLE_NAME + "(category_name, District_Code, R_U, Gender, Age, Applicant_Fname, Applicant_Name)" +
//                        " values(" + pensioner.getCategory() + "," + pensioner.getDistrict_code() + "," + pensioner.getRural() + "," +
//                        pensioner.getGender() + "," + pensioner.getAge() + "," + pensioner.getFather_name() +
//                        "," +pensioner.getApplicant_name() +")"
//
//        );
//    }
//
//    public static void update (String id, PensionerObject pensioner) {
//        if (!Database.isConnected())
//            Database.connect();
//
//        Database.execQuery(
//                "update " + TABLE_NAME + " set category_name = " + pensioner.getCategory() + "," +
//                        " District_Code = " + pensioner.getDistrict_code() + "," +
//                        " R_U = " + pensioner.getRural() + "," +
//                        " Gender = " + pensioner.getGender() + "," +
//                        " Age = " + pensioner.getAge() + "," +
//                        " Applicant_Fname = " + pensioner.getFather_name() + "," +
//                        " Applicant_Name = " + pensioner.getApplicant_name()
//
//        );
//    }
//
//}
