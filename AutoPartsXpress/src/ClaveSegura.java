import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class ClaveSegura {
    public static String hashPasword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedPassword);
        }catch(Exception e){
            throw new RuntimeException("Error al crear el hash de la contraseña");
        }
    }
}

