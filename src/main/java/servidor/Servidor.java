package servidor;

import cifrado.Descifrado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensajeCifrado = input.readLine();
            System.out.println("Mensaje recibido (cifrado): " + mensajeCifrado);

            // Descifrar mensaje
            String mensajeOriginal = Descifrado.descifrar(mensajeCifrado);
            System.out.println("Mensaje descifrado: " + mensajeOriginal);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
