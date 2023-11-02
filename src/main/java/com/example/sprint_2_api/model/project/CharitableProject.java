package com.example.sprint_2_api.model.project;

import com.example.sprint_2_api.model.company.Company;
import com.example.sprint_2_api.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CharitableProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date createDate;

    private Date endDate;

    private Integer count;
    private Long now;
    private Long target;

    @Column(columnDefinition = "LONGTEXT")
    private String story;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "project")
    @JsonBackReference
    private List<ProjectImage> imageProjectList;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @JsonBackReference
    @ManyToMany(mappedBy = "charitableProjects")
    private List<CharitableType> charitableTypes;
}
