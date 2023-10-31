package com.example.sprint_2_api.service.customer.impl;

import com.example.sprint_2_api.dto.customer.FormatCustomer;
import com.example.sprint_2_api.dto.customer.ICustomerDto;
import com.example.sprint_2_api.model.customer.Customer;
import com.example.sprint_2_api.repository.customer.ICustomerRepository;
import com.example.sprint_2_api.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public int updateOnlineCustomer(Customer customer) {
        return customerRepository.updateOnlineCustomer(customer);
    }

    @Override
    public boolean existsByEmail(String email, Long id) {
        return customerRepository.existsByEmailAndIdNotAndFlagDeleteIsFalse(email, id);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber, Long id) {
        return customerRepository.existsByPhoneNumberAndIdNotAndFlagDeleteIsFalse(phoneNumber, id);
    }

    @Override
    public Optional<Customer> saveCustomer(Customer customer) {
        customer.setFlagDelete(false);
        customer.setPoint(0l);
        customerRepository.saveCustomer(customer.getCode(), customer.getName(), customer.getBirthDay(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getPoint(), customer.getNote(), customer.getFlagDelete());
        return customerRepository.findCustomerByPhoneNumber(customer.getPhoneNumber());
    }

    @Override
    public void saveCustomerForAppUser(Long id) {
        Customer customer = new Customer();
        String code = FormatCustomer.generateCustomerCode();
        customer.setCode(code);
        customer.setFlagDelete(false);
        customer.setPoint(0l);
        customerRepository.saveCustomerHasAppUser(customer.getCode(), customer.getName(), customer.getBirthDay(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getPoint(), customer.getNote(), customer.getFlagDelete(), id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getName(), customer.getBirthDay(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getNote(), customer.getId());
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Optional<Customer> findCustomerByCode(String code) {
        return customerRepository.findCustomerByCode(code);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Optional<Customer> findCustomerByPhone(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Customer> findCustomerByAppUser(Long appUserId) {
        return customerRepository.findCustomerByAppUser(appUserId);
    }

    @Override
    public Page<ICustomerDto> findAllCustomer(String name, String code, String address, String phoneNumber, String groupValue, Pageable pageable) {
        return customerRepository.findAllCustomer(name, code, address, phoneNumber, groupValue, pageable);
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        try {
            customerRepository.removeCustomer(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
