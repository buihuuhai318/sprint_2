package com.example.sprint_2_api.model.customer;

import com.example.sprint_2_api.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20)", unique = true)
    private String code;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "birth_day", columnDefinition = "date")
    private String birthDay;

    @Column(columnDefinition = "varchar(255)")
    private String address;

    @Column(name = "phone_number", columnDefinition = "varchar(20)", unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "varchar(100)", unique = true)
    private String email;

    private Long point;

    @Column(columnDefinition = "text")
    private String note;

    @Column(columnDefinition = "bit(1)")
    private Boolean flagDelete = false;

    @OneToOne
    @JoinColumn(name = "app_user_id", nullable = false, unique = true)
    private AppUser appUser;
}
