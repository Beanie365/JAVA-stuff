/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edurekaclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Amiena
 */
public class EdurekaClient {

    /**
     * @param args the command line arguments
     */
    Scanner scan = new Scanner(System.in);

    public EdurekaClient() throws IOException {
        Socket soc = new Socket("localhost", 8000);
        Boolean setting = true;
        int ans = 0;
        String message = "";
        try{
        // to recieve
        DataInputStream input = new DataInputStream(soc.getInputStream());

        //to send
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        
        System.out.println(input.readUTF());
        while (setting = true) {

            System.out.println(input.readUTF());
            ans = scan.nextInt();
            message = "" + ans;
            out.writeUTF(message);
            System.out.println(input.readUTF());

        }
        }catch(IOException | java.util.InputMismatchException w) { System.out.println("Connection closed from Server. Thanks for Playing!"); }
            }
    

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        new EdurekaClient();
    }

}
