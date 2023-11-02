package com.example.sprint_2_api.service.project.impl;

import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.repository.project.ICharitableProjectRepository;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharitableProjectService implements ICharitableProjectService {

    @Autowired
    private ICharitableProjectRepository charitableProjectRepository;

    @Override
    public List<CharitableProject> findAll() {
        return charitableProjectRepository.findAll();
    }

    @Override
    public Optional<CharitableProject> findById(Long id) {
        return charitableProjectRepository.findById(id);
    }

    @Override
    public void save(CharitableProject charitableProject) {
        charitableProjectRepository.save(charitableProject);
    }

    @Override
    public void remove(Long id) {
        charitableProjectRepository.deleteById(id);
    }
}
