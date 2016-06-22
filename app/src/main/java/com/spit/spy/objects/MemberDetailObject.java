package com.spit.spy.objects;

import android.content.Context;
import android.util.Log;

import com.spit.spy.Database;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 6/11/2016.
 */
public class MemberDetailObject implements ResultSetConvertible {
    public static final String TABLE_NAME = "member_detail_m_3132005_27052016";
    public static final String PRIMARY_KEY = "id";
    private static int currentID = 0;
    public static String upOrAdd = "add";
    public static int member_auto_no = 5000000;





    private int id;
    String member_id;
    String District_Code;
    String Block_Town_Code;
    String Gram_Ward_Code;
    String R_U;
    String Applicant_Name;
    String Applicant_ID;
    String member_name;
    String member_relation;
    String member_age;
    String member_gen;
    String Iseducated;
    String Ismarried;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getDistrict_Code() {
        return District_Code;
    }

    public void setDistrict_Code(String district_Code) {
        District_Code = district_Code;
    }

    public String getBlock_Town_Code() {
        return Block_Town_Code;
    }

    public void setBlock_Town_Code(String block_Town_Code) {
        Block_Town_Code = block_Town_Code;
    }

    public String getGram_Ward_Code() {
        return Gram_Ward_Code;
    }

    public void setGram_Ward_Code(String gram_Ward_Code) {
        Gram_Ward_Code = gram_Ward_Code;
    }

    public String getR_U() {
        return R_U;
    }

    public void setR_U(String r_U) {
        R_U = r_U;
    }




    public MemberDetailObject(int id,String upOrAdd,String member_id, String District_Code,String Block_Town_Code,String Gram_Ward_Code,
                              String R_U,String Applicant_Name, String Applicant_ID, String member_name, String member_relation,
                              String member_age,String member_gen, String iseducated, String ismarried) {
        this.upOrAdd="add";
        this.id=id;
        this.member_id=member_id;
        this.District_Code=District_Code;
        this.Block_Town_Code=Block_Town_Code;
        this.Gram_Ward_Code=Gram_Ward_Code;
        this.R_U=R_U;
        this.Applicant_Name = Applicant_Name;
        this.Applicant_ID = Applicant_ID;
        this.member_name = member_name;
        this.member_relation = member_relation;
        this.member_age = member_age;
        this.member_gen = member_gen;
        Iseducated = iseducated;
        Ismarried = ismarried;
    }
    public MemberDetailObject() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getIsmarried() {
        return Ismarried;
    }

    public void setIsmarried(String ismarried) {
        Ismarried = ismarried;
    }

    public String getIseducated() {
        return Iseducated;
    }

    public void setIseducated(String iseducated) {
        Iseducated = iseducated;
    }

    public String getMember_gen() {
        return member_gen;
    }

    public void setMember_gen(String member_gen) {
        this.member_gen = member_gen;
    }

    public String getMember_age() {
        return member_age;
    }

    public void setMember_age(String member_age) {
        this.member_age = member_age;
    }

    public String getMember_relation() {
        return member_relation;
    }

    public void setMember_relation(String member_relation) {
        this.member_relation = member_relation;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getApplicant_ID() {
        return Applicant_ID;
    }

    public void setApplicant_ID(String applicant_ID) {
        Applicant_ID = applicant_ID;
    }

    public String getApplicant_Name() {
        return Applicant_Name;
    }

    public void setApplicant_Name(String applicant_Name) {
        Applicant_Name = applicant_Name;
    }


    public static void getAll (final Context context, final Database.DataReceiver receiver,String id) {
        currentID=0;
        System.out.println("id"+id);

        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new MemberDetailObject(),
                "select member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,member_name,member_relation,member_age,member_gen,Iseducated,Ismarried from "+TABLE_NAME+" where Applicant_id = '"+id+"'"
        );



    }

    public static void get_Member_Detail (final Context context, final Database.DataReceiver receiver,String id,String name) {
        currentID=0;
        upOrAdd="up";
        System.out.println("id" + id);
String query=  "select distinct member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,member_name,member_relation,member_age,member_gen,Iseducated,Ismarried from "+TABLE_NAME+" where Applicant_ID = '"+id+"' and member_name='"+name+"'";
Log.i("query is ", query);
        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new MemberDetailObject(),
                "select distinct member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,member_name,member_relation,member_age,member_gen,Iseducated,Ismarried from "+TABLE_NAME+" where Applicant_ID = '"+id+"' and member_name='"+name+"'"
        );



    }

//    public static void insert(Context context,Database.DataReceiver receiver,String member_id,String District_Code,String Block_Town_Code,String Gram_Ward_Code,String R_U,
//                              String Applicant_Name,String Applicant_ID,String m_name,String member_relation,String member_age,
//                              String member_gen,String Iseducated,String Ismarried)  {
//
//        if (!Database.isConnected())
//            Database.connect(context);
//        upOrAdd="none";
//
//        Database.execQueryWithDialog(
//                context,
//                receiver,
//                new PensionerObject(),
//                "SET IDENTITY_INSERT " +TABLE_NAME+ " ON insert into " +TABLE_NAME+ "(member_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,member_name,member_relation,member_age,member_gen,Iseducated,Ismarried,member_auto_no,Is_family_planning,family_planning_type,family_planning_type_description,family_planning_type_other_description) values('"+member_id+"','"+District_Code+"','"+Block_Town_Code+"','"+Gram_Ward_Code+"','"+R_U+"','"+Applicant_Name+"','"
//                +Applicant_ID+"','"+m_name+"','"+member_relation+"','"+member_age+"','"+member_gen+"','"+Iseducated+"','"+Ismarried+"','"+member_auto_no+"',NULL,NULL,NULL,NULL)"
//
//        );
//
//
//
//        String q= "insert into " + TABLE_NAME + " values("+"'"+member_id+"','"+District_Code+"','"+Block_Town_Code+"','"+Gram_Ward_Code+"','"+R_U+"','"+Applicant_Name+"','"
//                +Applicant_ID+"','"+m_name+"','"+member_relation+"','"+member_age+"','"+member_age+"','"+member_gen+"','"+Iseducated+"','"+Ismarried+"','"+member_auto_no+"',NULL,NULL,NULL,NULL)";
//        System.out.println("query is"+q);
//
//    }

    public MemberDetailObject convert (ResultSet resultSet) {

        MemberDetailObject members = null;
        try {
           members = new MemberDetailObject(
                    MemberDetailObject.currentID++,
                   MemberDetailObject.upOrAdd,
                    resultSet.getString("member_id"),
                    resultSet.getString("District_Code"),
                    resultSet.getString("Block_Town_Code"),
                    resultSet.getString("Gram_ward_Code"),
                    resultSet.getString("R_U"),
                   resultSet.getString("Applicant_Name"),
                    resultSet.getString("Applicant_ID"),
                    resultSet.getString("member_name"),
                    resultSet.getString("member_relation"),
                    resultSet.getString("member_age"),
                    resultSet.getString("member_gen"),
                    resultSet.getString("Iseducated"),
                    resultSet.getString("Ismarried")
            );

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return members;
    }


}





