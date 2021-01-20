package com.project.mobile.models.entity;

import com.project.mobile.models.entity.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String imageUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
