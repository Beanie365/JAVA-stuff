/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edurekatriviagame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Amiena
 */
public class EdurekaTriviaGame {

    /**
     * @param args the command line arguments
     */
    
    
    public EdurekaTriviaGame() throws IOException {
                       ServerSocket serveSoc = new ServerSocket(8000);
                       
   
     //loop for more clients
     
     while(true){
     
     Socket soc = serveSoc.accept();
   
     EdurekaWork work = new EdurekaWork(soc);
     Thread t1 = new Thread(work);
     t1.start();
     break;
     }
    

    
}

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Server is starting...");
        System.out.println("Awaiting client.");
        new EdurekaTriviaGame();
    }
}
