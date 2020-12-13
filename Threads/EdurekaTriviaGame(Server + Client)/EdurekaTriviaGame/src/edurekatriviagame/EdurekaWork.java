/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edurekatriviagame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amiena
 */
public class EdurekaWork implements Runnable {

    Socket soc;
    DataInputStream input;
    DataOutputStream output;
    Boolean setting = true;
    char sumop;
    int num;
    int num1 = 0;
    int num2 = 0;
    int ans = 0;
    int client;
    String message;

    public EdurekaWork(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {

        try {
            input = new DataInputStream(soc.getInputStream());

            output = new DataOutputStream(soc.getOutputStream());
            output.writeUTF("Welcome to Edureka's Trivia Game");
            while (setting = true) {
                output.writeUTF(createSum());
                message = input.readUTF();
                if (message.equals("stop")) {
                    try {
                        System.out.println("Client answers:" + message);
                        output.writeUTF("Thanks for Playing!");
                        output.close();
                        input.close();
                        soc.close();
                        setting = false;
                        System.exit(1);
                        break;

                    } catch (IOException e) {
                        System.out.println("Connection closed from Client.");
                    }
                } else {
                    //client = Integer.parseInt( input.readUTF());
                    client = Integer.parseInt(message);
                    System.out.println("Client answers: " + client);
                    output.writeUTF(clientReply());
                }
            }
        } catch (IOException ex) {

            System.out.println("Connection closed!");
        }

    }

    public int getRandomNumber() {
        int max = 11;
        int min = 1;

        return (int) ((Math.random() * (max - min)) + min);
    }

    public char getOperator() {
        char ops[] = {'+', '-', '/', '*'};
        char operator;
        num = (int) ((Math.random() * (4 - 0)) + 0);

        operator = ops[num];
        return operator;
    }

    public String createSum() {
        num1 = getRandomNumber();
        num2 = getRandomNumber();
        sumop = getOperator();

        return "Your sum is " + num1 + " " + sumop + " " + num2 + ". Enter the correct Answer!";
    }

    public int getAns() {

        if (sumop == '/') {
            ans = num1 / num2;

        }
        if (sumop == '+') {
            ans = num1 + num2;

        }
        if (sumop == '-') {
            ans = num1 - num2;

        }
        if (sumop == '*') {
            ans = num1 * num2;

        }
        return ans;
    }

    public String clientReply() throws IOException {
        String reply = "";

        if (client == getAns()) {
            reply = "Correct Answer! Next question coming up.";
        } else {
            reply = "Incorrect Answer! The correct answer was " + getAns() + " New question incoming.";
        }
        return reply;
    }

}
