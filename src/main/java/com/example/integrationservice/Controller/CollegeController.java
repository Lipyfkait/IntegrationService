package com.example.integrationservice.Controller;

import com.example.integrationservice.Entity.College;
import com.example.integrationservice.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeRepository collegeRepository;

    @GetMapping("/all")
    public List<College> getAllColleges () {return collegeRepository.findAll();}

    @GetMapping("/id/{id}")
    public Optional<College> getCollege(@PathVariable("id") Long id) {return collegeRepository.findById(id);}
}
