package com.project.mobile.models.dto;

import com.project.mobile.config.YearValidatorConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfferAddBindingModel {

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private String engine;

    @NotNull
    @NotEmpty
    private String imageUrl;

    @NotNull
    @Positive
    private Integer mileage;

    @NotNull
    @DecimalMin(value = "1000")
    private BigDecimal price;

    @NotNull
    private String transmission;

    @NotNull
    @YearValidatorConstraint(minYear = 1950)
    private Integer year;

    @NotNull
    private String model;

}
