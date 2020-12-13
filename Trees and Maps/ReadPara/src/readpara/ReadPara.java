/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readpara;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Amiena
 */
public class ReadPara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String paragraph;
        String word;
        int wordcount=0;
        Scanner input= new Scanner(System.in);
        String temp[];
        Map<String, Integer> myTree = new TreeMap<String, Integer>();
        System.out.println("Enter your preferred paragraph.");
        temp = input.nextLine().split(" ");
        //System.out.println("Enter your word to find.");
        //word = input.next();
        
               
        
        for(int count=0; count< temp.length; count++){
         String key = temp[count].toLowerCase();
         if(temp[count].length()>1){
             if(myTree.get(key)== null){
                 myTree.put(key, 1);
             }
             else{
                 int value = myTree.get(key).intValue();
                 value++;
                 myTree.put(key, value);
             }
         }
           
        }
        
        System.out.println(myTree);
        
            }
    
}
