/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ailab4b;

import java.io.*;


/**
 *
 * @author student
 */
public class AIlab4b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[][] data = new String [6][6];
        double[]x;
        x=new double[6];
        
        int rowes=0;
        
        try{
            FileInputStream f = new FileInputStream("C:/Users/student/Documents/NetBeansProjects/AIlab4b/Data.txt ");
            DataInputStream input = new DataInputStream(f);
            BufferedReader br = new BufferedReader (new InputStreamReader(input));
            String strLine;
            String[] temp;
            int j=0;
            while((strLine = br.readLine()) != null){
                //System.out.println(strLine);
                temp = strLine.split(" ");
                //int j=0;
                for (int i=0; i<temp.length; i++){
                      data[j][i]=temp[i];
            }
                
                j++;
            }
            rowes=j;
            
        
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
}
        
        for (int j1=0; j1<rowes; j1++){
            //for(int i=0; i<6; i++){
                System.out.println(data[j1][5]);
             x[j1]=Double.parseDouble(data[j1][5]);
           }
    
}
}
