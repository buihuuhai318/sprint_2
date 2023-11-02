package com.example.sprint_2_api.service.employee;

import com.example.sprint_2_api.model.employee.Employee;
import com.example.sprint_2_api.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService extends IGenerateService<Employee> {

    String getNextCode();

    void addEmployee(Employee employee, Long userId);

    Page<Employee> getListEmployee(Pageable pageable);

    Page<Employee> searchEmployee(Pageable pageable, String name);

    Optional<Employee> findEmployee(Long id);

    boolean deleteEmployee(Long id);

    Optional<Employee> getById(Long id);

    void updateEmployee(Employee employee);

    Optional<Employee> getByPhoneNumber(String phoneNumber,Long id);

    Optional<Employee> getEmployeeByUserName(String username);

}
