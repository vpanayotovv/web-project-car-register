package com.project.mobile.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ModelSeedDto {

    @Expose
    private LocalDateTime created;

    @Expose
    private LocalDateTime modified;

    @Expose
    private String name;

    @Expose
    private String category;

    @Expose
    private String imageUrl;

    @Expose
    private Integer startYear;

    @Expose
    private Integer endYear;

    @Expose
    private Long brand;

}
