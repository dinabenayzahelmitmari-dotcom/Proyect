package cifrado;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Descifrado {

    private static final String ALGORITMO = "AES";
    private static final String CLAVE = "1234567890123456"; // Igual que en el cliente

    public static String descifrar(String textoCifrado) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytesDecodificados = Base64.getDecoder().decode(textoCifrado);
        byte[] textoOriginal = cipher.doFinal(bytesDecodificados);
        return new String(textoOriginal);
    }
}
