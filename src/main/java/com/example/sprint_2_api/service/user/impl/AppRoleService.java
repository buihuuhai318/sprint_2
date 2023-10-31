package com.example.sprint_2_api.service.user.impl;

import com.example.sprint_2_api.model.user.AppRole;
import com.example.sprint_2_api.repository.user.IAppRoleRepository;
import com.example.sprint_2_api.service.user.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAllAppRole() {
        return appRoleRepository.getAllRole();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id);
    }
}
