package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Il client è partito");
            Socket s = new Socket("localhost", 3000);
            Scanner tastiera = new Scanner(System.in);

            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            int nRicevuto;
            do {
                System.out.println("indovina il numero da 1 a 100 \n");
                String inputUser = tastiera.nextLine();
                System.out.println(inputUser);
                output.writeBytes(inputUser + "\n");
                nRicevuto = Integer.parseInt(input.readLine());
                if (nRicevuto == 1)
                    System.out.println("Il numero è piu piccolo \n");
                else if (nRicevuto == 2)
                    System.out.println("Il numero è piu grande \n");
            } while (nRicevuto != 3);

            System.out.println("Hai indovinato");

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
