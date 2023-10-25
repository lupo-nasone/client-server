package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class MioThread extends Thread{

    Socket client;

    public MioThread(Socket s){
        client = s;
    }

    public void run(){
        try{
            System.out.println("un client si è collegato");
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            int n = (int) (Math.random() * 100 + 1);
            System.out.println(n);

            int a;
            do {
                String temp = input.readLine();
                System.out.println(temp + "\n");

                a = Integer.parseInt(temp);
                if (a < n) {
                    output.writeBytes("1" + "\n");
                } else if (a > n) {
                    output.writeBytes("2" + "\n");
                }
            } while (a != n);

            output.writeBytes("3" + "\n");

            client.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
        
    }
     
}
