/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ailab3;

import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class AIlab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fullName="";
        int age=0;
        fullName= JOptionPane.showInputDialog(null, "Enter your full name :");
        age= Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age :"));
        JOptionPane.showConfirmDialog(null, age, "Is this your real age?",
             JOptionPane.OK_CANCEL_OPTION);
        
        JOptionPane.showMessageDialog(null, "Your FullName : " + fullName + "\n Yor Age : " + age);
        
        
    }
    
}
