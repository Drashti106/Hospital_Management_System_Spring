package com.example.Hospital_Management_System;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    NurseService nurseService = new NurseService();

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){
        return nurseService.addNurse(nurse);
    }

    @GetMapping("/getByAge/{age}")
    public List<Nurse> getNurseGreaterThanAge(@PathVariable("age")Integer age){
        return nurseService.getNurseGreaterThanAge(age);
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNurseByQualification(@RequestParam("qualification")String qualification){
        return getNurseByQualification(qualification);
    }
}
