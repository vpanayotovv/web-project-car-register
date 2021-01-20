package com.project.mobile.data.entity;


import com.project.mobile.data.entity.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role role;

}
