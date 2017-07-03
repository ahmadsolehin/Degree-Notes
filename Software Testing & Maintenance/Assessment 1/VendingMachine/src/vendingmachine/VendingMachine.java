/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VendingMachine extends JFrame{

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    
    private CashRegister cashRegister = new CashRegister();
    
    private Dispenser kuihSiput = new Dispenser(100, 50);
    private Dispenser kerepekUbi = new Dispenser(100, 65);
    private Dispenser tempeyek = new Dispenser(75, 45);
    private Dispenser kerepekPisang = new Dispenser(100, 85);
    
    private JLabel headingMainL;
    private JLabel selectionL;
    
    private JButton exitB, kuihSiputB, kerepekUbiB, tempeyekB, kerepekPisangB;
    private ButtonHandler pbHandler;
    
    public VendingMachine() {
        
        setTitle("Traditional Candy Machine");
        setSize(WIDTH, HEIGHT);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(7,1));
        
        pbHandler = new ButtonHandler();
        
        headingMainL = new JLabel("WELCOME TO ONE STOP TRADITIONAL CANDY SHOP", 
                SwingConstants.CENTER);
        
        selectionL = new JLabel("To make a selection,"
        + "click on the Product Button",
        SwingConstants.CENTER);
        
        pane.add(headingMainL);
        pane.add(selectionL);
        
        kuihSiputB = new JButton("KUIH SIPUT");
        kuihSiputB.addActionListener(pbHandler);
        
        kerepekUbiB = new JButton("KEREPEK UBI");
        kerepekUbiB.addActionListener(pbHandler);
        
        tempeyekB = new JButton("TEMPEYEK");
        tempeyekB.addActionListener(pbHandler);
        
        kerepekPisangB = new JButton("KEREPEK PISANG");
        kerepekPisangB.addActionListener(pbHandler);
                
        exitB = new JButton("EXIT");
        exitB.addActionListener(pbHandler);
        
        pane.add(kuihSiputB);
        pane.add(kerepekUbiB);
        pane.add(tempeyekB);
        pane.add(kerepekPisangB);
        pane.add(exitB);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);                        
    }//End of constructor
    
    private class ButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent e){
            if(e.getActionCommand().equals("Exit"))
                System.exit(0);
            else if(e.getActionCommand().equals("KUIH SIPUT"))
                sellProduct(kuihSiput, "KUIH SIPUT");
            else if(e.getActionCommand().equals("KEREPEK UBI"))
                sellProduct(kerepekUbi, "KEREPEK UBI");
            else if(e.getActionCommand().equals("TEMPEYEK"))
                sellProduct(tempeyek, "TEMPEYEK");
            else if(e.getActionCommand().equals("KEREPEK PISANG"))
                sellProduct(kerepekPisang, "KEREPEK PISANG");
        }
    }//End of ButtonHandler
    
    private void sellProduct(Dispenser product, String productName){
        int coinsInserted = 0;
        int price, coinsRequired;
        String str;
        
        if(product.getCount() > 0){
            price = product.getProductCost();
            coinsRequired = price - coinsInserted;
            
            while(coinsRequired > 0) {
                str = JOptionPane.showInputDialog(" To buy " + productName 
                        + " please insert RM " +  coinsRequired + " cents");
                coinsInserted = coinsInserted + Integer.parseInt(str);
                coinsRequired = price - coinsInserted;
                
            }
            cashRegister.acceptAmount(coinsInserted);
            product.makeSale();
            
            JOptionPane.showMessageDialog(null, "Please pick up your " 
                    + productName + " and enjoy ", "\n Thank you. ",
                    JOptionPane.PLAIN_MESSAGE);
            
        }
        else
            JOptionPane.showMessageDialog(null, "Sorry " + productName 
                    + " is sold out \n" + " Make another selection ",
                    " Thank you.",
                    JOptionPane.PLAIN_MESSAGE);
    }//End of sellProduct
    
    public static void main(String[] args){
        VendingMachine vendingMachine = new VendingMachine();
    }
    
}
