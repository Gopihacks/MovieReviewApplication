package com.example.movie_review.Controller;

import com.example.movie_review.Entity.Login;
import com.example.movie_review.JwtUtil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class loginController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authmanager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        try{
            Authentication authentication=authmanager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            login.getUsername()
                            ,login.getPassword()));

            String token =jwtUtil.generateToken(authentication);

            return ResponseEntity.ok(Map.of("token",token));

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("Error","Invalid Username or Password"));
        }
}
}