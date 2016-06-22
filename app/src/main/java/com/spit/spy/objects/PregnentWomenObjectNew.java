package com.spit.spy.objects;

/**
 * Created by admin on 6/21/2016.
 */


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
public class PregnentWomenObjectNew implements ResultSetConvertible {

    public static final String TABLE_NAME = "samajwadi_paid_lucknow";
    public static final String TABLE_NAME1="pregnent_women_details_rural";

    private static int currentID = 0;
    private int id;
    String ID_FORIDCARD;
    String Applicant_Name;
    String Age;
    String Gender;
    String category_name;
    String pregnentwomen_name;
    String pregnentwomen_age;
    String pregnentwomen_relation;
    String pregnentwomen_dob;
    String Is_tt;
    String Is_tt1;
    Date tt1_date;
    String Is_tt2;
    Date tt2_date;
    String Is_iron_t;
    Date iron_t_date;
    String Is_four_checkup;
    String Is_I_checkup;
    Date I_checkup_date;

    public String getExpected_date() {
        return expected_date;
    }

    public void setExpected_date(String expected_date) {
        this.expected_date = expected_date;
    }

    String expected_date;
    String Is_II_checkup;
    Date II_checkup_date;
    String Is_III_checkup;
    Date III_checkup_date;
    String Is_IIII_checkup;
    Date IIII_checkup_date;
    String delivery_place;
    String delivery_place_pri;
    String delivery_place_pri_per;
    String jb_card_no;
    Date delivery_date;
    String jsy;

