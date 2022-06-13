package org.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * telnet 127.0.0.1 1234
 *
 */

public class Server {
    static int portNumber = 1234;
    static String s = "";


    public static void main(String[] args) {



        System.out.println("Hello from server");

        System.out.println("Server started!");
        System.out.println("---------------------------------------------------------");
        ServerSocket serverSocket = null;
        ServerSocket serverSocket1 = null;

        Socket clientSocket = null;
        Socket clientSocket1 = null;

        ClientHandler ch = new ClientHandler(serverSocket, clientSocket);

        ch.accept();

        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(ch.getClientSocket().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        PrintWriter out = null;
        try {
            out = new PrintWriter(ch.getClientSocket().getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            while ((s = in.readLine()) != null) {
                out.println("result: " + process(s));
                System.out.println(process(s));
            }
        } catch (IOException e) {
            System.out.println("Si è sganciato");


            try {
                serverSocket1 = new ServerSocket();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static String process(String stringa) {

        if (stringa.contains("+")) {
            String[] parts = stringa.split(Pattern.quote("+"));

            String part1 = parts[0];
            int a = Integer.parseInt(part1);
            String part2 = parts[1];
            int b = Integer.parseInt(part2);

            int c = a + b;
            stringa = Integer.toString(c);
        }

        else if (stringa.contains("-")) {
            String[] parts = stringa.split("-");

            String part1 = parts[0];
            int a = Integer.parseInt(part1);
            String part2 = parts[1];
            int b = Integer.parseInt(part2);

            int c = a - b;
            stringa = Integer.toString(c);
        }

        else if (stringa.contains("*")) {
            String[] parts = stringa.split(Pattern.quote("*"));

            String part1 = parts[0];
            int a = Integer.parseInt(part1);
            String part2 = parts[1];
            int b = Integer.parseInt(part2);

            int c = a * b;
            stringa = Integer.toString(c);
        }

        else if (stringa.contains("/")) {
            String[] parts = stringa.split("/");

            String part1 = parts[0];
            int a = Integer.parseInt(part1);
            String part2 = parts[1];
            int b = Integer.parseInt(part2);

            int c = a / b;
            stringa = Integer.toString(c);
        }

        return stringa;
    }
}