package com.project.mobile.security;

import com.project.mobile.models.entity.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class CurrentUser {

    private String name = "anonymous";
    private boolean isAnonymous = true;
    private List<Role> userRoles = new ArrayList<>();

    public CurrentUser setUserRoles(List<Role> newUserRoles) {
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }

    public boolean isAdmin() {
        return userRoles.contains(Role.ADMIN);
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = "anonymous";
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }

}
