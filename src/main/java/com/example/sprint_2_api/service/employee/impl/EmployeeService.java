package com.example.sprint_2_api.service.employee.impl;

import com.example.sprint_2_api.model.employee.Employee;
import com.example.sprint_2_api.repository.employee.IEmployeeRepository;
import com.example.sprint_2_api.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public String getNextCode() {
        String code = employeeRepository.getLastCodeEmployee();
        if (code == null) {
            return "NV001";
        }
        int currentNumber = Integer.parseInt(code.substring(2));
        currentNumber++;
        return "NV" + String.format("%03d", currentNumber);
    }

    @Override
    public void addEmployee(Employee employee, Long userId) {

        employeeRepository.addEmployee(employee, userId);
    }

    @Override
    public Page<Employee> getListEmployee(Pageable pageable) {
        return employeeRepository.getListEmployee(pageable);
    }

    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String name) {
        return employeeRepository.searchEmployeeByNameAndRole(pageable, name);
    }

    @Override
    public Optional<Employee> findEmployee(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        try {
            employeeRepository.deleteEmployeeById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee, employee.getId());
    }

    @Override
    public Optional<Employee> getByPhoneNumber(String phoneNumber, Long id) {
        return employeeRepository.findEmployeeByPhoneNumber(phoneNumber, id);
    }

    @Override
    public Optional<Employee> getEmployeeByUserName(String username) {
        return employeeRepository.getEmployeeByUserName(username);
    }
}
