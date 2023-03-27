package puj.proyecto.ms.ecoturist.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonaController {
    @Autowired
    Environment environment;

    @PostMapping("/login")
    public String div(@RequestBody String json) throws Exception {
        
        //String port = environment.getProperty("local.server.port");
        //String response = "Resultado: " + result + " - Microservicio división corriendo en el puerto: " + port;
        
        String response= "cliente";

        return response;
    }
}