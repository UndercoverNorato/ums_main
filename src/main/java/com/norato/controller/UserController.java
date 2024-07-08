package com.norato.controller;




import com.norato.config.JwtUtil;
import com.norato.model.User;
import com.norato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        ResponseEntity<String> loginResponse = userService.loginUser(user);
        if (loginResponse.getStatusCode().is2xxSuccessful()) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok("Bearer " + token);
        }
        return loginResponse;
    }
}
