package com.example.sprint_2_api.controller.project;

import com.example.sprint_2_api.service.company.ICompanyService;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home/projects")
public class ProjectController {

    @Autowired
    private ICharitableProjectService charitableProjectService;

    @Autowired
    private ICompanyService companyService;
}
