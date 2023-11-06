package com.example.sprint_2_api.model.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CharitableType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String image;

    private String description;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "project_type",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<CharitableProject> charitableProjects;
}
