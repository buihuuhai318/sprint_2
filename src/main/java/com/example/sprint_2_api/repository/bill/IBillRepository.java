package com.example.sprint_2_api.repository.bill;

import com.example.sprint_2_api.model.bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Long> {
}
