package com.project.mobile.data.entity;

import com.project.mobile.data.entity.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
