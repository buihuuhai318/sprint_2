package com.example.sprint_2_api.controller.home;

import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableType;
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

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/charitable")
public class ListController {

    @Autowired
    private ICharitableProjectService charitableProjectService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICharitableTypeService charitableTypeService;


    @GetMapping("/type/{id}")
    public ResponseEntity<Page<ProjectDto>> getListByType(@PathVariable Long id, @RequestParam(name = "limit") int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        Page<ProjectDto> charitableProjects = charitableProjectService.findAllByCardWithType(pageable, id);
        if (charitableProjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(charitableProjects, HttpStatus.OK);
    }

    @GetMapping("/types/{id}")
    public ResponseEntity<List<CharitableType>> getTypes(@PathVariable Long id) {
        List<CharitableType> list = charitableTypeService.allList(id).orElse(null);
        assert list != null;
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProjectDto>> getListBySearch(@RequestParam(name = "value") String value, @RequestParam(name = "limit") int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        Page<ProjectDto> charitableProjects = charitableProjectService.findAllByCardWithSearch(pageable, value);
        if (charitableProjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(charitableProjects, HttpStatus.OK);
    }
}
