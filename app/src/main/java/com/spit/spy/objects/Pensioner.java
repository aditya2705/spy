package com.spit.spy.objects;

import java.util.Date;

/**
 * Created by Ayush and Neelesh on 5/30/2016.
 */
public class Pensioner {

    private int id;
    private String labhartiId;
    private String applicantName;
    private String fatherName;
    private String gender;
    private Date dateOfBirth;
    private String caste;

    public Pensioner(int id,String labhartiId, String applicantName, String fatherName, String gender, Date dateOfBirth, String caste) {
        this.labhartiId = labhartiId;
        this.applicantName = applicantName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.caste = caste;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabhartiId() {
        return labhartiId;
    }

    public void setLabhartiId(String labhartiId) {
        this.labhartiId = labhartiId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }
}
