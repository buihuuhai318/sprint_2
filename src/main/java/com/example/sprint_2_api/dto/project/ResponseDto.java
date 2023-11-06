package com.example.sprint_2_api.dto.project;

import com.example.sprint_2_api.model.project.ProjectImage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDto {
    List<ProjectImage> list;

    List<String> stringList;

    Long day;
}
