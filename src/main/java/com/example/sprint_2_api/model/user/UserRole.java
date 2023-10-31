package com.example.sprint_2_api.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "app_role_id", referencedColumnName = "id")
    private AppRole appRole;

    public UserRole() {
    }

    public UserRole(AppUser appUser, AppRole appRole) {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public UserRole(Long id, AppUser appUser, AppRole appRole) {
        this.id = id;
        this.appUser = appUser;
        this.appRole = appRole;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}