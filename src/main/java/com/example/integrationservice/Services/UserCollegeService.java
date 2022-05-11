package com.example.integrationservice.Services;

import com.example.integrationservice.Entity.College;
import com.example.integrationservice.Entity.UserCollege;
import com.example.integrationservice.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserCollegeService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    CollegeRepository collegeRepository;

    public List<String> getAllUsers() {
        List<String> allUsers = null;
        List<College> listCollege= collegeRepository.findAll();
        for (College college: listCollege){
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(college.getLink() + "/users", String.class, " ");
            allUsers.add(responseEntity.getBody());
        }
        return allUsers;
    }
}
