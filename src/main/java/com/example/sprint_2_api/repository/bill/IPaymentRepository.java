package com.example.sprint_2_api.repository.bill;

import com.example.sprint_2_api.model.bill.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
