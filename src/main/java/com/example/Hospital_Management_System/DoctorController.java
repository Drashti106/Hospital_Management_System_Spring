package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    HashMap<Integer,Doctor> doctorDB = new HashMap<>();

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        doctorDB.put(doctor.getDoctorID(),doctor);
        return "Doctor added successfully";
    }
    @GetMapping("/get/{doctorID}")
    public Doctor getDoctor(@PathVariable("doctorID")Integer doctorID){
        return doctorDB.get(doctorID);
    }
    @PutMapping("/update/{doctorID}/{degree}")
    public String updateDoctor(@PathVariable("doctorID")Integer doctorID,@PathVariable("degree") String degree){
        if(doctorDB.containsKey(doctorID)){
            Doctor d = doctorDB.get(doctorID);
            d.setDegree(degree);
            doctorDB.put(doctorID,d);
            return "Doctor details updated successfully";
        }
        return "Doctor does not exist";
    }
    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("doctorID") Integer doctorID){
        if(doctorDB.containsKey(doctorID)){
            doctorDB.remove(doctorID);
            return "Doctor details deleted successfully";
        }
        return "Doctor does not exist";
    }
}
