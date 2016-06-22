package com.spit.spy.objects;

import android.content.Context;
import android.util.Log;

import com.spit.spy.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 6/22/2016.
 */
public class LoginObject implements ResultSetConvertible {


    public static final String TABLE_NAME_LOGIN = "UserDetail_Education";
    public static final String TABLE_NAME_DISTRICT = "district_health_all";
    public static final String TABLE_NAME_BLOCK = "Block_Paid_lucknow";
    public static final String TABLE_NAME_TOWN = "Town_Paid__lucknow";
    public static final String TABLE_NAME_PANCHAYAT = "panchayat_paid_lucknow";
    public static final String TABLE_NAME_WARD = "ward_paid_lucknow";
    public static String TABLE_NAME;

    String district_code;
    String district_name;
    String District_Code;
    String  R_U;
    String Block_Town_Code;
    String block_town_name;
    String UserName;
    String Password;
    String Gram_Ward_Code;




    public LoginObject(String district_code,String district_name,String District_Code,String R_U,String Block_Town_Code,String block_town_name,String UserName,String Password,String Gram_Ward_Code) {

        this.district_code=district_code;
        this.district_name=district_name;
        this.District_Code = District_Code;
        this.R_U=R_U;
        this.Block_Town_Code=Block_Town_Code;
        this.block_town_name=block_town_name;
        this.UserName=UserName;
        this.Password=Password;
         this.Gram_Ward_Code=Gram_Ward_Code;
    }

    public LoginObject() {

    }
    public String getdistrict_code() {
        return district_code;
    }

    public void setdistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getGram_Ward_Code() {
        return Gram_Ward_Code;
    }

    public void setGram_Ward_Code(String Gram_Ward_Code) {
        this.Gram_Ward_Code = Gram_Ward_Code;
    }
    public String getBlock_Town_Code() {
        return Block_Town_Code;
    }

    public void setBlock_Town_Code(String Block_Town_Code) {
        this.Block_Town_Code = Block_Town_Code;
    }
    public String getDistrict_Code() {

        Log.i("CODE is",District_Code);
        return  District_Code;
    }
    public String getR_U() {
        return R_U;
    }

    public void setR_U(String district_code) {
        this.R_U = R_U;
    }


    public String getdistrict_name() {
        return district_name;
    }

    public void setdistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getBlock_town_name() {
        return block_town_name;
    }

    public void setBlock_town_name(String block_town_name) {
        this.block_town_name = block_town_name;
    }









