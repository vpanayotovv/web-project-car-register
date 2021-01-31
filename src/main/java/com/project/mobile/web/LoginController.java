package com.project.mobile.web;

import com.project.mobile.models.dto.UserLoginBindingModel;
import com.project.mobile.models.entity.User;
import com.project.mobile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("notFound",false);
        }
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel,
                               RedirectAttributes redirectAttributes) {


        boolean authenticate = this.userService.authenticate(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());
        if (!authenticate) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

        this.userService.loginUser(userLoginBindingModel.getUsername());
        return "redirect:/";
    }
}
