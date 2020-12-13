/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Amiena
 */
public class CellServer {

    String message;

    public CellServer() throws IOException {
        ServerSocket serveSoc = new ServerSocket(80);
        while (true) {

            
            Socket soc = serveSoc.accept();
            CellTask task = new CellTask(soc);
            Thread t1 = new Thread(task);
            t1.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new CellServer();
    }
}
