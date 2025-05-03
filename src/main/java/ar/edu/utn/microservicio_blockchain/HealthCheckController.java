package ar.edu.utn.microservicio_blockchain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    public String ping() {
        return "Microservicio Blockchain funcionando 🚀";
    }
}
