package com.spit.spy.objects;

import android.util.Log;

import java.util.Date;

/**
 * Created by Vaibhavi and Twinkle on 06/22/2016.
 */
public class LoginCredentialObject {

    String District_Code;
    String  R_U;
    String Block_Town_Code;
    String block_town_name;
    String UserName;
    String Password;

    public LoginCredentialObject(String District_Code,String R_U,String Block_Town_Code,String block_town_name,String UserName,String Password) {

        this.District_Code = District_Code;
        this.R_U=R_U;
        this.Block_Town_Code=Block_Town_Code;
        this.block_town_name=block_town_name;
        this.UserName=UserName;
        this.Password=Password;
    }


    public String getBlock_Town_Code() {
        return Block_Town_Code;
    }

    public void setBlock_Town_Code(String Block_Town_Code) {
        this.Block_Town_Code = Block_Town_Code;
    }
    public String getDistrict_Code() {

        Log.i("CODE is", District_Code);
        return  District_Code;
    }
    public String getR_U() {
        return R_U;
    }

    public void setR_U(String district_code) {
        this.R_U = R_U;
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
}
