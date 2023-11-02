package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.model.project.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectImageRepository extends JpaRepository<ProjectImage, Long> {
}
