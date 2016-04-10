package com.spit.spy.objects;

/**
 * Created by Aditya Rathi on 10-Apr-16.
 */
public class PensionerObject {

    private int id;
    String labharti_id;
    private String labharti_name, father_name, gender;
    private int age;
    private String category;

    public PensionerObject(int id, String labharti_id, String labharti_name, String father_name, String gender, int age, String category) {
        this.id = id;
        this.labharti_id = labharti_id;
        this.labharti_name = labharti_name;
        this.father_name = father_name;
        this.gender = gender;
        this.age = age;
        this.category = category;
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
}
