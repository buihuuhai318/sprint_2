package com.example.sprint_2_api.service.project.impl;

import com.example.sprint_2_api.model.project.CharitableType;
import com.example.sprint_2_api.repository.project.ICharitableTypeRepository;
import com.example.sprint_2_api.service.project.ICharitableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharitableTypeService implements ICharitableTypeService {

    @Autowired
    private ICharitableTypeRepository charitableTypeRepository;

    @Override
    public List<CharitableType> findAll() {
        return charitableTypeRepository.findAll();
    }

    @Override
    public Optional<CharitableType> findById(Long id) {
        return charitableTypeRepository.findById(id);
    }

    @Override
    public void save(CharitableType charitableType) {
        charitableTypeRepository.save(charitableType);
    }

    @Override
    public void remove(Long id) {
        charitableTypeRepository.deleteById(id);
    }

    @Override
    public Optional<List<CharitableType>> allList(Long id) {
        return charitableTypeRepository.allList(id);
    }
}
