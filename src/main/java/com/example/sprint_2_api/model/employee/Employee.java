package com.example.sprint_2_api.model.employee;

import com.example.sprint_2_api.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String codeEmployee;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String nameEmployee;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String address;

    @Column(columnDefinition = "longtext")
    private String image;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "date", nullable = false)
    private String startDay;

    @Column(columnDefinition = "date", nullable = false)
    private String birthday;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String idCard;

    @Column(columnDefinition = "longtext")
    private String note;

    @Column(columnDefinition = "bit(1)")
    private Boolean flagDelete = false;

    @OneToOne
    @JoinColumn(name = "app_user_id", nullable = false, unique = true)
    private AppUser appUser;
}
