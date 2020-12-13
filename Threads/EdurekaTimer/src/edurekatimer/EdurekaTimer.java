/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edurekatimer;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Amiena
 */
public class EdurekaTimer extends JFrame implements ActionListener, Runnable {

    Boolean start = false;
    int secondTimer = 1000;
    static int counter = 0;
    JPanel pane = new JPanel();
    JLabel info = new JLabel("Time (in seconds):");
    JButton begin = new JButton("Start Timer");
    JButton stop = new JButton("Stop");

    Thread timer;
    JLabel show = new JLabel("0");

    /**
     * @param args the command line arguments
     */
    public EdurekaTimer() {
        super("Edureka Timer");
        pane.add(info);

        pane.add(show);
        pane.add(begin);
        pane.add(stop);

        JFrame frame = new JFrame();

        frame.getContentPane().setPreferredSize(new Dimension(500, 100));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        begin.addActionListener(this);
        stop.addActionListener(this);

        frame.getContentPane().add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new EdurekaTimer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(begin)) {
            start = true;

            timer = new Thread(this, "Stopwatch");

            timer.start();

        }
        if (source.equals(stop)) {
            start = false;

        }

    }

    @Override
    public void run() {
        while (start) {
            count();
        }

    }

    public void count() {
        try {
            Thread.sleep(1000);
            counter = counter + 1;

            show.setText(Integer.toString(counter));

        } catch (InterruptedException ex) {
            Logger.getLogger(EdurekaTimer.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
