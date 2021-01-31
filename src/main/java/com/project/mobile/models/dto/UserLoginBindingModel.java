package com.project.mobile.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {

    private String username;

    private String password;

}
