package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.model.project.CharitableProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharitableProjectRepository extends JpaRepository<CharitableProject, Long> {
}
