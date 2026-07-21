package org.example.jwtdemo.controller;


import org.example.jwtdemo.Dto.JwtRequestDto;
import org.example.jwtdemo.Dto.JwtResponseDto;
import org.example.jwtdemo.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloController {
    private final JwtUtil jwtService;
    private final AuthenticationManager authenticationManager;
    public HelloController(JwtUtil jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/auth/login")
    public String login(@RequestBody JwtRequestDto authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword())
        );
        JwtResponseDto response = new JwtResponseDto();
        response.setToken(jwtService.generateToken(authRequest.getUsername()));
        return jwtService.generateToken(authRequest.getUsername()) ;
    }

    @GetMapping("/user1")
    @PreAuthorize("hasRole('user') " )
    public String user1(){
        return "Hello user1 ";
    }

    @GetMapping("/auth/user")
    @PreAuthorize("hasRole('user') or hasRole('admin')" )
    public String user(){
        return "Hello user ";
    }

    @GetMapping("/auth/admin")
    @PreAuthorize("hasRole('admin')")
    public String admin(){
        return "Hello admin ";
    }

    @GetMapping("/api/protected")
    public String secureEndpoint() {
        return "Success! You have accessed a secure endpoint using Java 21 and JWT.";
    }

}
