package com.project.mobile.models.view;

import com.project.mobile.models.entity.enums.Engine;
import com.project.mobile.models.entity.enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SimpleOfferViewModel {

    private Engine engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    private Transmission transmission;

    private ModelViewModel model;
}
