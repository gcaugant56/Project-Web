package com.esiea.backend;

import antlr.Token;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
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


    @GetMapping("/user")
    @ResponseBody
    public User getUserByUsername(@RequestBody String token)
    {
        String[] jsonParse;
        jsonParse = token.split("\"");
        String username = Tokenutil.extractUsername(jsonParse[3]);
        User user =  userService.getUserByUsername(username);
        user.hiddenPassword();
        return user;
    }

    @PostMapping("/registration")
    @ResponseBody
    public boolean createUser(@RequestBody User user)
    {
        return userService.createUser(user.getUsername(),user.getPassword(),user.getName(),user.getEmail());
    }

}
