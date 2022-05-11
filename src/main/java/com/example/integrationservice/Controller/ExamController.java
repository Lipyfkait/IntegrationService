package com.example.integrationservice.Controller;

import com.example.integrationservice.Entity.ExamUser;
import com.example.integrationservice.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExamController {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ExamRepository repository;

    @RequestMapping("/lol")
    public String getGoogle() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://google.com", String.class, " ");
        return responseEntity.getBody();
    }

    @GetMapping("/users")
    public List<ExamUser> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<ExamUser> getUserById(@PathVariable("id") Long id){
        return repository.findById(id);
    }
}
