package com.project.mobile.models.entity;

import com.project.mobile.models.entity.enums.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(length = 512)
    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    @ManyToOne
    private Brand brand;

}
