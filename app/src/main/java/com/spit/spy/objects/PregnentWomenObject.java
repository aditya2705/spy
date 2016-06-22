package com.spit.spy.objects;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import com.spit.spy.Database;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 - * Created by Aditya Rathi on 10-Apr-16.
 + * Created by  on 10-Apr-16.
 */
public class PregnentWomenObject implements ResultSetConvertible {

    public static final String TABLE_NAME = "pregnent_women_details_rural";
    public static final String PRIMARY_KEY = "id";

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        PregnentWomenObject.currentID = currentID;
    }

    private static int currentID = 0;


    private int id;

    private String District_Code;
    private String Block_Town_Code;
    private String Gram_Ward_Code;
    private String rural;
    private String Applicant_ID;
    private String pregnentwomen_name;
    private String pregnentwomen_age;
    private String pregnentwomen_relation;
    private Date pregnentwomen_dob;
    private String gender;
    private String Is_tt;
    private String Is_tt1;
    private Date tt1_date;
    private String Is_tt2;
    private Date tt2_date;
    private String Is_iron_t;
    private Date iron_t_date;
    private String Is_four_checkup;
    private String Is_I_checkup;
    private Date I_checkup_date;
    private String expected_date;
    private String Is_II_checkup;
    private Date II_checkup_date;
    private String Is_III_checkup;
    private Date III_checkup_date;
    private String delivery_place;
    private String delivery_place_pri;
    private String delivery_place_pri_per;
    private String jb_card_no;
    private Date delivery_date;
    private String jsy;
    private Date submitdatetime;


    public PregnentWomenObject(int id,String district_Code, String block_Town_Code, String gram_Ward_Code, String rural, String applicant_ID, String pregnentwomen_name,
                               String pregnentwomen_age, String pregnentwomen_relation, Date pregnentwomen_dob, String gender, String Is_tt, String Is_tt1, Date tt1_date,
                               String Is_tt2, Date tt2_date, String Is_iron_t, Date iron_t_date, String Is_four_checkup, String Is_I_checkup, Date I_checkup_date, String expected_date,
                               String Is_II_checkup, Date II_checkup_date, String Is_III_checkup, Date III_checkup_date,
                               String delivery_place, String delivery_place_pri, String delivery_place_pri_per, String jb_card_no, Date delivery_date, String jsy,
                               Date submitdatetime) {

        this.id=id;
        District_Code = district_Code;
        Block_Town_Code = block_Town_Code;
        Gram_Ward_Code = gram_Ward_Code;
        this.rural = rural;
        Applicant_ID = applicant_ID;
        this.pregnentwomen_name = pregnentwomen_name;
        this.pregnentwomen_age = pregnentwomen_age;
        this.pregnentwomen_relation = pregnentwomen_relation;
        this.pregnentwomen_dob = pregnentwomen_dob;
        this.gender = gender;
        this.Is_tt = Is_tt;
        this.Is_tt1 = Is_tt1;
        this.tt1_date = tt1_date;
        this.Is_tt2 = Is_tt2;
        this.tt2_date = tt2_date;
        this.Is_iron_t = Is_iron_t;
        this.iron_t_date = iron_t_date;
        this.Is_four_checkup = Is_four_checkup;
        this.Is_I_checkup = Is_I_checkup;
        this.I_checkup_date = I_checkup_date;
        this.expected_date = expected_date;
        this.Is_II_checkup = Is_II_checkup;
        this.II_checkup_date = II_checkup_date;
        this.Is_III_checkup = Is_III_checkup;
        this.III_checkup_date = III_checkup_date;
        this.delivery_place = delivery_place;
        this.delivery_place_pri = delivery_place_pri;
        this.delivery_place_pri_per = delivery_place_pri_per;
        this.jb_card_no = jb_card_no;
        this.delivery_date = delivery_date;
        this.jsy = jsy;
        this.submitdatetime = submitdatetime;
    }


    public PregnentWomenObject(int id, String Applicant_ID,String pregnentwomen_name, String pregnentwomen_age, String gender, String category_name) {
        this.id = id;
        this.Applicant_ID= Applicant_ID;
        this.pregnentwomen_name = pregnentwomen_name;
        this.pregnentwomen_age = pregnentwomen_age;
        this.gender = gender;

    }

    public PregnentWomenObject() {

    }

    public static void getAll (final Context context, final Database.DataReceiver receiver,String id) {

        currentID=0;

        if (!Database.isConnected())
        {
            Database.connect(context);
        }
String query;
        query = "select Applicant_ID, District_Code,Block_Town_Code,Gram_Ward_Code,R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
                "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
                + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," +
                "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime from " + TABLE_NAME+" where Applicant_ID='"+id+"'";
Log.i(" getAll query",query);
        Database.execQueryWithDialog(
                context,
                receiver,
                new PregnentWomenObject(),
                "select Applicant_ID, District_Code,Block_Town_Code,Gram_Ward_Code,R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
                        "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
                        + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," +
                        "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime from " + TABLE_NAME+" where Applicant_ID='"+id+"'"

        );
    }

    public static void get_Women_Detail (final Context context, final Database.DataReceiver receiver,String id,String name) {

        currentID=0;

        System.out.println("id" + id);

        if (!Database.isConnected())
            Database.connect(context);
        String query ="select distinct Applicant_ID, District_Code,Block_Town_Code,Gram_Ward_Code,R_U," +"pregnentwomen_name," + "pregnentwomen_age," +
                "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," +"Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup," +
                "I_checkup_date," + "expected_date," +"Is_II_checkup," +"II_checkup_date," +"Is_III_checkup," +"III_checkup_date," +
                "delivery_place," +"delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime"+
                " from pregnent_women_details_rural where Applicant_ID = '"+id+"' and pregnentwomen_name='"+name+"'";


       String query1= "select distinct Applicant_ID, District_Code,Block_Town_Code,Gram_Ward_Code,R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
                "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
                + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," +
                "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime"+
                " from pregnent_women_details_rural where Applicant_ID = '"+id+"' and pregnentwomen_name='"+name+"'";
        Log.i("query is :",query1);
        Database.execQueryWithDialog(
                context,
                receiver,
                new PregnentWomenObject(),
                "select distinct Applicant_ID, District_Code,Block_Town_Code,Gram_Ward_Code,R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
                "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
                        + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," +
                        "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime"+
                         " from pregnent_women_details_rural where Applicant_ID = '"+id+"' and pregnentwomen_name='"+name+"'"
        );
    }


    public PregnentWomenObject convert (ResultSet resultSet) {

        PregnentWomenObject women = null;
        try {
            women = new PregnentWomenObject(
                    PregnentWomenObject.currentID++,
                    resultSet.getString("District_Code"),
                    resultSet.getString("Block_Town_Code"),
                    resultSet.getString("Gram_Ward_Code"),
                    resultSet.getString("R_U"),
                    resultSet.getString("Applicant_ID"),
                    resultSet.getString("pregnentwomen_name"),
                    resultSet.getString("pregnentwomen_age"),
                    resultSet.getString("pregnentwomen_relation"),
                    resultSet.getDate("pregnentwomen_dob"),
                    resultSet.getString("pregnentwomen_name"),
                    resultSet.getString("Is_tt"),
                    resultSet.getString("Is_tt1"),
                    resultSet.getDate("tt1_date"),
                    resultSet.getString("Is_tt2"),
                    resultSet.getDate("tt2_date"),
                    resultSet.getString("Is_iron_t"),
                    resultSet.getDate("iron_t_date"),
                    resultSet.getString("Is_four_checkup"),
                    resultSet.getString("Is_I_checkup"),
                    resultSet.getDate("I_checkup_date"),
                    resultSet.getString("expected_date"),
                    resultSet.getString("Is_II_checkup"),
                    resultSet.getDate("II_checkup_date"),
                    resultSet.getString("Is_III_checkup"),
                    resultSet.getDate("III_checkup_date"),
                     resultSet.getString("delivery_place"),
                     resultSet.getString("delivery_place_pri"),
                     resultSet.getString("delivery_place_pri_per"),
                    resultSet.getString("jb_card_no"),
                    resultSet.getDate("delivery_date"),
                    resultSet.getString("jsy"),
                    resultSet.getDate("submitdatetime")
            );


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return women;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getPrimaryKey() {
        return PRIMARY_KEY;
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

    public String getRural() {
        return rural;
    }

    public void setRural(String rural) {
        this.rural = rural;
    }

    public String getApplicant_ID() {
        return Applicant_ID;
    }

    public void setApplicant_ID(String applicant_ID) {
        Applicant_ID = applicant_ID;
    }

    public String getPregnentwomen_name() {
        return pregnentwomen_name;
    }

    public void setPregnentwomen_name(String pregnentwomen_name) {
        this.pregnentwomen_name = pregnentwomen_name;
    }

    public String getPregnentwomen_age() {
        return pregnentwomen_age;
    }

    public void setPregnentwomen_age(String pregnentwomen_age) {
        this.pregnentwomen_age = pregnentwomen_age;
    }

    public String getPregnentwomen_relation() {
        return pregnentwomen_relation;
    }

    public void setPregnentwomen_relation(String pregnentwomen_relation) {
        this.pregnentwomen_relation = pregnentwomen_relation;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_tt() {
        return Is_tt;
    }

    public void setIs_tt(String is_tt) {
        this.Is_tt = is_tt;
    }

    public String getIs_tt1() {
        return Is_tt1;
    }

    public void setIs_tt1(String is_tt1) {
        this.Is_tt1 = is_tt1;
    }

    public Date getTt1_date() {
        return tt1_date;
    }

    public void setTt1_date(Date tt1_date) {
        this.tt1_date = tt1_date;
    }

    public String getIs_tt2() {
        return Is_tt2;
    }

    public void setIs_tt2(String is_tt2) {
        this.Is_tt2 = is_tt2;
    }

    public Date getTt2_date() {
        return tt2_date;
    }

    public void setTt2_date(Date tt2_date) {
        this.tt2_date = tt2_date;
    }

    public String getIs_iron_t() {
        return Is_iron_t;
    }

    public void setIs_iron_t(String is_iron_t) {
        this.Is_iron_t = is_iron_t;
    }

    public Date getIron_t_date() {
        return iron_t_date;
    }

    public void setIron_t_date(Date iron_t_date) {
        this.iron_t_date = iron_t_date;
    }

    public String getIs_four_checkup() {
        return Is_four_checkup;
    }

    public void setIs_four_checkup(String is_four_checkup) {
        this.Is_four_checkup = is_four_checkup;
    }

    public String getis_I_checkup() {
        return Is_I_checkup;
    }

    public void setis_I_checkup(String is_I_checkup) {
        this.Is_I_checkup = is_I_checkup;
    }

    public Date getL_checkup_date() {
        return I_checkup_date;
    }

    public void setI_checkup_date(Date I_checkup_date) {
        this.I_checkup_date = I_checkup_date;
    }

    public String getExpected_date() {
        return expected_date;
    }

    public void setExpected_date(String expected_date) {
        this.expected_date = expected_date;
    }

    public String getIs_ll_checkup() {
        return Is_II_checkup;
    }

    public void setIs_ll_checkup(String is_ll_checkup) {
        this.Is_II_checkup = is_ll_checkup;
    }

    public Date getLI_checkup_date() {
        return II_checkup_date;
    }

    public void setLI_checkup_date(Date lI_checkup_date) {
        this.II_checkup_date = lI_checkup_date;
    }

    public String getIs_lll_checkup() {
        return Is_III_checkup;
    }

    public void setis_III_checkup(String is_III_checkup) {
        this.Is_III_checkup = is_III_checkup;
    }

    public Date getLlI_checkup_date() {
        return III_checkup_date;
    }

    public void setIII_checkup_date(Date III_checkup_date) {
        this.III_checkup_date = III_checkup_date;
    }


    public String getDelivery_place() {
        return delivery_place;
    }

    public void setDelivery_place(String delivery_place) {
        this.delivery_place = delivery_place;
    }

    public String getDelivery_place_pri() {
        return delivery_place_pri;
    }

    public void setDelivery_place_pri(String delivery_place_pri) {
        this.delivery_place_pri = delivery_place_pri;
    }

    public String getDelivery_place_pri_per() {
        return delivery_place_pri_per;
    }

    public void setDelivery_place_pri_per(String delivery_place_pri_per) {
        this.delivery_place_pri_per = delivery_place_pri_per;
    }

    public String getJb_card_no() {
        return jb_card_no;
    }

    public void setJb_card_no(String jb_card_no) {
        this.jb_card_no = jb_card_no;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getJsy() {
        return jsy;
    }

    public void setJsy(String jsy) {
        this.jsy = jsy;
    }







    public Date getSubmitdatetime() {
        return submitdatetime;
    }

    public void setSubmitdatetime(Date submitdatetime) {
        this.submitdatetime = submitdatetime;
    }

    public int getId() {


        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPregnentwomen_dob() {
        return pregnentwomen_dob;
    }

    public void setPregnentwomen_dob(Date pregnentwomen_dob) {
        this.pregnentwomen_dob = pregnentwomen_dob;
    }
}
