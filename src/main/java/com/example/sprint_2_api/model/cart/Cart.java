package com.example.sprint_2_api.model.cart;

import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.model.bill.Bill;
import com.example.sprint_2_api.model.user.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "charitable_project_id", referencedColumnName = "id")
    private CharitableProject charitableProject;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    private Bill bill;

    private Long money;

    private Date createDate;

    private int payStatus;
}
