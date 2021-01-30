package com.project.mobile.web;

import com.project.mobile.models.dto.UserLoginBindingModel;
import com.project.mobile.security.CurrentUser;
import com.project.mobile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final CurrentUser currentUser;
    private final UserService userService;

    public LoginController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel){
        if (this.userService.authenticate(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword())) {
            this.userService.loginUser(userLoginBindingModel.getUsername());
            return "redirect:/";
        }else {
            return "redirect:login";
        }
    }

}
