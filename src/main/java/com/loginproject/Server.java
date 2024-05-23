package com.loginproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

//mvn spring-boot:run

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Habilitar CORS para todas las solicitudes en este controlador
@RequestMapping("/test")
public class Server {

    @GetMapping("/")
    public String hello() {
        return "¡Hola mundo!";
    }

    @GetMapping("/hola")
    public String holaWacho() {
        return "Como están muchachos";
    }

    @GetMapping("/holarda")
    public String comoEstanMuchachos() {
        return "yo los veo muy bien";
    }

}
