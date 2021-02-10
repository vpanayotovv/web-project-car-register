package com.project.mobile.models.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelViewModel {

    private Long id;

    private String name;

    private String category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    private BrandViewModel brand;

}
