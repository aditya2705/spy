package com.spit.spy.objects;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.spit.spy.Database;
import com.spit.spy.infant.activities.PensionersListInfantActivity;
import net.sourceforge.jtds.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 - * Created by Aditya Rathi on 10-Apr-16.
 + * Created by  on 10-Apr-16.
 */

public class InfantObject implements ResultSetConvertible<InfantObject> {

    public static final String TABLE_NAME = "childrenlessthan5_rural";
    public static final String PRIMARY_KEY = "id";
    private static int currentID = 0;

    private int id;
    String labharti_id;
    private String labharti_name, father_name;
    private int age;
    private String category;
    private String applicant_name;
    private String rural;
    private String block_town_code;
    private String district_code;
    private String child_name;
    private String gender;
    private Date birth_opv_date;
    private Date birth_hepatitis_date;
    private Date first_hepatitis_date;
    private Date first_dpt_date;
    private Date second_opv_date;
    private Date second_hepatitis_date;
    private Date second_dpt_date;
    private Date third_opv_date;
    private Date third_hepatitis_date;
    private Date third_dpt_date;
    private Date nineTo12_khasra_date;
    private Date booster_opv_date;
    private Date booster_dpt_date;
    private Date booster_khasra_date;
    private Date first_opv_date;
    private Date birth_bcg_date;

//       ArrayList<Infant> getInfants = new ArrayList<Infant>();
//
//       public ArrayList<Infant> getInfantsDetails () {
//           new RetrieveFromBackground().execute();
//           return getInfants;
//       }
//
//       public class RetrieveFromBackground extends AsyncTask<Void, Void, Void> {
//
//           @Override
//           protected Void doInBackground(Void... params) {
//               try {
//
//                   // SET CONNECTIONSTRING
//                   String dateOfBirth = "DateOfBirth";
//                   String applicantName = "Applicant_Name";
//                   String applicantId = "Applicant_ID";
//                   String fatherName;
//                   String gender;
//                   String caste;
//                   Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
//                   String database = "tabfromtemp20_new";
//                   String username = "d1810";
//                   String password = "12345";
//                   String server = "172.16.30.122";
//                   String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/" + database;
//                   Log.i("d1810", "Conn: " + connectionString);
////            Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/tabfromtemp20_new;user=" + username + ";password=" + password);
//                   Connection DbConn = DriverManager.getConnection(connectionString, username, password);
//
//                   Log.w("Connection", "open");
//                   Statement stmt = DbConn.createStatement();
//                   String query = " select " + applicantId + "," + applicantName + "," + dateOfBirth + " from dbo.childrenlessthan5_rural ";
//                   ResultSet rs = stmt.executeQuery(query);
//                    int x=0;
//                   while (rs.next()) {
//                       System.out.println(rs.getString(applicantName));
//                       System.out.println(rs.getString(applicantId));
//                       System.out.println(rs.getDate(dateOfBirth));
//                       getInfants.add(new Infant(x++, rs.getString(applicantId), rs.getString(applicantName),
//                               "ABC", "MALE", rs.getDate(dateOfBirth), "GEN"));
//                   }
//
//               } catch (Exception e) {
//
//                   e.printStackTrace();
//               }
//
//               return null;
//           }
//       }
//
//
//
//
//
////TODO: check parameters needed

