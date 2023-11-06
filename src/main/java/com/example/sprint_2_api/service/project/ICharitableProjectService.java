package com.example.sprint_2_api.service.project;

import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICharitableProjectService extends IGenerateService<CharitableProject> {

    Page<CharitableProject> findAll(Pageable pageable);

    Page<ProjectDto> findAllByCard(Pageable pageable);

    Page<ProjectDto> findAllByCardWithType(Pageable pageable, Long id);

    Page<ProjectDto> findAllByCardWithSearch(Pageable pageable, String value);
}
