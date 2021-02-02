package com.project.mobile.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class CurrentUser {


    private String name = "anonymous";


    private boolean isAnonymous = true;

}
