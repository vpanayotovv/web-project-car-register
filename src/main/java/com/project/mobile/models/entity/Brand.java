package com.project.mobile.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Model> models;


}
