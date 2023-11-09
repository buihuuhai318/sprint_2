package com.example.sprint_2_api.service.project.impl;

import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.repository.project.ICharitableProjectRepository;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<CharitableProject> findAll(Pageable pageable) {
        return charitableProjectRepository.findAll(pageable);
    }

    @Override
    public Page<ProjectDto> findAllByCard(Pageable pageable) {
        return charitableProjectRepository.findAllByCard(pageable);
    }

    @Override
    public Page<ProjectDto> findAllByCardWithType(Pageable pageable, Long id) {
        return charitableProjectRepository.findAllByCardWithType(pageable, id);
    }

    @Override
    public Page<ProjectDto> findAllByCardWithSearch(Pageable pageable, String value) {
        return charitableProjectRepository.findAllByCardWithSearch(pageable, "%" + value + "%");
    }

    @Override
    public Page<ProjectDto> findAllByCardOther(Pageable pageable, int limit) {
        if (limit == 1) {
            return charitableProjectRepository.findAllByCardOther1(pageable);
        } else {
            return charitableProjectRepository.findAllByCardOther3(pageable);
        }
    }
}
