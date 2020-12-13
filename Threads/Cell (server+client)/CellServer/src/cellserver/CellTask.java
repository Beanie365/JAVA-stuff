/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellserver;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amiena
 */
public class CellTask implements Runnable {

    Socket soc;
    String message = "";
    DataInputStream input;
    DataOutputStream output;
    String manu;
    String model;
    String price;
    public CellTask(Socket soc) {
        this.soc = soc;
        
    }
    
    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(soc.getInputStream());
            
            manu = input.readUTF();
            model = input.readUTF();
            price = input.readUTF();
            message = "The manufacturer of the cellphone is " +manu + "\n The model of the phone is " +model +"\n The price of the phone is R" +price;
            //message = "Got stuff";
            System.out.println(message);
            writeFile();
        } catch (IOException ex) {
            Logger.getLogger(CellTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //to send information to the client
            DataOutputStream output = new DataOutputStream(soc.getOutputStream());
            output.writeUTF("Hello Client. This is your information. \n" +message +"\n Your information has been saved to text file cell.txt");
        } catch (IOException ex) {
            Logger.getLogger(CellTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void writeFile(){
        try (FileWriter writer = new FileWriter("cell.txt");
	 BufferedWriter bw = new BufferedWriter(writer)) {

	bw.write(message);

} catch (IOException e) {
	System.err.format("IOException: %s%n", e);
}
    }
    
}
