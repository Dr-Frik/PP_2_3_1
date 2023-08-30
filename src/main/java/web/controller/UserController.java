package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getUserById(@PathVariable int id, Model model) {
        model.addAttribute("userId", userService.getUserById(id));
        return "/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "/newUser";
    }

    @PostMapping("/new")
    public String saveNewUser(@ModelAttribute User user) {
        userService.saveNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("userId", userService.getUserById(id));
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/";
    }
}

