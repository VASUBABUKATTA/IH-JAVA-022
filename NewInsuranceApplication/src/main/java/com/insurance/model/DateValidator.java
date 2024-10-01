package com.insurance.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    @Override
    public void initialize(ValidDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null || dateStr.isEmpty()) {
            return false;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            
            // Check if the person is at least 18 years old
            LocalDate currentDate = LocalDate.now();
            long yearsBetween = ChronoUnit.YEARS.between(date, currentDate);
            return yearsBetween >= 18;
        } catch (DateTimeParseException e) {
            return false; // Invalid date format
        }
    }
}

