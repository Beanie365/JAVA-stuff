/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Amiena
 */
public class CheckersClient {

    /**
     * @param args the command line arguments
     */
    Scanner scan= new Scanner(System.in);
    String name;
    double price;
    String type;

    public CheckersClient() throws IOException {
        Socket soc = new Socket("localhost", 8000);
        // to recieve
        DataInputStream input = new DataInputStream(soc.getInputStream());

        //to send
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());

        System.out.println(input.readUTF());
        try{
        while (true) {
              System.out.println("Enter product name");
        name = scan.next();
        if (name.equals("stop")) {
            System.out.println("Exiting System.");
            break;
        }
        else {
            System.out.println("Enter item type");
            type = scan.next();
            if (type.equals("stop")) {
                System.out.println("Exiting System.");
                break;
            } else {
                System.out.println("Enter price of item");
                price = scan.nextDouble();
            }
        }
            out.writeUTF(name);
            out.writeUTF(type);
            out.writeUTF("" + price);
            System.out.println(input.readUTF());
        }
        }catch(IOException | java.lang.NullPointerException e) { System.out.println("Connection closed from Server."); }
    }
        

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Welcome to Checkers Stock Taking App");
        new CheckersClient();

    }

}