    public InfantObject(int id, String labharti_id, String labharti_name, String category,
                        String applicant_name, String rural, String child_name, int age, String gender,
                        String block_town_code, String district_code, Date DateOfBirth, Date birth_opv_date, Date birth_hepatitis_date,
                        Date birth_bcg_date, Date first_opv_date, Date first_hepatitis_date, Date first_dpt_date, Date second_opv_date,
                        Date second_hepatitis_date, Date second_dpt_date, Date third_opv_date, Date third_hepatitis_date,
                        Date third_dpt_date, Date nineTo12_khasra_date, Date booster_opv_date, Date booster_dpt_date,
                        Date booster_khasra_date) {
        this.category = category;
        this.child_name = child_name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.father_name = applicant_name;
        this.labharti_id = labharti_id;
        this.labharti_name = labharti_name;
        this.applicant_name = applicant_name;
        this.rural = rural;
        this.block_town_code = block_town_code;
        this.district_code = district_code;
        this.DateOfBirth = DateOfBirth;
        this.birth_opv_date = birth_opv_date;
        this.birth_hepatitis_date = birth_hepatitis_date;
        this.birth_bcg_date = birth_bcg_date;
        this.first_opv_date = first_opv_date;
        this.first_hepatitis_date = first_hepatitis_date;
        this.first_dpt_date = first_dpt_date;
        this.second_opv_date = second_opv_date;
        this.second_hepatitis_date = second_hepatitis_date;
        this.second_dpt_date = second_dpt_date;
        this.third_opv_date = third_opv_date;
        this.third_hepatitis_date = third_hepatitis_date;
        this.third_dpt_date= third_dpt_date;
        this.nineTo12_khasra_date = nineTo12_khasra_date;
        this.booster_opv_date = booster_opv_date;
        this.booster_dpt_date = booster_dpt_date;
        this.booster_khasra_date = booster_khasra_date;

    }

    public InfantObject(int id, String labharti_id, String labharti_name, String father_name, String gender, int age, String category) {
        this.id = id;
        this.labharti_id = labharti_id;
        this.labharti_name = labharti_name;
        this.father_name = father_name;
        this.gender = gender;
        this.age = age;
        this.category = category;
    }

    public InfantObject() {

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


    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    private Date DateOfBirth;

    public Date getBirth_opv_date() {
        return birth_opv_date;
    }

    public void setBirth_opv_date(Date birth_opv_date) {
        this.birth_opv_date = birth_opv_date;
    }

    public Date getBirth_hepatitis_date() {
        return birth_hepatitis_date;
    }

    public void setBirth_hepatitis_date(Date birth_hepatitis_date) {
        this.birth_hepatitis_date = birth_hepatitis_date;
    }

    public Date getBirth_bcg_date() {
        return birth_bcg_date;
    }

    public void setBirth_bcg_date(Date birth_bcg_date) {
        this.birth_bcg_date = birth_bcg_date;
    }

    public Date getFirst_opv_date() {
        return first_opv_date;
    }

    public void setFirst_opv_date(Date first_opv_date) {
        this.first_opv_date = first_opv_date;
    }

    public Date getFirst_hepatitis_date() {
        return first_hepatitis_date;
    }

    public void setFirst_hepatitis_date(Date first_hepatitis_date) {
        this.first_hepatitis_date = first_hepatitis_date;
    }

    public Date getFirst_dpt_date() {
        return first_dpt_date;
    }

    public void setFirst_dpt_date(Date first_dpt_date) {
        this.first_dpt_date = first_dpt_date;
    }

    public Date getSecond_opv_date() {
        return second_opv_date;
    }

    public void setSecond_opv_date(Date second_opv_date) {
        this.second_opv_date = second_opv_date;
    }

    public Date getSecond_hepatitis_date() {
        return second_hepatitis_date;
    }

    public void setSecond_hepatitis_date(Date second_hepatitis_date) {
        this.second_hepatitis_date = second_hepatitis_date;
    }

    public Date getSecond_dpt_date() {
        return second_dpt_date;
    }

    public void setSecond_dpt_date(Date second_dpt_date) {
        this.second_dpt_date = second_dpt_date;
    }

    public Date getThird_opv_date() {
        return third_opv_date;
    }

    public void setThird_opv_date(Date third_opv_date) {
        this.third_opv_date = third_opv_date;
    }

    public Date getThird_hepatitis_date() {
        return third_hepatitis_date;
    }

    public void setThird_hepatitis_date(Date third_hepatitis_date) {
        this.third_hepatitis_date = third_hepatitis_date;
    }

    public Date getThird_dpt_date() {
        return third_dpt_date;
    }

    public void setThird_dpt_date(Date third_dpt_date) {
        this.third_dpt_date = third_dpt_date;
    }

    public Date getNineTo12_khasra_date() {
        return nineTo12_khasra_date;
    }

    public void setNineTo12_khasra_date(Date nineTo12_khasra_date) {
        this.nineTo12_khasra_date = nineTo12_khasra_date;
    }

    public Date getBooster_opv_date() {
        return booster_opv_date;
    }

    public void setBooster_opv_date(Date booster_opv_date) {
        this.booster_opv_date = booster_opv_date;
    }

    public Date getBooster_dpt_date() {
        return booster_dpt_date;
    }

    public void setBooster_dpt_date(Date booster_dpt_date) {
        this.booster_dpt_date = booster_dpt_date;
    }

    public Date getBooster_khasra_date() {
        return booster_khasra_date;
    }

    public void setBooster_khasra_date(Date booster_khasra_date) {
        this.booster_khasra_date = booster_khasra_date;
    }

    public String getChild_name() { return child_name; }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
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

    public static void storeDates(final Context context,final Database.DataReceiver receiver,String date1,String date2,String date3,String child_name )
    {
        currentID=0;


        if (!Database.isConnected())
            Database.connect(context);
        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                "update "+ TABLE_NAME+ "set birth_opv_date='"+date1+"',birth_hepatitis_date='"+date2+"',birth_bcg_date='"+date3+"' where " + TABLE_NAME +
                        ".child5_name='"+child_name+"'"
        );



    }


