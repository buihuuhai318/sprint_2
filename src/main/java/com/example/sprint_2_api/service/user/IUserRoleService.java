package com.example.sprint_2_api.service.user;

import com.example.sprint_2_api.model.user.UserRole;
import com.example.sprint_2_api.service.IGenerateService;

public interface IUserRoleService extends IGenerateService<UserRole> {
    void createUserRole(UserRole userRole);
}
