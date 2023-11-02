package com.example.sprint_2_api.controller.user;
import com.example.sprint_2_api.model.user.AppRole;
import com.example.sprint_2_api.service.user.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/admin/appRole")
public class AppRoleController {

    @Autowired
    private IAppRoleService appRoleService;

    @GetMapping("/list")
    public ResponseEntity<List<AppRole>> findAllAppRole(){

        List<AppRole> appRoleList = appRoleService.findAllAppRole();
        if (appRoleList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appRoleList,HttpStatus.OK);
    }
}
