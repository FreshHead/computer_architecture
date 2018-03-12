package ru.univeralex.lab5.client_server.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer {
    public static void main (String args[]) {
        try { System.out.println("Сервер запущен");
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket (serverPort); // new server port generated
            while(true) {
                Socket clientSocket = listenSocket.accept(); // listen for new connection
                Connection c = new Connection(clientSocket); // launch new thread
            }
        } catch(IOException e) { System.out.println("Listen socket:"+e.getMessage());
        }
    }
}