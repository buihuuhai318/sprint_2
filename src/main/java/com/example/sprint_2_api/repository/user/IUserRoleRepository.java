package com.example.sprint_2_api.repository.user;

import com.example.sprint_2_api.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {

}
