package com.example.sprint_2_api.service.company.impl;

import com.example.sprint_2_api.model.company.CompanyImage;
import com.example.sprint_2_api.repository.company.ICompanyImageRepository;
import com.example.sprint_2_api.service.company.ICompanyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImageService implements ICompanyImageService {

    @Autowired
    private ICompanyImageRepository companyImageRepository;

    @Override
    public List<CompanyImage> findAll() {
        return companyImageRepository.findAll();
    }

    @Override
    public Optional<CompanyImage> findById(Long id) {
        return companyImageRepository.findById(id);
    }

    @Override
    public void save(CompanyImage companyImage) {
        companyImageRepository.save(companyImage);
    }

    @Override
    public void remove(Long id) {
        companyImageRepository.deleteById(id);
    }
}
