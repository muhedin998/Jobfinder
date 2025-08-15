package com.jobfinder.jobfinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.jobfinder.models.dtos.request.AuthenticationRequest;
import com.jobfinder.jobfinder.models.dtos.request.JobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.request.UserRegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@org.springframework.test.context.ActiveProfiles("test")
public class ErrorHandlingTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testJobNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/job/job/9999", String.class);
        
        assert response.getStatusCode() == HttpStatus.NOT_FOUND;
        assert response.getBody().contains("Job not found with id: 9999");
    }

    @Test
    public void testValidationErrorsOnRegistration() {
        UserRegisterDTO invalidUser = UserRegisterDTO.builder()
                .fullName("")
                .username("ab")
                .email("invalid-email")
                .password("123")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRegisterDTO> request = new HttpEntity<>(invalidUser, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/auth/register", request, String.class);
        
        assert response.getStatusCode() == HttpStatus.BAD_REQUEST;
        assert response.getBody().contains("Validation Failed");
    }

    @Test
    public void testValidationErrorsOnJobCreation() {
        JobRequestDTO invalidJob = new JobRequestDTO();
        invalidJob.setTitle("");
        invalidJob.setDescription("");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JobRequestDTO> request = new HttpEntity<>(invalidJob, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity("/job/create", request, String.class);
        
        assert response.getStatusCode() == HttpStatus.BAD_REQUEST;
        assert response.getBody().contains("Validation Failed");
    }

    @Test
    public void testInvalidAuthentication() {
        AuthenticationRequest invalidAuth = AuthenticationRequest.builder()
                .username("")
                .password("")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthenticationRequest> request = new HttpEntity<>(invalidAuth, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/auth/authenticate", request, String.class);
        
        assert response.getStatusCode() == HttpStatus.BAD_REQUEST;
        assert response.getBody().contains("Validation Failed");
    }
}