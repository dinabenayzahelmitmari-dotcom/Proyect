package cifrado;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Cifrado {

    private static final String ALGORITMO = "AES";
    private static final String CLAVE = "1234567890123456"; // 16 bytes

    public static String cifrar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }
}