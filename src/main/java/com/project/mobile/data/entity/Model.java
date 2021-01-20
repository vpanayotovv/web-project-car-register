package com.project.mobile.data.entity;

import com.project.mobile.data.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
