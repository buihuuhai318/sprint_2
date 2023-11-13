package com.example.sprint_2_api.controller.employee;

import com.example.sprint_2_api.config.JwtTokenUtil;
import com.example.sprint_2_api.model.employee.Employee;
import com.example.sprint_2_api.model.user.AppUser;
import com.example.sprint_2_api.service.employee.IEmployeeService;
import com.example.sprint_2_api.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IAppUserService appUserService;

    public AppUser getUserNameFormJWT(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        jwtToken = requestTokenHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return appUserService.findByUsername(username);
    }

    @GetMapping("/infoEmployee")
    public ResponseEntity<?> getInfo(HttpServletRequest request) {
        AppUser appUser = getUserNameFormJWT(request);
        Employee employee = employeeService.getEmployeeByAndAppUser_Id(appUser.getId()).orElse(null);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/editEmployee")
    public ResponseEntity<?> edit(HttpServletRequest request, @RequestBody Employee employee) {
        AppUser appUser = getUserNameFormJWT(request);
        Employee empTemp = employeeService.getEmployeeByAndAppUser_Id(appUser.getId()).orElse(null);
        if (empTemp != null && empTemp.getAppUser().getUserName().equals(appUser.getUserName())) {
            employeeService.save(employee);
            return new ResponseEntity<>(empTemp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
