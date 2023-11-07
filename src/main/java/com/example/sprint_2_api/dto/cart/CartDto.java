package com.example.sprint_2_api.dto.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CartDto {

    private Long projectId;

    private Long money;
}
