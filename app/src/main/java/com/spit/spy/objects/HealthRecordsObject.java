package com.spit.spy.objects;

import android.content.Context;
import android.util.Log;

import com.spit.spy.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 6/10/2016.
 */
public class HealthRecordsObject implements ResultSetConvertible {


    public static final String TABLE_NAME = "family_detail_m_lucknow";
    public static final String PRIMARY_KEY = "id";
    private static int currentID = 0;



    String District_Code;
    int block_town_code;
    String family_id;
    String gram_ward_code;
    String rural;
    String applicant_name;
    String applicant_adhar;
    String applicant_ID;
    String applicant_mob;
    String Ispregnent;
    String fl_name;
    String fl_age;
    String Iseducated_15;
    String Isregno_center;
    String educenter_name;
    String educenter_no;
    String edu_p_name;
    String Isagricul_land;
    String how_land;
    String Isbusiness;
    String business_name;
    String Isjob;
    String job_type;
    String job_desig;
    String job_salary;
    String Isprsnl_home;
    String home_land;
    String home_type;
    String Is_home_rent;
    String home_month_rent;
    String Ismotorcycle;
    String mc_number;
    String Isother_mc;
    String other_mc_type;
    String other_mc_reg;
    String Istructor_ptiler;
    String tab_no;
    String f_time;
    String family_auto_no;
    String save_ip;
    String ischild5;
    String ischild614;
    String gender;
    int age;
    String member_name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily_id() {
        return family_id;
    }

    public void setFamily_id(String family_id) {
        this.family_id = family_id;
    }

    public String getDistrict_Code() {
        return District_Code;
    }

