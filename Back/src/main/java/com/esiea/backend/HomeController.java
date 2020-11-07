package com.esiea.backend;

import com.esiea.backend.models.Authenticationrequest;
import com.esiea.backend.models.AuthentificationResponse;
import com.esiea.backend.services.MyUserDetailsService;
import com.esiea.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil Tokenutil;

    @PostMapping("/authentification")
    public ResponseEntity<?> createAuthentificationToken(@RequestBody Authenticationrequest authenticationrequest) throws Exception {
        try {
            authenticationManager.authenticate
                    (
                    new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername(), authenticationrequest.getPassword())
                    );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Nom d'utilisateur ou mot de passe incorrect", e);
        }
        UserDetailsService userDetailsService;
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationrequest.getUsername());
        final String token = Tokenutil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthentificationResponse(token));
    }

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

    @GetMapping("/user/{username}")
    @ResponseBody
    public User getUserByUsername(@RequestParam String username)
    {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user/{username}{password}{name}")
    @ResponseBody
    public boolean createUser(@RequestParam String username, String password, String name)
    {
        return userService.createUser(username,password,name);
    }

}
