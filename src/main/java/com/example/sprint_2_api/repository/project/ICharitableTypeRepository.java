package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.model.project.CharitableType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharitableTypeRepository extends JpaRepository<CharitableType, Long> {
}
