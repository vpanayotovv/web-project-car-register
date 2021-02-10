package com.project.mobile.models.dto;

import com.project.mobile.config.ValidYearInterface;
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

    @NotNull(message = "Description is required.")
    @NotEmpty(message = "Description is required.")
    private String description;

    @NotNull(message = "Engine is required.")
    private String engine;

    @NotNull(message = "Url is required.")
    @NotEmpty(message = "Url is required.")
    private String imageUrl;

    @NotNull(message = "Mileage is required.")
    @Positive(message = "Mileage must be positive.")
    private Integer mileage;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "1000")
    private BigDecimal price;

    @NotNull(message = "Transmission is required.")
    private String transmission;

    @NotNull(message = "Year is required.")
    @ValidYearInterface(minYear = 1950)
    private Integer year;

    @NotNull(message = "Transmission is required.")
    private String model;

}
