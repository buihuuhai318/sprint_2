package com.example.sprint_2_api.controller.home;

import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.dto.project.ResponseDto;
import com.example.sprint_2_api.model.company.Company;
import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.model.project.CharitableType;
import com.example.sprint_2_api.service.cart.ICartService;
import com.example.sprint_2_api.service.company.ICompanyService;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import com.example.sprint_2_api.service.project.ICharitableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private ICharitableProjectService charitableProjectService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICharitableTypeService charitableTypeService;

    @Autowired
    private ICartService cartService;

    @GetMapping("/types")
    public ResponseEntity<List<CharitableType>> listTypes() {
        List<CharitableType> types = charitableTypeService.findAll();
        if (types.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<Page<ProjectDto>> listProjects() {
        Pageable pageable = PageRequest.of(0, 6);
        Page<ProjectDto> charitableProjects = charitableProjectService.findAllByCard(pageable);
        if (charitableProjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(charitableProjects, HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<ResponseDto> getProject(@PathVariable Long id) {
        CharitableProject charitableProject = charitableProjectService.findById(id).orElse(null);
        ResponseDto responseDto = new ResponseDto();

        assert charitableProject != null;

        Date date1 = charitableProject.getCreateDate();
        Date date2 = charitableProject.getEndDate();

        long timeDiff = date2.getTime() - date1.getTime();
        Long days = timeDiff / (24 * 60 * 60 * 1000);

        int temp = 0;
        List<String> story = new ArrayList<>();
        for (int i = 0; i < charitableProject.getStory().length(); i++) {
            if (charitableProject.getStory().charAt(i) == '*') {
                story.add(charitableProject.getStory().substring(temp, i));
                temp = i + 1;
            }
        }
        story.add(charitableProject.getStory().substring(temp, charitableProject.getStory().length() - 1));

        responseDto.setDay(days);
        responseDto.setList(charitableProject.getImageProjectList());
        responseDto.setStringList(story);
        responseDto.setMost(cartService.findCustomerMost(id));
        responseDto.setLast(cartService.findCustomerLast(id));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity<Page<Company>> listCompanies() {
        Pageable pageable = PageRequest.of(0, 6);
        Page<Company> companies = companyService.findAll(pageable);
        if (companies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/companies-all")
    public ResponseEntity<Page<Company>> listCompaniesAll() {
        Pageable pageable = PageRequest.of(0, 100);
        Page<Company> companies = companyService.findAll(pageable);
        if (companies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/projects/getOther")
    public ResponseEntity<Page<ProjectDto>> getOther(@RequestParam(name = "limit") int limit) {
        if (limit == 1) {
            Pageable pageable = PageRequest.of(0, 1);
            Page<ProjectDto> charitableProjects = charitableProjectService.findAllByCardOther(pageable, 1);
            return new ResponseEntity<>(charitableProjects, HttpStatus.OK);
        } else {
            Pageable pageable = PageRequest.of(0, 3);
            Page<ProjectDto> charitableProjects = charitableProjectService.findAllByCardOther(pageable, 3);
            return new ResponseEntity<>(charitableProjects, HttpStatus.OK);
        }
    }
}
