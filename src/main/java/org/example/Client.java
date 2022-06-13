package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {


    public static void main(String[] args) {

        System.out.println("Hello from Client");


        String hostName = "127.0.0.1";
        int portNumber = 1234;

        Socket echoSocket = null;
        try {
            echoSocket = new Socket(hostName, portNumber);
        } catch (IOException e) {
            System.out.println("cannot reach server "+e);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(echoSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("cannot allocate bufferedreader");
        }

        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        String s = "";

        while (true) {
            try {
                if (!((s = stdIn.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.println(s);
            //out.flush();
            try {
                System.out.println("echo: " + in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}