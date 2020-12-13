/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thtq5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.LinkedHashMap;
import javax.swing.*;

/**
 *
 * @author Amiena
 */
public class THTQ5 extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     *
     */
    LinkedHashMap<Integer, String> hmap
            = new LinkedHashMap<Integer, String>();
    StringBuilder sb = new StringBuilder();
    JPanel pane = new JPanel();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JButton show = new JButton("Show All");
    JButton change = new JButton("Change");
    JLabel welcome = new JLabel("Welcome to the TTechDevs App");
    JLabel ename = new JLabel("Enter Element Name:");
    JLabel enumber = new JLabel("Enter Element Number:");
    JTextField enametxt = new JTextField(30);
    JTextField enumbertxt = new JTextField(30);

    public THTQ5() {
        super("TTechDevs App");

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.add(welcome);
        pane.add(ename);
        pane.add(enametxt);
        pane.add(enumber);
        pane.add(enumbertxt);
        pane.add(add);
        pane.add(change);
        pane.add(remove);
        pane.add(show);

        add.addActionListener(this);
        change.addActionListener(this);
        remove.addActionListener(this);
        show.addActionListener(this);
        pane.setLayout(new GridLayout(10, 2));
        getContentPane().add(pane);
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new THTQ5();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int namelength;
        int numlength;
        int tempnum;
        if (source.equals(add)) {
            namelength = enametxt.getText().length();
            numlength = enumbertxt.getText().length();
            if (enumbertxt.getText().equals("")) {
                tempnum = 0;
            } else {
                tempnum = parseInt(enumbertxt.getText());
            }

            if (namelength > 0) {
                if (numlength > 0) {
                    hmap.put(tempnum, enametxt.getText());
                    JOptionPane.showMessageDialog(pane, "Element successfully added", "Message", JOptionPane.PLAIN_MESSAGE);
                    enametxt.setText("");
                    enumbertxt.setText("");
                    System.out.println(hmap);
                } else {
                    JOptionPane.showMessageDialog(pane, "Please enter an element number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(pane, "Please enter an element name", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (source.equals(change)) {
            namelength = enametxt.getText().length();
            numlength = enumbertxt.getText().length();
            if (enumbertxt.getText().equals("")) {
                tempnum = 0;
            } else {
                tempnum = parseInt(enumbertxt.getText());
            }

            if (namelength > 0) {
                if (numlength > 0) {
                    if (hmap.containsKey(tempnum)) {
                        hmap.replace(tempnum, enametxt.getText());
                        JOptionPane.showMessageDialog(pane, "Element successfully changed.", "Message", JOptionPane.PLAIN_MESSAGE);
                        enametxt.setText("");
                        enumbertxt.setText("");
                        System.out.println(hmap);
                    } else {
                        JOptionPane.showMessageDialog(pane, "The specified element does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(pane, "Please enter an element number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(pane, "Please enter an element name", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (source.equals(remove)) {

            numlength = enumbertxt.getText().length();
            if (enumbertxt.getText().equals("")) {
                tempnum = 0;
            } else {
                tempnum = parseInt(enumbertxt.getText());
            }

            if (numlength > 0) {
                hmap.remove(tempnum);
                JOptionPane.showMessageDialog(pane, "Element successfully removed.", "Message", JOptionPane.PLAIN_MESSAGE);
                enametxt.setText("");
                enumbertxt.setText("");
                System.out.println(hmap);
            } else {
                JOptionPane.showMessageDialog(pane, "Please enter an element number", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (source.equals(show)) {
            if (hmap.isEmpty()) {
                JOptionPane.showMessageDialog(pane, "There are no recorded elements.", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                hmap.entrySet().stream().map((entry) -> {
                    sb.append(entry.getKey());
                    return entry;
                }).map((entry) -> {
                    sb.append("=");
                    return entry;
                }).map((entry) -> {
                    sb.append(entry.getValue());
                    return entry;
                }).forEachOrdered((_item) -> {
                    sb.append("\n");
                });
                sb.deleteCharAt(sb.length() - 1);
                String result = sb.toString();

                JOptionPane.showMessageDialog(pane, "Elements are: \n" + result, "List of Elements", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
