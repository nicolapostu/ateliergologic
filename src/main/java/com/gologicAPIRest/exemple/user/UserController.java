package com.gologicAPIRest.exemple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        UserResource userResource = new UserResource();
        model.addAttribute("userResource",userResource);
        model.addAttribute("users",users);
        return "home";
    }
    @GetMapping("/edit")
    public String userAdd( Model model ) {

        return "edit";
    }
}
