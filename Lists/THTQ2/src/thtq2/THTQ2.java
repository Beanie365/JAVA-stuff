/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thtq2;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Amiena
 */
public class THTQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            // Creating object of ArrayList<Integer> 
            ArrayList<String> mylist = new ArrayList<String>();

            // adding element to arrlist 
            mylist.add("JAVA");
            mylist.add("C#");
            mylist.add("PHP");
            mylist.add("PYTHON");

            ListIterator<String> iterator = mylist.listIterator();

             
            System.out.println("\nUsing ListIterator:\n");
            System.out.println("\nOriginal Order:");
            while (iterator.hasNext()) {
                System.out.println(
                       iterator.next());

            }
            System.out.println("Reversing the order");
            ListIterator li = mylist.listIterator(mylist.size());

// Iterate in reverse.
            while (li.hasPrevious()) {
                System.out.println(li.previous());
            }
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}
