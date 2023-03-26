package com.example.Hospital_Management_System;

public class Nurse {
    private int nurseID;
    private int age;
    private String nurseName;
    private String qualification;

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Nurse(int nurseID, int age, String nurseName, String qualification) {
        this.nurseID = nurseID;
        this.age = age;
        this.nurseName = nurseName;
        this.qualification = qualification;
    }
}
