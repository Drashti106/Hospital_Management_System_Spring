package com.example.Hospital_Management_System;

public class Patient {
    private int PatientID;
    private String name;
    private String disease;
    private int age;

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(int patientID, String name, String disease, int age) {
        PatientID = patientID;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }
}
