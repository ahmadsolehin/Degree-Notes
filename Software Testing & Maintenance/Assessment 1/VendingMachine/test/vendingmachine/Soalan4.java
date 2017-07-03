/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author User
 */
import java.util.*;

public class Soalan4 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int siput = 100;

        int ubi = 100;
         int tempeyek = 75;

        int pisang = 100;

        System.out.println("  ^^/>   Vending Machine   ^^/>");

        while (true) {

            if ( siput == 0 && ubi == 0 && tempeyek == 0 && pisang == 0  ) {

            System.out.println("Temporarily out of order");

            break;

        }

            System.out.println("Select your product.");

            System.out.println("1 - KUIH SIPUT       ");

            System.out.println("2 - Kerepek Ubi       ");

            System.out.println("3 - Tempeyek");
            System.out.println("4 - Kerepek Pisang");


            System.out.print("Your Choice    :");

             

            int YourChoice = console.nextInt();

            while (YourChoice < 1 || YourChoice > 3) {

                System.out.println("Please pick a valid product");

                System.out.print("Your Choice    :");

                YourChoice = console.nextInt();

            }

             

            if (YourChoice == 1 && siput >0) {
                System.out.println("You chose KUIH SIPUT");

                siput--;

            } else if (YourChoice == 1 && siput==0) {

                System.out.println("The product is out of order, please pick something else");

            }

            if (YourChoice == 2 && ubi>0) {

                System.out.println("You chose KEREPEK UBI");

                ubi--;

            } else if (YourChoice == 2 && ubi==0) {

                    System.out.println("The product is out of order, please pick something else");

            }

            if (YourChoice == 3 && tempeyek>0) {

                System.out.println("You chose Mineral TEMPEYEK");

                tempeyek--;

            } else if (YourChoice == 3 && tempeyek==0) {

                System.out.println("The product is out of order, please pick something else");

                tempeyek--;

            }
            
            if (YourChoice == 4 && pisang>0) {

                System.out.println("You chose KEREPEK PISANG");

                pisang--;

            } else if (YourChoice == 4 && pisang==0) {

                System.out.println("The product is out of order, please pick something else");

                pisang--;

            }

         if (YourChoice == 1 && siput >0){
            int Prize = 50;

            System.out.print("Please insert " + Prize + " Cent :");

            int Coins = console.nextInt();

 

            while (Coins < Prize) {

                System.out.println("Please insert the remaining "+ (Prize - Coins) + " Cent :");

                Coins += console.nextInt();

            }

            if (Coins == Prize) {

                System.out.println("Thank you, please take your item.");

            }

 

            else if (Coins > 50) {

                System.out.println("Thank you, please take your change ("+ (Coins - 50) + " Cent).");

            }

            
            
 

            else if (Coins < 0) {
  
                System.out.println("Please insert a valid amount");

            }
            
         }
         
         if (YourChoice == 2 && ubi >0){
            int Prize = 65;

            System.out.print("Please insert " + Prize + " Cent :");

            int Coins = console.nextInt();

 

            while (Coins < Prize) {

                System.out.println("Please insert the remaining "+ (Prize - Coins) + " Cent :");

                Coins += console.nextInt();

            }

            if (Coins == Prize) {

                System.out.println("Thank you, please take your item.");

            }

 

            else if (Coins > 65) {

                System.out.println("Thank you, please take your change ("+ (Coins - 65) + " Cent).");

            }

            
            
 

            else if (Coins < 0) {
  
                System.out.println("Please insert a valid amount");

            }
            
         }
         
         if (YourChoice == 3 && tempeyek >0){
            int Prize = 45;

            System.out.print("Please insert " + Prize + " Cent :");

            int Coins = console.nextInt();

 

            while (Coins < Prize) {

                System.out.println("Please insert the remaining "+ (Prize - Coins) + " Cent :");

                Coins += console.nextInt();

            }

            if (Coins == Prize) {

                System.out.println("Thank you, please take your item.");

            }

 

            else if (Coins > 45) {

                System.out.println("Thank you, please take your change ("+ (Coins - 45) + " Cent).");

            }

            
            
 

            else if (Coins < 0) {
  
                System.out.println("Please insert a valid amount");

            }
            
         }
         
         
         if (YourChoice == 4 && pisang >0){
            int Prize = 85;

            System.out.print("Please insert " + Prize + " Cent :");

            int Coins = console.nextInt();

 

            while (Coins < Prize) {

                System.out.println("Please insert the remaining "+ (Prize - Coins) + " Cent :");

                Coins += console.nextInt();

            }

            if (Coins == Prize) {

                System.out.println("Thank you, please take your drink.");

            }

 

            else if (Coins > 45) {

                System.out.println("Thank you, please take your change ("+ (Coins - 85) + " Cent)");

            }

            
            
            
            

            System.out.println("");

           System.out.println("-------Welcome to the Vending Machine-------");

 

        }

    }


}}
