package com.loginproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loginproject.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Habilitar CORS para todas las solicitudes en este controlador
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/saludo")
    public String hello() {
        return "¡Hola mundo!";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la cuenta: " + e.getMessage());
        }
    }

    // esto debería ser un get, no un post.
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        User foundUser = userService.findUserByUsername(userDTO.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(userDTO.getPassword())) {
            return ResponseEntity.ok("Bienvenido " + foundUser.getUsername());
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}