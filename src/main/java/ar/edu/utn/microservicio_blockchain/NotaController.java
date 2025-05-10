package ar.edu.utn.microservicio_blockchain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaController {

    @PostMapping("/nota")
    public String recibirNota(@RequestBody NotaDTO nota) {
        String datos = nota.getDni() + "|" + nota.getMateria() + "|" + nota.getNota() + "|" + nota.getFecha();
        String hash = HashUtil.calcularSHA256(datos);
    
        // Ruta a la clave privada
        String rutaClave = "src/main/resources/keys/private_key.pem";  // aca podemos poner la ruta a la clave privada
    
        String firma = FirmadorDigital.firmar(hash, rutaClave);
    
        return "Hash generado: " + hash + "\nFirma digital (Base64): " + firma;
    }
    
}

