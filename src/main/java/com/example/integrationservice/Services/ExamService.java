package com.example.integrationservice.Services;

import com.example.integrationservice.Entity.College;
import com.example.integrationservice.Entity.Statistics;
import com.example.integrationservice.Entity.UserCollege;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ExamService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    UserCollege userCollege;
    ObjectMapper objectMapper;

    public void Syncing (College college) throws JsonProcessingException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(college.getLink() + "/users", String.class, " ");
        UserCollege[] data = objectMapper.readValue(responseEntity.getBody(), UserCollege[].class);
        for (UserCollege user: data) {
            if (user.getExam_token() == null) {
                RegistrationUser(user);
            } else {
                MarksUser(user);
            }
        }
    }

    public String RegistrationUser(UserCollege user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("first_name", user.getFirst_name());
        map.add("last_name", user.getLast_name());
        map.add("role", user.getRole());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity( "URL", request , String.class );


        return response.getBody();
    }

    public Statistics MarksUser(UserCollege user) {
        ResponseEntity<Statistics> responseEntity = restTemplate.getForEntity("URL" + "/" + user.getExam_token(), Statistics.class, " ");
        return responseEntity.getBody();
    }
}
