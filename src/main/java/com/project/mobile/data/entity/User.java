package com.project.mobile.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String imageUrl;

    @OneToMany
    private List<UserRole> roles;

}