    public PregnentWomenObjectNew(int id, String ID_FORIDCARD, String applicant_Name, String age, String gender,
                               String category_name, String pregnentwomen_name, String pregnentwomen_age, String pregnentwomen_relation,
                               String pregnentwomen_dob, String is_tt, String is_tt1, Date tt1_date, String is_tt2, Date tt2_date,
                               String is_iron_t, Date iron_t_date, String is_four_checkup, String is_I_checkup, Date i_checkup_date,
                               String expected_date, String is_II_checkup, Date II_checkup_date, String is_III_checkup,
                               Date III_checkup_date, String is_IIII_checkup, Date IIII_checkup_date, String delivery_place,
                               String delivery_place_pri, String delivery_place_pri_per, String jb_card_no, Date delivery_date,
                               String jsy) {
        this.id = id;
        this.ID_FORIDCARD = ID_FORIDCARD;
        Applicant_Name = applicant_Name;
        Age = age;
        Gender = gender;
        this.category_name = category_name;
        this.pregnentwomen_name = pregnentwomen_name;
        this.pregnentwomen_age = pregnentwomen_age;
        this.pregnentwomen_relation = pregnentwomen_relation;
        this.pregnentwomen_dob = pregnentwomen_dob;
        Is_tt = is_tt;
        Is_tt1 = is_tt1;
        this.tt1_date = tt1_date;
        Is_tt2 = is_tt2;
        this.tt2_date = tt2_date;
        Is_iron_t = is_iron_t;
        this.iron_t_date = iron_t_date;
        Is_four_checkup = is_four_checkup;
        Is_I_checkup = is_I_checkup;
        I_checkup_date = i_checkup_date;
        this.expected_date = expected_date;
        Is_II_checkup = is_II_checkup;
        this.II_checkup_date = II_checkup_date;
        Is_III_checkup = is_III_checkup;
        this.III_checkup_date = III_checkup_date;
        Is_IIII_checkup = is_IIII_checkup;
        this.IIII_checkup_date = IIII_checkup_date;
        this.delivery_place = delivery_place;
        this.delivery_place_pri = delivery_place_pri;
        this.delivery_place_pri_per = delivery_place_pri_per;
        this.jb_card_no = jb_card_no;
        this.delivery_date = delivery_date;
        this.jsy = jsy;
    }
    public PregnentWomenObjectNew(int id, String ID_FORIDCARD, String applicant_Name, String age, String gender,String category_name) {
        this.id = id;
        this.ID_FORIDCARD = ID_FORIDCARD;
        Applicant_Name = applicant_Name;
        Age = age;
        Gender = gender;
        this.category_name = category_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getpregnentwomen_name() {
        return pregnentwomen_name;
    }

    public void setpregnentwomen_name(String pregnentwomen_name) {
        this.pregnentwomen_name = pregnentwomen_name;
    }

    public String getpregnentwomen_age() {
        return pregnentwomen_age;
    }

    public void setpregnentwomen_age(String pregnentwomen_age) {
        this.pregnentwomen_age = pregnentwomen_age;
    }

    public String getpregnentwomen_relation() {
        return pregnentwomen_relation;
    }

    public void setpregnentwomen_relation(String pregnentwomen_relation) {
        this.pregnentwomen_relation = pregnentwomen_relation;
    }

    public String getpregnentwomen_dob() {
        return pregnentwomen_dob;
    }

    public void setpregnentwomen_dob(String pregnentwomen_dob) {
        this.pregnentwomen_dob = pregnentwomen_dob;
    }

    public String getIs_tt() {
        return Is_tt;
    }

    public void setIs_tt(String is_tt) {
        Is_tt = is_tt;
    }

    public String getIs_tt1() {
        return Is_tt1;
    }

    public void setIs_tt1(String is_tt1) {
        Is_tt1 = is_tt1;
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
        Is_tt2 = is_tt2;
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
        Is_iron_t = is_iron_t;
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
        Is_four_checkup = is_four_checkup;
    }

    public String getIs_I_checkup() {
        return Is_I_checkup;
    }

    public void setIs_I_checkup(String is_I_checkup) {
        Is_I_checkup = is_I_checkup;
    }

    public Date getI_checkup_date() {
        return I_checkup_date;
    }

    public void setI_checkup_date(Date i_checkup_date) {
        I_checkup_date = i_checkup_date;
    }





    public String getIs_II_checkup() {
        return Is_II_checkup;
    }

    public void setIs_II_checkup(String is_II_checkup) {
        Is_II_checkup = is_II_checkup;
    }

    public Date getII_checkup_date() {
        return II_checkup_date;
    }

    public void setII_checkup_date(Date II_checkup_date) {
        this.II_checkup_date = II_checkup_date;
    }

    public String getIs_III_checkup() {
        return Is_III_checkup;
    }

    public void setIs_III_checkup(String is_III_checkup) {
        Is_III_checkup = is_III_checkup;
    }

    public Date getIII_checkup_date() {
        return III_checkup_date;
    }

    public void setIII_checkup_date(Date III_checkup_date) {
        this.III_checkup_date = III_checkup_date;
    }

    public String getIs_IIII_checkup() {
        return Is_IIII_checkup;
    }

    public void setIs_IIII_checkup(String is_IIII_checkup) {
        Is_IIII_checkup = is_IIII_checkup;
    }

    public Date getIIII_checkup_date() {
        return IIII_checkup_date;
    }

    public void setIIII_checkup_date(Date IIII_checkup_date) {
        this.IIII_checkup_date = IIII_checkup_date;
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





    public PregnentWomenObjectNew() {

    }

    public static void getAllWomen(final Context context, final Database.DataReceiver receiver,String id) {
        currentID = 0;


        if (!Database.isConnected())
        {
            Database.connect(context);
        }
String query= "select "+TABLE_NAME+".ID_FORIDCARD,"+TABLE_NAME+".Applicant_Name,"+TABLE_NAME+".Age,"+TABLE_NAME+".Gender," +
        TABLE_NAME+".category_name,pregnentwomen_name,pregnentwomen_age, pregnentwomen_relation,pregnentwomen_dob, Is_tt, Is_tt1," +
        "tt1_date, Is_tt2,tt2_date,Is_iron_t,iron_t_date, Is_four_checkup,Is_I_checkup,I_checkup_date, expected_date," +
        "Is_II_checkup, II_checkup_date, Is_III_checkup,III_checkup_date, Is_IIII_checkup, IIII_checkup_date, " +
        "delivery_place,delivery_place_pri,delivery_place_pri_per, jb_card_no,delivery_date,jsy from "+
        TABLE_NAME+","+TABLE_NAME1+" where "+TABLE_NAME1+".Applicant_ID ='"+id+"' and "+TABLE_NAME+".ID_FORIDCARD='"+id+"'";
        Log.i("query is",query);


        Database.execQueryWithDialog(
                context,
                receiver,
                new PregnentWomenObjectNew(),
                "select "+TABLE_NAME+".ID_FORIDCARD,"+TABLE_NAME+".Applicant_Name,"+TABLE_NAME+".Age,"+TABLE_NAME+".Gender," +
                        TABLE_NAME+".category_name,pregnentwomen_name,pregnentwomen_age, pregnentwomen_relation,pregnentwomen_dob, Is_tt, Is_tt1," +
                        "tt1_date, Is_tt2,tt2_date,Is_iron_t,iron_t_date, Is_four_checkup,Is_I_checkup,I_checkup_date, expected_date," +
                        "Is_II_checkup, II_checkup_date, Is_III_checkup,III_checkup_date, Is_IIII_checkup, IIII_checkup_date, " +
                        "delivery_place,delivery_place_pri,delivery_place_pri_per, jb_card_no,delivery_date,jsy from "+
                        TABLE_NAME+","+TABLE_NAME1+" where "+TABLE_NAME1+".Applicant_ID ='"+id+"' and "+TABLE_NAME+".ID_FORIDCARD='"+id+"'"



        );
    }

    public static void getWomen_Info(final Context context, final Database.DataReceiver receiver, String id, String name) {
        currentID = 0;


        if (!Database.isConnected())
        {
            Database.connect(context);
        }

String query="select "+TABLE_NAME+".ID_FORIDCARD,"+TABLE_NAME+".Applicant_Name,"+TABLE_NAME+".Age,"+TABLE_NAME+".Gender," +
        TABLE_NAME+".category_name,pregnentwomen_name,pregnentwomen_age, pregnentwomen_relation,pregnentwomen_dob, Is_tt, Is_tt1," +
        "tt1_date, Is_tt2,tt2_date,Is_iron_t,iron_t_date, Is_four_checkup,Is_I_checkup,I_checkup_date, expected_date," +
        "Is_II_checkup, II_checkup_date, Is_III_checkup,III_checkup_date, Is_IIII_checkup, IIII_checkup_date, " +
        "delivery_place,delivery_place_pri,delivery_place_pri_per, jb_card_no,delivery_date,jsy from "+
        TABLE_NAME+","+TABLE_NAME1+" where "+TABLE_NAME1+".Applicant_ID ='"+id+"' and "+TABLE_NAME+".ID_FORIDCARD='"+id+"' and "+
        TABLE_NAME1+".pregnentwomen_name = '"+name+"'";
        Log.i("query is",query);
        Database.execQueryWithDialog(
                context,
                receiver,
                new PregnentWomenObjectNew(),
                "select "+TABLE_NAME+".ID_FORIDCARD,"+TABLE_NAME+".Applicant_Name,"+TABLE_NAME+".Age,"+TABLE_NAME+".Gender," +
                        TABLE_NAME+".category_name,pregnentwomen_name,pregnentwomen_age, pregnentwomen_relation,pregnentwomen_dob, Is_tt, Is_tt1," +
                        "tt1_date, Is_tt2,tt2_date,Is_iron_t,iron_t_date, Is_four_checkup,Is_I_checkup,I_checkup_date, expected_date," +
                        "Is_II_checkup, II_checkup_date, Is_III_checkup,III_checkup_date, Is_IIII_checkup, IIII_checkup_date, " +
                        "delivery_place,delivery_place_pri,delivery_place_pri_per, jb_card_no,delivery_date,jsy from "+
                        TABLE_NAME+","+TABLE_NAME1+" where "+TABLE_NAME1+".Applicant_ID ='"+id+"' and "+TABLE_NAME+".ID_FORIDCARD='"+id+"' and "+
                        TABLE_NAME1+".pregnentwomen_name = '"+name+"'"



        );
    }



//    public static void getAll (final Context context, final Database.DataReceiver receiver) {
//        int currentId = 1;
//
//
//        if (!Database.isConnected())
//        {
//            Database.connect(context);
//        }
//
//
//        Database.execQueryWithDialog(
//                context,
//                receiver,
//                new PregnentWomenObjectNew(),
//                        "select distinct " + TABLE_NAME + ".Applicant_ID, " + TABLE_NAME + ".District_Code," + TABLE_NAME +".Block_Town_Code," + TABLE_NAME +".Gram_Ward_Code," + TABLE_NAME+".R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
//                        "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
//                        + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," + "is_IIII_checkup," + "IIII_checkup_date," +
//                        "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime from " + TABLE_NAME
//
//        );
//    }
//
//    public static void getDetails (final Context context, final Database.DataReceiver receiver,String sel) {
//        int currentId = 1;
//
//
//        if (!Database.isConnected())
//        {
//            Database.connect(context);
//        }
//
//
//        Database.execQueryWithDialog(
//                context,
//                receiver,
//                new PregnentWomenObjectNew(),
//                        "select " + TABLE_NAME + ".Applicant_ID, " + TABLE_NAME + ".District_Code," + TABLE_NAME +".Block_Town_Code," + TABLE_NAME +".Gram_Ward_Code," + TABLE_NAME+".R_U," + "pregnentwomen_name," + "pregnentwomen_age," +
//                        "pregnentwomen_relation," + "pregnentwomen_dob," + "Is_tt," + "Is_tt1," + "tt1_date," + "Is_tt2," + "tt2_date," + "Is_iron_t," + "iron_t_date," + "Is_four_checkup," + "is_I_checkup,"
//                        + "I_checkup_date," + "expected_date," + "Is_II_checkup," + "II_checkup_date," + "Is_III_checkup," + "III_checkup_date," + "is_IIII_checkup," + "IIII_checkup_date," +
//                        "delivery_place," + "delivery_place_pri," + "delivery_place_pri_per," + "jb_card_no," + "delivery_date," + "jsy," + "submitdatetime from " + TABLE_NAME+" where pregnentwomen_name= '"+sel+"'"
//
//        );
//    }

//    public PregnentWomenObjectNew convert (ResultSet resultSet) {
//        PregnentWomenObjectNew women = null;
//        try {
//            women = new PregnentWomenObjectNew(
//                    PregnentWomenObjectNew.currentID++,
//                    resultSet.getString("District_Code"),
//                    resultSet.getString("Block_Town_Code"),
//                    resultSet.getString("Gram_Ward_Code"),
//                    resultSet.getString("R_U"),
//                    resultSet.getString("Applicant_ID"),
//                    resultSet.getString("pregnentwomen_name"),
//                    resultSet.getString("pregnentwomen_age"),
//                    resultSet.getString("pregnentwomen_relation"),
//                    resultSet.getDate("pregnentwomen_dob"),
//                    resultSet.getString("pregnentwomen_name"),
//                    resultSet.getString("Is_tt"),
//                    resultSet.getString("Is_tt1"),
//                    resultSet.getDate("tt1_date"),
//                    resultSet.getString("Is_tt2"),
//                    resultSet.getDate("tt2_date"),
//                    resultSet.getString("Is_iron_t"),
//                    resultSet.getDate("iron_t_date"),
//                    resultSet.getString("Is_four_checkup"),
//                    resultSet.getString("Is_I_checkup"),
//                    resultSet.getDate("I_checkup_date"),
//                    resultSet.getString("expected_date"),
//                    resultSet.getString("Is_II_checkup"),
//                    resultSet.getDate("II_checkup_date"),
//                    resultSet.getString("Is_III_checkup"),
//                    resultSet.getDate("III_checkup_date"),
//                    resultSet.getString("Is_IIII_checkup"),
//                    resultSet.getDate("IIII_checkup_date"),
//                    resultSet.getString("delivery_place"),
//                     resultSet.getString("delivery_place_pri"),
//                     resultSet.getString("delivery_place_pri_per"),
//                    resultSet.getString("jb_card_no"),
//                    resultSet.getDate("delivery_date"),
//                    resultSet.getString("jsy"),
//                    resultSet.getDate("submitdatetime")
//            );
//
//
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//
//        return women;
//    }

    public PregnentWomenObjectNew convert (ResultSet resultSet) {
        PregnentWomenObjectNew women = null;
        try {
            women = new PregnentWomenObjectNew(
                    PregnentWomenObjectNew.currentID++,
                    resultSet.getString("ID_FORIDCARD"),
                    resultSet.getString("Applicant_Name"),
                    resultSet.getString("Age"),
                    resultSet.getString("Gender"),
                    resultSet.getString("category_name"),
                    resultSet.getString("pregnentwomen_name"),
                    resultSet.getString("pregnentwomen_age"),
                    resultSet.getString("pregnentwomen_relation"),
                    resultSet.getString("pregnentwomen_dob"),
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
                    resultSet.getString("Is_IIII_checkup"),
                    resultSet.getDate("IIII_checkup_date"),
                    resultSet.getString("delivery_place"),
                    resultSet.getString("delivery_place_pri"),
                    resultSet.getString("delivery_place_pri_per"),
                    resultSet.getString("jb_card_no"),
                    resultSet.getDate("delivery_date"),
                    resultSet.getString("jsy")
            );


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


        return women;
    }



}
