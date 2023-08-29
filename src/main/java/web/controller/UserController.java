package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")// localhost:8080/
    public String index(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "/allUsers";
    }
    @GetMapping("/{id}") // localhost:8080/user/(id)
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("userId", userService.getUserById(id));
        return "/user";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user")User user){
        return "/newUser";
    }
    @PostMapping("/new")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveNewUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("userId", userService.getUserById(id));
        return "/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }
}

