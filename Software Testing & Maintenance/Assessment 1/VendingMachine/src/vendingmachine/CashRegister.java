/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author FSK4
 */
public class CashRegister {
    
    private int cashOnHand;
    
    public CashRegister(int cashIn){
        if(cashIn >= 0)
            cashOnHand = cashIn;
        else
            cashOnHand = 100;
    }
    
    public CashRegister(){
        cashOnHand = 100;
    }
    
    public int currentBalance(){
        return cashOnHand;
    }
    
    public void acceptAmount (int amountIn){
        cashOnHand = cashOnHand + amountIn;
    }
}
