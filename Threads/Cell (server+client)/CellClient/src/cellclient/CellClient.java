/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Amiena
 */
public class CellClient {

    /**
     * @param args the command line arguments
     */
    
   
    String manu;
    String model;
    double price;
    String message;
    public CellClient() throws IOException {
         

        captureDetails();
       
        //send info
        
        

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new CellClient();
    }
    
    public void captureDetails() throws IOException{
        
       
        manu = JOptionPane.showInputDialog("Enter manufacturer of phone");
        model = JOptionPane.showInputDialog("Enter model of phone");
        price = parseDouble(JOptionPane.showInputDialog("Enter price of Phone"));
        
        sendToServer();
    }
    
    public void sendToServer() throws IOException{
        Socket soc = new Socket("localhost", 80);
        // to recieve
        DataInputStream input = new DataInputStream(soc.getInputStream());
        

        //to send
        DataOutputStream output = new DataOutputStream(soc.getOutputStream());
        output.writeUTF(manu);
        output.writeUTF(model);
        output.writeUTF(""+price);
        message = input.readUTF();
        //System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
    }
    
}
