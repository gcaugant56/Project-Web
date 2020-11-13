package com.esiea.backend.services;

import com.esiea.backend.SecurityConfigurer;
import com.esiea.backend.User;
import com.esiea.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfigurer passwordEncoder;

    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username)
    {
        return userRepository.getUserByUsername(username);
    }

    public boolean createUser(String username, String password, String name, String email)
    {
        User user = userRepository.getUserByUsername(username);
        if( user !=  null)
        {
            return false;
        }
        else
        {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.passwordEncoder().encode(password));
            newUser.setName(name);
            newUser.setEmail(email);
            userRepository.save(newUser);
            return true;
        }

    }
}
