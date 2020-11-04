package com.esiea.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    UserService user;

    @GetMapping("/all")
    public List<User> getAll()
    {
        return user.getUser();
    }

    @GetMapping("/")
    public String home()
    {
        return "test";
    }
}
