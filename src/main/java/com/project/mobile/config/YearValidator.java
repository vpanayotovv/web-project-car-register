package com.project.mobile.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class YearValidator implements ConstraintValidator<YearValidatorConstraint, Integer> {

    private int minYear;

    public void initialize(YearValidatorConstraint constraint) {
        this.minYear = constraint.minYear();
    }

    public boolean isValid(Integer minYearToEnter
            , ConstraintValidatorContext context) {
        if (minYearToEnter == null){
            return false;
        }

        int currentYear = LocalDate.now().getYear();

        return minYearToEnter >= currentYear && minYearToEnter <= currentYear;
    }
}
