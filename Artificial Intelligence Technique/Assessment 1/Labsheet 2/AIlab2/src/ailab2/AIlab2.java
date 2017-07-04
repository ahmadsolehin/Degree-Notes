/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ailab2;

import java.io.InputStreamReader;
import java.util.Scanner;


/**
 *
 * @author student
 */
public class AIlab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String fname;
        //String sname;
        int x,y,z;
        
        Scanner in = new Scanner ( new InputStreamReader (System.in));
        //System.out.println("Enter your first name");
       // fname = in.nextLine();
        //System.out.println("Enter your last name");
        //sname = in.nextLine();
        
       // System.out.println("Your name is " + fname + " " + sname);
        
        System.out.println("Enter x");
        x = in.nextInt();
        System.out.println("Enter y ");
        y = in.nextInt();
        System.out.println("Enter z ");
        z = in.nextInt();
      
        
        Sum su = new Sum(x,y,z);
        System.out.println("Sum of x+y+z = " + su.addThr());
        Sum su1 = new Sum(x,z);
        System.out.println("Sum of x+z = " + su1.addTwo(x, z));
    }
    
}
