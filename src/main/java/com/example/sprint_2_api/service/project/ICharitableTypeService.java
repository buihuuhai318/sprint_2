package com.example.sprint_2_api.service.project;

import com.example.sprint_2_api.model.project.CharitableType;
import com.example.sprint_2_api.service.IGenerateService;

import java.util.List;
import java.util.Optional;

public interface ICharitableTypeService extends IGenerateService<CharitableType> {

    Optional<List<CharitableType>> allList(Long id);
}