    public void setDistrict_Code(String district_Code) {
        District_Code = district_Code;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public HealthRecordsObject(int id, String applicant_name, String applicant_adhar, String applicant_ID, String applicant_mob, String Ispregnent, String fl_name, String fl_age, String iseducated_15, String isregno_center, String educenter_name, String educenter_no, String edu_p_name, String isagricul_land, String how_land, String isbusiness, String business_name, String isjob, String job_type, String job_desig, String job_salary, String isprsnl_home, String home_land, String home_type, String is_home_rent, String home_month_rent, String ismotorcycle, String mc_number, String isother_mc, String other_mc_type, String other_mc_reg, String istructor_ptiler, String tab_no, String f_time, String family_auto_no, String save_ip, String ischild5, String ischild614) {
        this.id = id;
        this.family_id=family_id;
        this.District_Code = District_Code;
        this.block_town_code = block_town_code;
        this.gram_ward_code = gram_ward_code;
        this.rural = rural;
        this.applicant_name = applicant_name;
        this.applicant_adhar = applicant_adhar;
        this.applicant_ID = applicant_ID;
        this.applicant_mob = applicant_mob;
        this.Ispregnent = Ispregnent;
        this.fl_name = fl_name;
        this.fl_age = fl_age;
        Iseducated_15 = iseducated_15;
        Isregno_center = isregno_center;
        this.educenter_name = educenter_name;
        this.educenter_no = educenter_no;
        this.edu_p_name = edu_p_name;
        Isagricul_land = isagricul_land;
        this.how_land = how_land;
        this.Isbusiness = isbusiness;
        this.business_name = business_name;
        Isjob = isjob;
        this.job_type = job_type;
        this.job_desig = job_desig;
        this.job_salary = job_salary;
        Isprsnl_home = isprsnl_home;
        this.home_land = home_land;
        this.home_type = home_type;
        Is_home_rent = is_home_rent;
        this.home_month_rent = home_month_rent;
        Ismotorcycle = ismotorcycle;
        this.mc_number = mc_number;
        Isother_mc = isother_mc;
        this.other_mc_type = other_mc_type;
        this.other_mc_reg = other_mc_reg;
        Istructor_ptiler = istructor_ptiler;
        this.tab_no = tab_no;
        this.f_time = f_time;
        this.family_auto_no = family_auto_no;
        this.save_ip = save_ip;
        this.ischild5 = ischild5;
        this.ischild614 = ischild614;

    }

    public HealthRecordsObject() {
    }



    public int getBlock_town_code() {
        return block_town_code;
    }

    public void setBlock_town_code(int block_town_code) {
        this.block_town_code = block_town_code;
    }

    public String getGram_ward_code() {
        return gram_ward_code;
    }

    public void setGram_ward_code(String gram_ward_code) {
        this.gram_ward_code = gram_ward_code;
    }

    public String getRural() {
        return rural;
    }

    public void setRural(String rural) {
        this.rural = rural;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getApplicant_adhar() {
        return applicant_adhar;
    }

    public void setApplicant_adhar(String applicant_adhar) {
        this.applicant_adhar = applicant_adhar;
    }

    public String getApplicant_ID() {
        return applicant_ID;
    }

    public void setApplicant_ID(String applicant_ID) {
        this.applicant_ID = applicant_ID;
    }

    public String getApplicant_mob() {
        return applicant_mob;
    }

    public void setApplicant_mob(String applicant_mob) {
        this.applicant_mob = applicant_mob;
    }

    public String getIspregnent() {
        return Ispregnent;
    }

    public void setIspregnent(String Ispregnent) {
        this.Ispregnent = Ispregnent;
    }

    public String getFl_name() {
        return fl_name;
    }

    public void setFl_name(String fl_name) {
        this.fl_name = fl_name;
    }

    public String getFl_age() {
        return fl_age;
    }

    public void setFl_age(String fl_age) {
        this.fl_age = fl_age;
    }

    public String getIseducated_15() {
        return Iseducated_15;
    }

    public void setIseducated_15(String iseducated_15) {
        Iseducated_15 = iseducated_15;
    }

    public String getIsregno_center() {
        return Isregno_center;
    }

    public void setIsregno_center(String isregno_center) {
        Isregno_center = isregno_center;
    }

    public String getEducenter_name() {
        return educenter_name;
    }

    public void setEducenter_name(String educenter_name) {
        this.educenter_name = educenter_name;
    }

    public String getEducenter_no() {
        return educenter_no;
    }

    public void setEducenter_no(String educenter_no) {
        this.educenter_no = educenter_no;
    }

    public String getEdu_p_name() {
        return edu_p_name;
    }

    public void setEdu_p_name(String edu_p_name) {
        this.edu_p_name = edu_p_name;
    }

    public String getIsagricul_land() {
        return Isagricul_land;
    }

    public void setIsagricul_land(String isagricul_land) {
        Isagricul_land = isagricul_land;
    }

    public String getHow_land() {
        return how_land;
    }

    public void setHow_land(String how_land) {
        this.how_land = how_land;
    }

    public String getIsbusiness() {
        return Isbusiness;
    }

    public void setIsbusiness(String isbusiness) {
        Isbusiness = isbusiness;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getIsjob() {
        return Isjob;
    }

    public void setIsjob(String isjob) {
        Isjob = isjob;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_desig() {
        return job_desig;
    }

    public void setJob_desig(String job_desig) {
        this.job_desig = job_desig;
    }

    public String getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
    }

    public String getIsprsnl_home() {
        return Isprsnl_home;
    }

    public void setIsprsnl_home(String isprsnl_home) {
        Isprsnl_home = isprsnl_home;
    }

    public String getHome_land() {
        return home_land;
    }

    public void setHome_land(String home_land) {
        this.home_land = home_land;
    }

    public String getHome_type() {
        return home_type;
    }

    public void setHome_type(String home_type) {
        this.home_type = home_type;
    }

    public String getIs_home_rent() {
        return Is_home_rent;
    }

    public void setIs_home_rent(String is_home_rent) {
        Is_home_rent = is_home_rent;
    }

    public String getHome_month_rent() {
        return home_month_rent;
    }

    public void setHome_month_rent(String home_month_rent) {
        this.home_month_rent = home_month_rent;
    }

    public String getIsmotorcycle() {
        return Ismotorcycle;
    }

    public void setIsmotorcycle(String ismotorcycle) {
        Ismotorcycle = ismotorcycle;
    }

    public String getMc_number() {
        return mc_number;
    }

    public void setMc_number(String mc_number) {
        this.mc_number = mc_number;
    }

    public String getIsother_mc() {
        return Isother_mc;
    }

    public void setIsother_mc(String isother_mc) {
        Isother_mc = isother_mc;
    }

    public String getOther_mc_type() {
        return other_mc_type;
    }

    public void setOther_mc_type(String other_mc_type) {
        this.other_mc_type = other_mc_type;
    }

    public String getOther_mc_reg() {
        return other_mc_reg;
    }

    public void setOther_mc_reg(String other_mc_reg) {
        this.other_mc_reg = other_mc_reg;
    }

    public String getIstructor_ptiler() {
        return Istructor_ptiler;
    }

    public void setIstructor_ptiler(String istructor_ptiler) {
        Istructor_ptiler = istructor_ptiler;
    }

    public String getTab_no() {
        return tab_no;
    }

    public void setTab_no(String tab_no) {
        this.tab_no = tab_no;
    }

    public String getF_time() {
        return f_time;
    }

    public void setF_time(String f_time) {
        this.f_time = f_time;
    }

    public String getFamily_auto_no() {
        return family_auto_no;
    }

    public void setFamily_auto_no(String family_auto_no) {
        this.family_auto_no = family_auto_no;
    }

    public String getSave_ip() {
        return save_ip;
    }

    public void setSave_ip(String save_ip) {
        this.save_ip = save_ip;
    }

    public String getIschild5() {
        return ischild5;
    }

    public void setIschild5(String ischild5) {
        this.ischild5 = ischild5;
    }

    public String getIschild614() {
        return ischild614;
    }

    public void setIschild614(String ischild614) {
        this.ischild614 = ischild614;
    }


    public static void getAllPensioners(Context context, Database.DataReceiver receiver) {
        currentID = 0;
        ArrayList<HealthRecordsObject> pensioners = new ArrayList();

        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new HealthRecordsObject(),
                "select "+ TABLE_NAME + ".Applicant_Name,Applicant_adhar,"+ TABLE_NAME + ".Applicant_ID,Applicant_mob,Ispregnent,fl_name,"+
                "fl_age, iseducated_15, isregno_center, educenter_name, educenter_no, edu_p_name,isagricul_land, how_land," +
                "isbusiness, business_name, isjob, job_type,job_desig,job_salary,isprsnl_home,home_land, home_type,is_home_rent," +
                "home_month_rent,ismotorcycle,mc_number,isother_mc,other_mc_type,other_mc_reg,istructor_ptiler,tab_no,f_time," +
                "family_auto_no, save_ip,ischild5,ischild614,member_gen,member_age, member_name from "+TABLE_NAME+",member_detail_m_3132005_27052016 where "+TABLE_NAME+".Applicant_ID=member_detail_m_3132005_27052016.Applicant_ID"
        );


    }

    public static void getAll (final Context context, final Database.DataReceiver receiver,String id, String name) {
        currentID = 0;
        System.out.println("id" + id);

        if (!Database.isConnected())
            Database.connect(context);
        String query = "select Isregno_center,educenter_name,educenter_no,edu_p_name from " + TABLE_NAME + " where Applicant_ID = '" + id + "'" + "and Applicant_Name= '" + name + "'";
        Log.i("query get all", query);
        String query1="select family_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U, Applicant_Name,Applicant_adhar,Applicant_ID,Applicant_mob,Ispregnent,fl_name,"+
        "fl_age, iseducated_15, isregno_center, educenter_name, educenter_no, edu_p_name,isagricul_land, how_land," +
                "isbusiness, business_name, Isjob, job_type,job_desig,job_salary,isprsnl_home,home_land, home_type,is_home_rent," +
                "home_month_rent,ismotorcycle,mc_number,isother_mc,other_mc_type,other_mc_reg,istructor_ptiler,tab_no,f_time," +
                "family_auto_no, save_ip,ischild5,ischild614 from " + TABLE_NAME + " where Applicant_ID = '" + id + "'" + "and Applicant_Name= '" + name + "'";
Log.i("query new ",query1);
        Database.execQueryWithDialog(
                context,
                receiver,
                new HealthRecordsObject(),

                "select family_id,District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_adhar,Applicant_ID,Applicant_mob,Ispregnent,fl_name," +
                        "fl_age, iseducated_15, isregno_center, educenter_name, educenter_no, edu_p_name,isagricul_land, how_land," +
                        "isbusiness, business_name, Isjob, job_type,job_desig,job_salary,isprsnl_home,home_land, home_type,is_home_rent," +
                        "home_month_rent,ismotorcycle,mc_number,isother_mc,other_mc_type,other_mc_reg,istructor_ptiler,tab_no,f_time," +
                        "family_auto_no, save_ip,ischild5,ischild614 from " + TABLE_NAME + " where Applicant_ID = '" + id + "'" + "and Applicant_Name= '" + name + "'"


                );
    }




    public HealthRecordsObject convert (ResultSet resultSet) {
        HealthRecordsObject pensioner = null;

        try {
            pensioner = new HealthRecordsObject(
                    HealthRecordsObject.currentID++,
                    resultSet.getString("Applicant_Name"),
                    resultSet.getString("Applicant_adhar"),
                    resultSet.getString("Applicant_ID"),
                    resultSet.getString("Applicant_mob"),
                    resultSet.getString("Ispregnent"),
                    resultSet.getString("fl_name"),
                    resultSet.getString("fl_age"),
                    resultSet.getString("Iseducated_15"),
                    resultSet.getString("Isregno_center"),
                    resultSet.getString("educenter_name"),
                    resultSet.getString("educenter_no"),
                    resultSet.getString("edu_p_name"),
                    resultSet.getString("Isagricul_land"),
                    resultSet.getString("how_land"),
                    resultSet.getString("Isbusiness"),
                    resultSet.getString("business_name"),
                    resultSet.getString("isjob"),
                    resultSet.getString("job_type"),
                    resultSet.getString("job_desig"),
                    resultSet.getString("job_salary"),
                    resultSet.getString("Isprsnl_home"),
                    resultSet.getString("home_land"),
                    resultSet.getString("home_type"),
                    resultSet.getString("Is_home_rent"),
                    resultSet.getString("home_month_rent"),
                    resultSet.getString("Ismotorcycle"),
                    resultSet.getString("mc_number"),
                    resultSet.getString("Isother_mc"),
                    resultSet.getString("other_mc_type"),
                    resultSet.getString("other_mc_reg"),
                    resultSet.getString("istructor_ptiler"),
                    resultSet.getString("tab_no"),
                    resultSet.getString("f_time"),
                    resultSet.getString("family_auto_no"),
                    resultSet.getString("save_ip"),
                    resultSet.getString("ischild5"),
                    resultSet.getString("ischild614")
            );
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return pensioner;
    }

    public static void update (Context context, Database.DataReceiver receiver, String id, HealthRecordsObject pensioners) {
        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new HealthRecordsObject(),
                "update " + TABLE_NAME + " set Applicant_adhar= " + pensioners.getApplicant_adhar() + "," +
                        " Applicant_mob = " + pensioners.getApplicant_mob() +"where Applicant_ID = '"+id+"'"
        );
    }


}