    public static void getAll (final Context context, final Database.DataReceiver receiver) {
        currentID=0;


        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                "select distinct " + TABLE_NAME + ".Applicant_ID, " + TABLE_NAME + ".Applicant_Name, " + TABLE_NAME + ".R_U, child5_name, " + TABLE_NAME + ".Block_Town_Code, " + TABLE_NAME + ".District_Code, " +
                        "DateOfBirth, birth_opv_date,birth_hepatitis_date,birth_bcg_date,first_opv_date, category_name, first_hepatitis_date, first_dpt_date, second_opv_date,second_hepatitis_date, " +
                        "second_dpt_date,third_opv_date, third_hepatitis_date, member_age, member_gen, " +
                        "third_dpt_date,nineTo12_khasra_date, booster_opv_date,booster_dpt_date,booster_khasra_date " +
                        "from " + TABLE_NAME + ", member_detail_m_3132005_27052016, samajwadi_paid_lucknow " +
                        "where " + TABLE_NAME + ".Applicant_ID = member_detail_m_3132005_27052016.Applicant_ID and " + TABLE_NAME + ".child5_name = member_detail_m_3132005_27052016.member_name " +
                        "and samajwadi_paid_lucknow.ID_FORIDCARD = " + TABLE_NAME + ".Applicant_ID"
        );



    }

    public static void get_infantDetail (final Context context, final Database.DataReceiver receiver,String id,String name) {

        currentID=0;
        String query=  "select distinct District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,Ischild5,child5_name,Ishealth_card,health_crd_no"+
                ",health_card_type,child5_auto_no,DateOfBirth,birth_opv,birth_opv_date,birth_hepatitis,birth_hepatitis_date,birth_bcg,"+
                "birth_bcg_date,first_opv,first_opv_date,first_hepatitis,first_hepatitis_date,first_dpt,first_dpt_date,second_opv,second_opv_date,"+
                "second_hepatitis,second_hepatitis_date,second_dpt,second_dpt_date,third_opv,third_opv_date,third_hepatitis,third_hepatitis_date,"+
                "third_dpt,third_dpt_date,nineTo12_khasra,nineTo12_khasra_date,booster_opv,booster_opv_date,booster_dpt,booster_dpt_date,"+
                "booster_khasra,booster_khasra_date " +
                "from " + TABLE_NAME + " where Applicant_ID ='"+id+"' and Applicant_Name='"+name+"'";
        Log.i("infant query",query);
        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                "select distinct District_Code,Block_Town_Code,Gram_Ward_Code,R_U,Applicant_Name,Applicant_ID,Ischild5,child5_name,Ishealth_card,health_crd_no"+
                        ",health_card_type,child5_auto_no,DateOfBirth,birth_opv,birth_opv_date,birth_hepatitis,birth_hepatitis_date,birth_bcg,"+
                "birth_bcg_date,first_opv,first_opv_date,first_hepatitis,first_hepatitis_date,first_dpt,first_dpt_date,second_opv,second_opv_date,"+
                        "second_hepatitis,second_hepatitis_date,second_dpt,second_dpt_date,third_opv,third_opv_date,third_hepatitis,third_hepatitis_date,"+
                        "third_dpt,third_dpt_date,nineTo12_khasra,nineTo12_khasra_date,booster_opv,booster_opv_date,booster_dpt,booster_dpt_date,"+
                        "booster_khasra,booster_khasra_date " +
                "from " + TABLE_NAME + " where Applicant_ID ='"+id+"' and Applicant_Name='"+name+"'"
        );



    }



    public static void getLabharti_Child (final Context context, final Database.DataReceiver receiver,String id) {

        currentID=0;
        System.out.println("iddd  " + id);

        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                "select distinct " + TABLE_NAME + ".Applicant_ID, " + TABLE_NAME + ".Applicant_Name, " + TABLE_NAME + ".R_U, child5_name, " + TABLE_NAME + ".Block_Town_Code, " + TABLE_NAME + ".District_Code, " +
                        "DateOfBirth, birth_opv_date,birth_hepatitis_date,birth_bcg_date,first_opv_date, category_name, first_hepatitis_date, first_dpt_date, second_opv_date,second_hepatitis_date, " +
                        "second_dpt_date,third_opv_date, third_hepatitis_date, member_age, member_gen, " +
                        "third_dpt_date,nineTo12_khasra_date, booster_opv_date,booster_dpt_date,booster_khasra_date " +
                        "from " + TABLE_NAME + ", member_detail_m_3132005_27052016, samajwadi_paid_lucknow " +
                        "where " + TABLE_NAME + ".Applicant_ID = member_detail_m_3132005_27052016.Applicant_ID and " + TABLE_NAME + ".child5_name = member_detail_m_3132005_27052016.member_name " +
                        "and samajwadi_paid_lucknow.ID_FORIDCARD = " + TABLE_NAME + ".Applicant_ID and "+TABLE_NAME+".Applicant_ID='"+id+"'"

        );

    }
    public static void getChild_Info (final Context context, final Database.DataReceiver receiver,String child_name) {
        currentID=0;
        if (!Database.isConnected())
            Database.connect(context);
        String query="select distinct " + TABLE_NAME + ".Applicant_ID, " + TABLE_NAME + ".Applicant_Name, " + TABLE_NAME + ".R_U, child5_name, " + TABLE_NAME + ".Block_Town_Code, " + TABLE_NAME + ".District_Code, " +
                "DateOfBirth, birth_opv_date,birth_hepatitis_date,birth_bcg_date,first_opv_date, category_name, first_hepatitis_date, first_dpt_date, second_opv_date,second_hepatitis_date, " +
                "second_dpt_date,third_opv_date, third_hepatitis_date, member_age, member_gen, " +
                "third_dpt_date,nineTo12_khasra_date, booster_opv_date,booster_dpt_date,booster_khasra_date " +
                "from " + TABLE_NAME + ", member_detail_m_3132005_27052016, samajwadi_paid_lucknow " +
                "where " + TABLE_NAME + ".Applicant_ID = member_detail_m_3132005_27052016.Applicant_ID and " + TABLE_NAME + ".child5_name = member_detail_m_3132005_27052016.member_name " +
                "and samajwadi_paid_lucknow.ID_FORIDCARD = " + TABLE_NAME + ".Applicant_ID and "+TABLE_NAME+".child5_name='"+child_name+"'";
        Log.i("Query is",query);
        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                query

        );

    }


    public static void update (Context context, Database.DataReceiver receiver, String id, InfantObject infant) {
        if (!Database.isConnected())
            Database.connect(context);

        Database.execQueryWithDialog(
                context,
                receiver,
                new InfantObject(),
                "update " + TABLE_NAME + " set District_Code = " + infant.getDistrict_code() + "," +
                        " R_U = " + infant.getRural() + "," +
                        " Block_town_code = " + infant.getBlock_town_code() + "," +
                        " DateOfBirth = " + infant.getDateOfBirth() + "," +
                        " birth_opv_date = " + infant.getBirth_opv_date() + "," +
                        " birth_hepatitis_date = " + infant.getBirth_hepatitis_date() + "," +
                        " birth_bcg_date = " + infant.getBirth_bcg_date() + "," +
                        " first_opv_date = " + infant.getFirst_opv_date() + "," +
                        " first_hepatitis_date =" + infant.getFirst_hepatitis_date() + "," +
                        " first_dpt_date = " + infant.getFirst_dpt_date() + "," +
                        " second_opv_date = " + infant.getSecond_opv_date() + "," +
                        " second_hepatitis_date = " + infant.getSecond_hepatitis_date() + "," +
                        " second_dpt_date = " + infant.getSecond_dpt_date() + "," +
                        " third_opv_date = " + infant.getThird_opv_date() + "," +
                        " third_hepatitis_date =" + infant.getThird_hepatitis_date() + "," +
                        " third_dpt_date = " + infant.getThird_dpt_date() + "," +
                        " nineTo12_khasra_date = " + infant.getNineTo12_khasra_date() + "," +
                        " booster_opv_date = " + infant.getBooster_opv_date() + "," +
                        " booster_dpt_date =" + infant.getBooster_dpt_date() + "," +
                        " booster_khasra_date =" + infant.getBooster_khasra_date() + "," +
                        " Applicant_Name = " + infant.getApplicant_name() +
                        " where " + PRIMARY_KEY + " = " + id
        );
    }

    public InfantObject convert (ResultSet resultSet) {
        InfantObject infant = null;
        try {
            infant = new InfantObject(
                    InfantObject.currentID++,
                    resultSet.getString("Applicant_ID"),
                    resultSet.getString("Applicant_Name"),
                    resultSet.getString("category_name"),
                    resultSet.getString("Applicant_Name"),
                    resultSet.getString("R_U"),
                    resultSet.getString("child5_name"),
                    resultSet.getInt("member_age"),
                    resultSet.getString("member_gen"),
                    resultSet.getString("Block_Town_Code"),
                    resultSet.getString("District_Code"),
                    resultSet.getDate("DateOfBirth"),
                    resultSet.getDate("birth_opv_date"),
                    resultSet.getDate("birth_hepatitis_date"),
                    resultSet.getDate("birth_bcg_date"),
                    resultSet.getDate("first_opv_date"),
                    resultSet.getDate("first_hepatitis_date"),
                    resultSet.getDate("first_dpt_date"),
                    resultSet.getDate("second_opv_date"),
                    resultSet.getDate("second_hepatitis_date"),
                    resultSet.getDate("second_dpt_date"),
                    resultSet.getDate("third_opv_date"),
                    resultSet.getDate("third_hepatitis_date"),
                    resultSet.getDate("third_dpt_date"),
                    resultSet.getDate("nineTo12_khasra_date"),
                    resultSet.getDate("booster_opv_date"),
                    resultSet.getDate("booster_dpt_date"),
                    resultSet.getDate("booster_khasra_date")
            );

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return infant;
    }
}
