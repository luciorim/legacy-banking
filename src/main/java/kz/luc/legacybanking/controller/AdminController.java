package kz.luc.legacybanking.controller;

import kz.luc.legacybanking.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userService;

    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAdminPage(org.springframework.ui.Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
