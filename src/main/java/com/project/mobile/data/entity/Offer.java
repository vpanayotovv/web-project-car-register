package com.project.mobile.data.entity;

import com.project.mobile.data.entity.enums.Engine;
import com.project.mobile.data.entity.enums.Transmission;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Offer extends BaseEntity {

    @Column(length = 512)
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    private Integer year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;
}
