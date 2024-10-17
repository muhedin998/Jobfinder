package com.jobfinder.jobfinder.models.dtos.request;


import lombok.Data;

@Data
public class CompanyRequestDTO {

    private String name;

    private String location;

    private String description;
}