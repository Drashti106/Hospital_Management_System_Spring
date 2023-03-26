package com.example.Hospital_Management_System;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse) {
        //validation
        if (nurse.getNurseID() < 0)
            return "Invalid NurseID";
        if (nurse.getNurseName() == null)
            return "Nurse name should not be null";

        //process - saving to database
        return nurseRepository.addNurse(nurse);
    }

    public List<Nurse> getNurseGreaterThanAge(int age) {
        //calling all the nurses from database
        List<Nurse> nurseList = nurseRepository.allNurse();
        //Now I will write logic to extract information
        List<Nurse> finalList = new ArrayList<>();
        for (Nurse nurse : nurseList) {
            if (nurse.getAge() > age)
                finalList.add(nurse);
        }
        return finalList;
    }
    public List<Nurse> getNurseByQualification(String qualification){
        //get data
        List<Nurse> nurseList = nurseRepository.allNurse(); //reusabilitygit
        List<Nurse> finalList = new ArrayList<>();
        for(Nurse nurse : nurseList){
            if(nurse.getQualification().equals(qualification))
                finalList.add(nurse);
        }
        return finalList;
    }
}
