package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

@Data
public class CompanyResponseDTO {

    private Long id;

    private String name;

    private String location;

    private String description;
}