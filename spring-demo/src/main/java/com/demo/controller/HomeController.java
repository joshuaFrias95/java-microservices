package com.demo.controller;

import com.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("John");
        user.setEmailId("johnDoe@mail.com");

        return user;
    }

    @GetMapping("/{id}/{var}")
    public String pathVariable(@PathVariable String id, @PathVariable("var") String name) {
        return "ID:" + id + "\nNombre: " + name;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
        return "Your name is " + name + "and your email is: " + emailId;
    }
}
