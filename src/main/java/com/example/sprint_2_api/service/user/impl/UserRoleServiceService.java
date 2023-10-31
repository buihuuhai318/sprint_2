package com.example.sprint_2_api.service.user.impl;

import com.example.sprint_2_api.model.user.UserRole;
import com.example.sprint_2_api.repository.user.IUserRoleRepository;
import com.example.sprint_2_api.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceService implements IUserRoleService {
@Autowired
private IUserRoleRepository userRoleRepository;
    @Override
    public void createUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
