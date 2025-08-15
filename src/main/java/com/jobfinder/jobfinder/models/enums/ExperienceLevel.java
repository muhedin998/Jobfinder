package com.jobfinder.jobfinder.models.enums;

public enum ExperienceLevel {
    ENTRY_LEVEL("Entry Level", "0-2 years"),
    MID_LEVEL("Mid Level", "3-5 years"),
    SENIOR_LEVEL("Senior Level", "6-10 years"),
    EXECUTIVE_LEVEL("Executive Level", "10+ years"),
    INTERN("Intern", "Student/Graduate"),
    NO_EXPERIENCE("No Experience Required", "0 years");
    
    private final String displayName;
    private final String description;
    
    ExperienceLevel(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getDescription() {
        return description;
    }
}