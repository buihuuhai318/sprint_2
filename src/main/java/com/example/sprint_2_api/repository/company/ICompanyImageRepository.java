package com.example.sprint_2_api.repository.company;

import com.example.sprint_2_api.model.company.CompanyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyImageRepository extends JpaRepository<CompanyImage, Long> {
}
