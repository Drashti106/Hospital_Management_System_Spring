package com.example.Hospital_Management_System;

public class Doctor {
    private String name;
    private int age;
    private String degree;
    private String specialization;
    private int doctorID;

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(int doctorID,String name, int age, String degree, String specialization) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.specialization = specialization;
        this.doctorID = doctorID;
    }
}
