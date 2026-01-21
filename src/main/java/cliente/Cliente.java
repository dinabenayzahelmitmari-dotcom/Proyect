package cliente;

import cifrado.Cifrado;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String host = "10.13.7.187"; // Servidor local
        int puerto = 5000;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            String mensaje = "Hola servidor! Este es un mensaje secreto.";

            // Cifrar mensaje
            String mensajeCifrado = Cifrado.cifrar(mensaje);
            System.out.println("Mensaje cifrado enviado: " + mensajeCifrado);

            // Enviar al servidor
            output.println(mensajeCifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}