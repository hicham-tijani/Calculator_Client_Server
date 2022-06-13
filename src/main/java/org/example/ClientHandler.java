package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Server.portNumber;

public class ClientHandler {

    ServerSocket serverSocket;
    Socket clientSocket;


    public ClientHandler(ServerSocket serverSocket, Socket clientSocket) {
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;
    }

    public void accept() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientSocket = null;
        Socket clientSocket1 = null;
        System.out.println("Accepting...");
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Accepted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}
