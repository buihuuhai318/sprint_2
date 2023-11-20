package com.example.sprint_2_api.repository.company;

import com.example.sprint_2_api.model.company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company, Long> {

    @Override
    Page<Company> findAll(Pageable pageable);

    @Query(value = "select * from company order by id = :id desc", nativeQuery = true)
    Optional<List<Company>> allList(Long id);
}
