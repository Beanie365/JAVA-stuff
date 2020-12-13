/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thtq4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author Amiena
 */
public class THTQ4 extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    LinkedList<String> linkedlist = new LinkedList<String>();
    Iterator<String> iterator = linkedlist.iterator();
    StringBuilder list = new StringBuilder();
    JPanel pane = new JPanel();
    JButton register = new JButton("Register Pupil");
    JButton show = new JButton("Show all Registrations");
    JLabel welcome = new JLabel("Welcome to Luthando High School");
    JLabel name = new JLabel("Enter Pupil Name");
    JTextField nametxt = new JTextField(30);

    public THTQ4() {
        super("Luthando High School Registration App");

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane.add(welcome);
        pane.add(name);
        pane.add(nametxt);
        pane.add(register);
        pane.add(show);

        register.addActionListener(this);
        show.addActionListener(this);
        pane.setLayout(new GridLayout(10, 2));
        getContentPane().add(pane);
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here

        new THTQ4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int length;
        if (source.equals(register)) {
            length = nametxt.getText().length();

            if (length > 0) {
                linkedlist.add(nametxt.getText());
                JOptionPane.showMessageDialog(pane, "Student Successfully registered.");
                nametxt.setText("");
            } else {
                JOptionPane.showMessageDialog(pane, "Please enter a student name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (source.equals(show)) {

            if (linkedlist.isEmpty()) {
                JOptionPane.showMessageDialog(pane, "No students currently registered: \n", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (Iterator i = linkedlist.iterator(); i.hasNext();) {
                    list.append(i.next()).append("\n");
                }
                String output = list.substring(0, list.length() - 1);
                System.out.println(list);
                JOptionPane.showMessageDialog(pane, "Students currently registered: \n" + output);
            }
        }

    }

}
