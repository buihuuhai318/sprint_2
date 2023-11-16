package com.example.sprint_2_api.dto.project;


public interface ProjectDto {
    Long getId();

    String getTitle();

    String getProjectImage();

    String getCompany();

    String getCompanyImage();

    Integer getCount();

    Long getNow();

    Integer getTargetLimit();

    Integer getDate();

    Integer getStatus();
}
