package com.example.sprint_2_api.dto.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class FormatCustomer {
    private static final Random random = new Random();

    public static String generateCustomerCode() {
        int randomNumber = random.nextInt(9999);
        if (randomNumber < 10){
            return "KH000"+randomNumber;
        } else if (randomNumber < 100) {
            return "KH00"+randomNumber;
        } else if (randomNumber < 1000) {
            return "KH0"+randomNumber;
        }
        return "KH"+ randomNumber;
    }

    public static boolean check18YearsOld(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        return date.isBefore(date18YearsAgo);
    }

    public static boolean isDateValidAndBeforeCurrent(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return !date.isAfter(currentDate);
    }
}