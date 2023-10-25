package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            System.out.println("Server in avvio");

            ServerSocket server = new ServerSocket(3000);

            while(true){
                Socket s = server.accept();
                MioThread thread = new MioThread(s);
                thread.start();
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
