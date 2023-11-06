package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.model.project.CharitableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICharitableTypeRepository extends JpaRepository<CharitableType, Long> {

    @Query(value = "select * from charitable_type order by id = :id desc", nativeQuery = true)
    Optional<List<CharitableType>> allList(Long id);
}
