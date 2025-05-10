package ar.edu.utn.microservicio_blockchain;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;

import java.util.Base64;

public class FirmadorDigital {

    @SuppressWarnings("resource")
    public static String firmar(String mensaje, String rutaClavePrivada) {
        try {
            // Leer la clave privada desde el archivo PEM
            byte[] keyBytes = new FileInputStream(new File(rutaClavePrivada)).readAllBytes();

            // Eliminar encabezado y pie del archivo PEM
            String keyPem = new String(keyBytes)
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] decoded = Base64.getDecoder().decode(keyPem);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Firmar el mensaje (el hash que generaste antes)
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(mensaje.getBytes(StandardCharsets.UTF_8));

            byte[] firmaBytes = signature.sign();
            return Base64.getEncoder().encodeToString(firmaBytes);

        } catch (Exception e) {
            throw new RuntimeException("Error al firmar el mensaje", e);
        }
    }
}
