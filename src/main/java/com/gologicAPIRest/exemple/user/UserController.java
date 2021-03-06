package com.gologicAPIRest.exemple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String userList( Model model ) {
        List<UserResource> users = userService.listeUsers() ;
        model.addAttribute("users",users);
        return "home";
    }
    @GetMapping("edit/{id}")
    public String userEdit(@PathVariable Long id,Model model) {
        model.addAttribute("userResource",userService.get(id));
        return "edit";
    }
}
