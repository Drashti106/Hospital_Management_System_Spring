package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    //database for patients
    HashMap<Integer,Patient> patientDB = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam ("patientID") Integer patientID,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @RequestParam("disease") String disease){
        Patient p = new Patient(patientID,name,disease,age);
        patientDB.put(patientID,p);
        return "Patient added successfully via Request Parameter";
    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){
        patientDB.put(patient.getPatientID(),patient);
        return "Patient added successfully via Request body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientID") Integer patientID){
        return patientDB.get(patientID);
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatient(){
        List<Patient> patientsList = new ArrayList<>();
        for(Patient patient : patientDB.values())
            patientsList.add(patient);

        return patientsList;
    }
    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name){
        for(Patient patient : patientDB.values()){
            if(patient.getName().equals(name))
                return patient;
        }
        return null;
    }
    @GetMapping("/getPatientGTage")
    public List<Patient> getPatientGTage(@RequestParam("age")Integer age){
        List<Patient> listOfPatient = new ArrayList<>();
        for(Patient patient : patientDB.values()){
            if(patient.getAge()>=age)
                listOfPatient.add(patient);
        }
        return listOfPatient;
    }

    @GetMapping("/getInfoViaPathVariable/{patientID}")
    public Patient getPatientInfo(@PathVariable("patientID")Integer patientID){
        return patientDB.get(patientID);
    }

    @GetMapping("/getPatient/{age}/{disease}")
    public List getPatientInfo(@PathVariable("age")Integer age, @PathVariable("disease") String disease){
        List<Patient> patientList = new ArrayList<>();

        for(Patient patient : patientDB.values()){
            if(patient.getAge()>age && patient.getDisease().equals(disease))
                patientList.add(patient);
        }
        return patientList;
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient){
        if(patientDB.containsKey(patient.getPatientID())) {
            patientDB.put(patient.getPatientID(), patient);
            return "The patient details are updated successfully";
        }
        return  "Patient detail is not existing";
    }
    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientID") Integer patientID,@RequestParam("disease") String disease){
        if(patientDB.containsKey(patientID)){
            Patient p = patientDB.get(patientID);
            p.setDisease(disease);
            patientDB.put(patientID,p);
            return "Updated successfully";
        }
        return "Patient does not exists";
    }
    @DeleteMapping("/deletPatient")
    public String deletePatient(@RequestParam("patientID")Integer patientID){
        if(patientDB.containsKey(patientID)){
            patientDB.remove(patientID);
            return "Deleted Successfulllyy";
        }
        return "Patient does not exist";
    }
    @DeleteMapping("/deletPatient/{patientID}")
    public String deletePatient1(@PathVariable("patientID")Integer patientID){
        if(patientDB.containsKey(patientID)){
            patientDB.remove(patientID);
            return "Deleted Successfulllyy";
        }
        return "Patient does not exist";
    }


}








