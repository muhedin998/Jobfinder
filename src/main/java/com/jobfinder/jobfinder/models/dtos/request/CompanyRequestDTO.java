package com.jobfinder.jobfinder.models.dtos.request;


import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class CompanyRequestDTO {

    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Company name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @Size(max = 5000, message = "Description must be less than 5000 characters")
    private String description;
}