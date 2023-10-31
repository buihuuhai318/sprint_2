package com.example.sprint_2_api.service.user;

import com.example.sprint_2_api.model.user.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAllAppRole();
    AppRole findById(Long id);
}
