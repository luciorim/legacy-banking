package kz.luc.legacybanking.controller;

import kz.luc.legacybanking.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.register(username, password);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
