/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Soalan2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner keyboard = new Scanner(System.in);
Dispenser d = new Dispenser();
        double item1 = 50;
        double item2 = 60;
        double item3 = 65;
        double item4 = 85;
       
        System.out.print("\n 1 - KUIH SIPUT - 50 CENTS ");
         System.out.print("\n 2 - KEREPEK UBI - 60 CENTS  ");
          System.out.print("\n 3 - TEMPEYEK - 65 CENTS ");
            System.out.print("\n 4 - KEREPEK PISANG - 85 CENTS  ");

        System.out.print("\nEnter an item number: ");
        int item = keyboard.nextInt();
        

        System.out.print("Enter the amount paid: ");
        double paid = keyboard.nextDouble();
        

        if (item == 2 || item == 4 )
            
            
        { 
            if (paid >= item2)
                
                
            {
                
          item = d.getCount();
          paid = d.getProductCost();
                System.out.println("Thank you for buying item " + item + ", your change is $" + (paid-item2) + ". Please come again!");
            }
            if (paid < item2)
            {
                System.out.println("Please insert another " + "$" + (item2-paid));
                
            }
            
           
            
        }
        
        

        else if (item == 1)
        {
            if (paid >= item1) 
            {
                System.out.println("Thank you for buying item " + item + ", your change is $" + (paid-item1) + ". Please come again!");
            }
            if (paid < item1)
            {
                System.out.println("Please insert another " + "$" + (item1-paid));
            }
        }
        else if (item == 3)
        {
            if (paid >= item3) 
            {
                System.out.println("Thank you for buying item " + item + ", your change is $" + (paid-item3) + ". Please come again!");
            }
            if (paid < item3)
            {
                System.out.println("Please insert another " + "$" + (item3-paid));
            }
        }
        


    }

}