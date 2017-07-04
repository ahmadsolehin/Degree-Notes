/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ailab2;

/**
 *
 * @author student
 */
public class Sum {
    private int x1;
    private int y1;
    private int z1;
    private int sum;
    
 
     public Sum(int x, int y, int z){
        x1=x;
        y1=y;
        z1=z;
    }
     
      public Sum(int x, int z){
        x1=x;
        z1=z;
    }
    
    public int addTwo(int x, int y){
        sum=x+y;
        return sum;
    }
    
    public int addThr(){
        sum=x1+y1+z1;
        return sum;
    }
    
}
