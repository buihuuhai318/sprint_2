package com.example.sprint_2_api.repository.company;

import com.example.sprint_2_api.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
