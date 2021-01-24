package com.project.mobile.models.dto;


import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BrandSeedDto {

    @Expose
    private String name;

    @Expose
    private LocalDateTime created;

    @Expose
    private LocalDateTime modified;


}
