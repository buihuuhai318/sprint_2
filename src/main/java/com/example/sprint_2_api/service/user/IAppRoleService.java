package com.example.sprint_2_api.service.user;

import com.example.sprint_2_api.model.user.AppRole;
import com.example.sprint_2_api.service.IGenerateService;

import java.util.List;

public interface IAppRoleService extends IGenerateService<AppRole> {
    List<AppRole> findAllAppRole();
}
