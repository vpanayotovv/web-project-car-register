package com.project.mobile.models.entity;

import lombok.*;

import javax.persistence.*;

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


}
