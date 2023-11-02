package com.example.sprint_2_api.service.project.impl;

import com.example.sprint_2_api.model.project.ProjectImage;
import com.example.sprint_2_api.repository.project.IProjectImageRepository;
import com.example.sprint_2_api.service.project.IProjectImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectImageService implements IProjectImageService {

    @Autowired
    private IProjectImageRepository projectImageRepository;

    @Override
    public List<ProjectImage> findAll() {
        return projectImageRepository.findAll();
    }

    @Override
    public Optional<ProjectImage> findById(Long id) {
        return projectImageRepository.findById(id);
    }

    @Override
    public void save(ProjectImage projectImage) {
        projectImageRepository.save(projectImage);
    }

    @Override
    public void remove(Long id) {
        projectImageRepository.deleteById(id);
    }
}
