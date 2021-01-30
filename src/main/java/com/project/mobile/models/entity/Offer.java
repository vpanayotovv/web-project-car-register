package com.project.mobile.models.entity;

import com.project.mobile.models.entity.enums.Engine;
import com.project.mobile.models.entity.enums.Transmission;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Offer extends BaseEntity {

    @Column(length = 512)
    @NonNull
    private String description;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Engine engine;

    @NonNull
    private String imageUrl;

    @NonNull
    private Integer mileage;

    @NonNull
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @NonNull
    private Integer year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;
}
