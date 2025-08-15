package com.jobfinder.jobfinder.models.enums;

public enum JobType {
    FULL_TIME("Full Time"),
    PART_TIME("Part Time"),
    CONTRACT("Contract"),
    INTERNSHIP("Internship"),
    TEMPORARY("Temporary"),
    FREELANCE("Freelance");
    
    private final String displayName;
    
    JobType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}