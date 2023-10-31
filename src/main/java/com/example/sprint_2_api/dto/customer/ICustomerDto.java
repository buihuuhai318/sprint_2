package com.example.sprint_2_api.dto.customer;

public interface ICustomerDto {
    Long getId();
    String getCode();
    String getName();
    String getBirthDay();
    String getAddress();
    String getPhoneNumber();
    String getNote();
    String getCustomerType();
}