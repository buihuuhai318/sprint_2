package com.example.sprint_2_api.dto.bill;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.model.bill.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BillDto {
    private Long id;

    private Long totalMoney;

    private Integer totalProject;

    private Date paymentDate;

    private Payment payment;

    private String paymentCode;

    private Integer statusPayment;

    private List<ICartDto> list;
}
