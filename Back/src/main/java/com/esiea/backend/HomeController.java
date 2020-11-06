package com.esiea.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class HomeController {
    @Autowired
    UserService userService;



    @GetMapping("/")
    public String home()
    {
        return "test";
    }

    @GetMapping("/user/all")
    public List<User> getAll()
    {
        return userService.getUser();
    }

    @GetMapping("/user/{username}") //user/root?username=toto
    @ResponseBody
    public User getUserByUsername(@RequestParam String username)
    {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user/{username}{password}{name}") //user/root?username=toto?password=root?name=Guillaume
    @ResponseBody
    public boolean createUser(@RequestParam String username, String password, String name)
    {
        return userService.createUser(username,password,name);
    }

}
