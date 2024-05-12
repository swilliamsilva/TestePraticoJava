package testes;

import java.io.IOException;
import java.net.Socket;

public class PortTester {

    public static void main(String[] args) {
        String host = "localhost"; // Pode ser alterado para o host desejado
        int port = 9494; // Número da porta a ser testada

        try (Socket socket = new Socket(host, port)) {
            System.out.println("A porta " + port + " está aberta e aceitando conexões.");
        } catch (IOException e) {
            System.out.println("A porta " + port + " não está disponível ou o host não está acessível.");
        }
    }
}
