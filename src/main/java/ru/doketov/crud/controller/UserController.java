package ru.doketov.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.doketov.crud.model.User;
import ru.doketov.crud.service.UserService;

import java.io.*;
import java.util.List;

/**
 * Main and single controller of {@link User}
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String mainPage() {
        return "main";
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("allUsers", list);
        return "all-users";
    }

    @GetMapping(value = "/users/{id}")
    public String getUserById(@PathVariable("id") Long id, ModelMap model) {
        User oneUser = userService.getUserById(id);
        if (oneUser == null) {
            model.addAttribute("notFoundedId", id);
            return "one-user-not-found";
        } else {
            model.addAttribute("oneUser", userService.getUserById(id));
            return "one-user";
        }
    }

    @GetMapping(value = "/users/add")
    public String showCreateForm(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "add-user";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User user, ModelMap model) {
        model.addAttribute("newUser", user);
        userService.addUser(user);
        return "add-user-result";
    }

    @PostMapping(value = "/users/delete")
    public String showDeleteResult(@ModelAttribute User user, ModelMap model) {
        model.addAttribute("userForDeletion", user);
        return "delete-user-result";
    }

    @PostMapping(value = "/users/delete/confirmed")
    public String deleteUser(@ModelAttribute User user) {
        userService.deleteUser(user);
        return "redirect:/users";
    }


}
