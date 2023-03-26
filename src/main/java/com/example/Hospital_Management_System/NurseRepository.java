package com.example.Hospital_Management_System;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {

    HashMap <Integer,Nurse> nurseDB = new HashMap<>();
    public String  addNurse(Nurse nurse){
        nurseDB.put(nurse.getNurseID(),nurse);
        return "Nurse added successfully";
    }
    public List<Nurse> allNurse(){
//        List<Nurse> nurseList = new ArrayList<>();
//        for(Nurse nurse : nurseDB.values()){
//            nurseList.add(nurse);
//        }
//        return nurseList;
        return nurseDB.values().stream().toList();
    }
}
