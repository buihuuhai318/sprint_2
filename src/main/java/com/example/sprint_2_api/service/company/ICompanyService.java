package com.example.sprint_2_api.service.company;

import com.example.sprint_2_api.model.company.Company;
import com.example.sprint_2_api.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICompanyService extends IGenerateService<Company> {

    Page<Company> findAll(Pageable pageable);

    Optional<List<Company>> allList(Long id);
}
