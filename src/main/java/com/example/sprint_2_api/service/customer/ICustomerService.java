package com.example.sprint_2_api.service.customer;

import com.example.sprint_2_api.dto.customer.ICustomerDto;
import com.example.sprint_2_api.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    int updateOnlineCustomer(Customer customer);

    boolean existsByEmail(String email, Long id);

    boolean existsByPhoneNumber(String phoneNumber, Long id);

    Optional<Customer> saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Optional<Customer> findCustomerById(Long id);

    Optional<Customer> findCustomerByCode(String code);

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findCustomerByPhone(String phoneNumber);

    Optional<Customer> findCustomerByAppUser(Long appUserId);

    void saveCustomerForAppUser(Long id);

    Page<ICustomerDto> findAllCustomer(String name, String code, String address, String phoneNumber, String groupValue, Pageable pageable);

    boolean deleteCustomerById(Long id);
}
