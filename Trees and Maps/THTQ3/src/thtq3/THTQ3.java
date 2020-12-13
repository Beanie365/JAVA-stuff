/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thtq3;

import java.util.TreeSet;

/**
 *
 * @author Amiena
 */
public class THTQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TreeSet<String> people = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        //Adding Elements to treeset

        people.add("Kagiso");
        people.add("Thando");
        people.add("Riaan");
        people.add("Xolani");
        people.add("Palesa");
        //Displaying all elements

        System.out.println("Students TreeSet : " + people);

        // Finding the size of a TreeSet
        System.out.println("Number of elements in the TreeSet : " + people.size());

        // Check if an element exists in the TreeSet
        String name = "Julia";
        
//Displaying last element
        System.out.println("Last element : " + people.last());

        name = "R";
        System.out.println("Element just greater than "  + name + " : " + people.higher(name));
        System.out.println("Element just lower than "  + name + " : " + people.lower(name));
        
    }
    
}
