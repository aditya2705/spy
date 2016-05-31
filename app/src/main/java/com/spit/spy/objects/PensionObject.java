package com.spit.spy.objects;

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

public class PensionObject {

    public static final String TABLE_NAME = "childrenlessthan5_rural";
    public static final String PRIMARY_KEY = "id";

    private int id;
    String labharti_id;
    private String labharti_name, father_name, gender;
    private int age;
    private String category;
    private String applicant_name;
    private String rural;
    private String block_town_code;
    private String district_code;
    private Date birth_opv_date;

    ArrayList<Pensioner> getPensioners = new ArrayList<Pensioner>();

    public ArrayList<Pensioner> getPensionersDetails () {
        new RetrieveFromBackground().execute();
        return getPensioners;
    }

    public class RetrieveFromBackground extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {

                // SET CONNECTIONSTRING
                String dateOfBirth = "pregnentwomen_dob";
                String applicantName = "pregnentwomen_name";
                String applicantId = "Applicant_ID";
                String fatherName;
                String gender;
                String caste;
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                String database = "tabfromtemp20_new";
                String username = "d1810";
                String password = "12345";
                String server = "172.16.30.122";
                String connectionString = "jdbc:jtds:sqlserver://" + server + ":1433/" + database;
                Log.i("d1810", "Conn: " + connectionString);
//            Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + server + ":1433/tabfromtemp20_new;user=" + username + ";password=" + password);
                Connection DbConn = DriverManager.getConnection(connectionString, username, password);

                Log.w("Connection", "open");
                Statement stmt = DbConn.createStatement();
                String query = " select " + applicantId + "," + applicantName + "," + dateOfBirth + " from dbo.pregnent_women_details_rural ";
                ResultSet rs = stmt.executeQuery(query);
                int x=0;
                while (rs.next()) {
                    System.out.println(rs.getString(applicantName));
                    System.out.println(rs.getString(applicantId));
                    System.out.println(rs.getDate(dateOfBirth));

                    getPensioners.add(new Pensioner(x++, rs.getString(applicantId), rs.getString(applicantName),
                            "ABC", "FEMALE", rs.getDate(dateOfBirth), "OBC"));
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }
    }





//TODO: check parameters needed

   /* public InfantObject(int id, String labharti_id, String labharti_name,
                       String applicant_name, String rural,
                        String block_town_code, String district_code, Date DateOfBirth, Date birth_opv_date, Date birth_hepatitis_date,
                        Date birth_bcg_date, Date first_opv_date, Date first_hepatitis_date, Date first_dpt_date, Date second_opv_date,
                        Date second_hepatitis_date, Date second_dpt_date, Date third_opv_date, Date third_hepatitis_date,
                        Date third_dpt_date, Date nineTo12_khasra_date, Date booster_opv_date, Date booster_dpt_date,
                        Date booster_khasra_date) {
        this.id = id;
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

    public static List<InfantObject> getAll () {
        int currentId = 1;
        ArrayList<InfantObject> infants = new ArrayList();

        if (!Database.isConnected())
            Database.connect();

        ResultSet resultSet = Database.execQuery(
                "select id, labharti_id, labharti_name, applicant_name, rural,Block_town_code,District_Code,DateOfBirth,birth_opv_date,birth_hepatitis_date,birth_bcg_date,first_opv_date, first_hepatitis_date, first_dpt_date, second_opv_date,second_hepatitis_date, second_dpt_date,third_opv_date, third_hepatitis_date, third_dpt_date,nineTo12_khasra_date, booster_opv_date,booster_dpt_date,booster_khasra_date from " + TABLE_NAME
        );

        try {
            while (resultSet.next()) {
                InfantObject infant = new InfantObject(
                        currentId++,
                        makeLabarthiID(resultSet.getString("District_Code"),
                                resultSet.getInt("R_U"),
                                resultSet.getInt("Form_Sr")),
                        resultSet.getString("Applicant_Name"),
                        resultSet.getString("Applicant_Name"),
                        resultSet.getString("R_U"),
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
                infants.add(infant);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return infants;

    }

    public static void update (String id, InfantObject infant) {
        if (!Database.isConnected())
            Database.connect();

        Database.execQuery(
                "update " + TABLE_NAME + " set District_Code = " + infant.getDistrict_code() + "," +
                        " R_U = " + infant.getRural() + "," +
                        " Block_town_code = "  + infant.getBlock_town_code() + "," +
                        " DateOfBirth = "  + infant.getDateOfBirth() + "," +
                        " birth_opv_date = "  + infant.getBirth_opv_date() + "," +
                        " birth_hepatitis_date = "  + infant.getBirth_hepatitis_date() + "," +
                        " birth_bcg_date = " +  infant.getBirth_bcg_date() + "," +
                        "first_opv_date = "  + infant.getFirst_opv_date() + "," +
                        " first_hepatitis_date ="  + infant.getFirst_hepatitis_date() + "," +
                        " first_dpt_date = "  + infant.getFirst_dpt_date() + "," +
                        " second_opv_date = "  + infant.getSecond_opv_date() + "," +
                        " second_hepatitis_date = "  + infant.getSecond_hepatitis_date() + "," +
                        " second_dpt_date = "  + infant.getSecond_dpt_date() + "," +
                        " third_opv_date = "  + infant.getThird_opv_date() + "," +
                        " third_hepatitis_date ="  + infant.getThird_hepatitis_date() + "," +
                        " third_dpt_date = "  + infant.getThird_dpt_date() + "," +
                        " nineTo12_khasra_date = "  + infant.getNineTo12_khasra_date() + "," +
                        " booster_opv_date = "  + infant.getBooster_opv_date() + "," +
                        " booster_dpt_date ="  + infant.getBooster_dpt_date() + "," +
                        " booster_khasra_date ="  + infant.getBooster_khasra_date() + "," +
                        " Applicant_Name = " + infant.getApplicant_name() +
                        " where " + PRIMARY_KEY + " = " + id
        );
    }
*/}