    public static void getPassword(Context context, Database.DataReceiver receiver,String UserName) {

        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new LoginObject(),
                " select Password from"+TABLE_NAME_LOGIN+" where UserName='"+UserName+"'"
        );


    }



    public static void Login_Validation(Context context, Database.DataReceiver receiver,String DistrictCode,String R_U,String BlockTownCode) {

        if (!Database.isConnected())
            Database.connect(context);
String query= "select " + TABLE_NAME_LOGIN + ".UserName," + TABLE_NAME_LOGIN + ".Password,"+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name from "+TABLE_NAME_LOGIN+","+TABLE_NAME_DISTRICT+" where "+ TABLE_NAME_LOGIN +".District_Code='"+DistrictCode+"' and "+ TABLE_NAME_LOGIN +".R_U ='"+R_U+"' and "+TABLE_NAME_LOGIN +".Block_Town_Code ='"+BlockTownCode+"'";
        Log.i("query login ",query);


        Database.execQueryWithDialog(
                context,
                receiver,
                new LoginObject(),
                "select " + TABLE_NAME_LOGIN + ".UserName," + TABLE_NAME_LOGIN + ".Password,"+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name from "+TABLE_NAME_LOGIN+","+TABLE_NAME_DISTRICT+" where "+ TABLE_NAME_LOGIN +".District_Code='"+DistrictCode+"' and "+ TABLE_NAME_LOGIN +".R_U ='"+R_U+"' and "+TABLE_NAME_LOGIN +".Block_Town_Code ='"+BlockTownCode+"'"
        );


    }





    public static void getDistrict_Code(Context context, Database.DataReceiver receiver,String DistrictName) {

        if (!Database.isConnected())
            Database.connect(context);
String query=  "select "+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name,"+TABLE_NAME_LOGIN+".District_Code,R_U,Block_Town_Code,"+TABLE_NAME_LOGIN+".block_town_name,UserName,Password from "+TABLE_NAME_DISTRICT+","+TABLE_NAME_LOGIN+" where "+TABLE_NAME_DISTRICT+".district_name='"+DistrictName+"'";
        Log.i("district query",query);
        Database.execQueryWithDialog(
                context,
                receiver,
                new LoginObject(),
                "select " + TABLE_NAME_DISTRICT + ".district_code," + TABLE_NAME_DISTRICT + ".district_name," + TABLE_NAME_LOGIN + ".District_Code,R_U,"+ TABLE_NAME_LOGIN + ".Block_Town_Code," + TABLE_NAME_LOGIN + ".block_town_name,UserName,Password,"+TABLE_NAME_PANCHAYAT+".Gram_Ward_Code from " + TABLE_NAME_DISTRICT+","+TABLE_NAME_LOGIN+","+TABLE_NAME_PANCHAYAT+" where "+TABLE_NAME_DISTRICT+".district_name='"+DistrictName+"'"
        );

        Log.i("after query","after dist query");

    }


    public static void getBlock_TownCode(Context context, Database.DataReceiver receiver,String Block_Town_Name,String R_U,String District_Code) {

        if(R_U.equals("1"))
           TABLE_NAME="Block_Paid_lucknow";
        else if(R_U.equals("2"))
        TABLE_NAME="Town_Paid__lucknow";


String query=  "select "+TABLE_NAME+".Block_Town_Code,"+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name,"+TABLE_NAME_LOGIN+". District_Code,R_U,"+TABLE_NAME_LOGIN+".block_town_name,UserName,Password,UserType from "+TABLE_NAME_DISTRICT+","+TABLE_NAME_LOGIN+","+TABLE_NAME+" where "+TABLE_NAME+".block_town_name='"+Block_Town_Name +
        "' and "+TABLE_NAME+".District_Code = '"+District_Code+"'";
        Log.i("query block is",query);

        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new LoginObject(),
                "select "+TABLE_NAME+".Block_Town_Code,"+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name,"+TABLE_NAME_LOGIN+".District_Code,R_U,"+TABLE_NAME_LOGIN+".block_town_name,UserName,Password,"+TABLE_NAME_PANCHAYAT+".Gram_Ward_Code from "+TABLE_NAME_DISTRICT+","+TABLE_NAME_LOGIN+","+TABLE_NAME+","+TABLE_NAME_PANCHAYAT+" where "+TABLE_NAME+".block_town_name='"+Block_Town_Name +
                        "' and "+TABLE_NAME+".District_Code = '"+District_Code+"'"

        );


    }

    public static void getGram_WardCode(Context context, Database.DataReceiver receiver,String Gram_Ward_Name,String R_U,String District_Code) {

        if(R_U.equals("1"))
            TABLE_NAME="panchayat_paid_lucknow";
        else if(R_U.equals("2"))
            TABLE_NAME="ward_paid_lucknow";





        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new LoginObject(),
                "select "+TABLE_NAME+".Gram_Ward_Code,"+TABLE_NAME_DISTRICT+".district_code,"+TABLE_NAME_DISTRICT+".district_name,"+TABLE_NAME_LOGIN+".District_Code,R_U,"+TABLE_NAME_LOGIN+".Block_Town_Code,"+TABLE_NAME_LOGIN+".block_town_name,UserName,Password from "+TABLE_NAME_DISTRICT+","+TABLE_NAME_LOGIN+","+TABLE_NAME+" where "+TABLE_NAME+".panchayat_ward_name='"+Gram_Ward_Name +
                        "' and "+TABLE_NAME+".District_Code = '"+District_Code+"'"

        );


    }
    public LoginObject convert (ResultSet resultSet) {
        LoginObject login = null;

        try {
            login = new LoginObject(
                    resultSet.getString("district_code"),
                    resultSet.getString("district_name"),
                    resultSet.getString("District_Code"),
                    resultSet.getString("R_U"),
                    resultSet.getString("Block_Town_Code"),
                    resultSet.getString("block_town_name"),
                    resultSet.getString("UserName"),
                    resultSet.getString("Password"),
                     resultSet.getString("Gram_Ward_Code")
            );
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return login;
    }

}
