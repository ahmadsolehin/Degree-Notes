/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai_lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AI_Lab2 {

    static ArrayList<ArrayList<String>> case_base = new ArrayList<ArrayList<String>> ();
    static ArrayList<ArrayList<String>> new_case = new ArrayList<ArrayList<String>> ();
    static ArrayList<ArrayList<ArrayList<String>>> Local_Sem = new ArrayList<ArrayList<ArrayList<String>>> ();
    static double[] maxvalue = new double[8];
    static double[] minvalue = new double[8];

    
    public static void main(String[] args) throws FileNotFoundException{
        
        for(int i=0; i<9; i++){
            case_base.add(new ArrayList<String>());
            new_case.add(new ArrayList<String>());
            Local_Sem.add(new ArrayList<ArrayList<String>>());
        }
        
        Local_Sem.remove(new ArrayList<String>());

        File file = new File("case-base.txt");
        Scanner data = new Scanner(file);
        while(data.hasNextLine()){
            for(int i=0; i<9; i++){
                case_base.get(i).add(data.next());
            }
        } 
        
        File file1 = new File("case-base.txt");
        Scanner data1 = new Scanner(file1);
        while(data.hasNextLine()){
             for(int i=0; i<9; i++){
                case_base.get(i).add(data.next());
             }
       }
        
     
        for(int jj=0; jj<case_base.size(); jj++){
            double max = 0.0;
            for(int ii=0; ii<case_base.get(jj).size();ii++){
                if(Double.parseDouble(case_base.get(jj).get(ii)) >= max){
                    maxvalue[jj] = Double.parseDouble(case_base.get(jj).get(ii));
                    max = maxvalue[jj];
                }
            }
        }
       
        for(int jj=0; jj<case_base.size() - 1; jj++){
            double min = 1000;
            for(int ii=0; ii<case_base.get(jj).size();ii++){
                if(Double.parseDouble(case_base.get(jj).get(ii)) >= min){
                    minvalue[jj] = Double.parseDouble(case_base.get(jj).get(ii));
                    min = minvalue[jj];
                }
            }
        }
        
        System.out.println("Case base");
        
       for(int ii=0; ii<case_base.get(0).size();ii++){
         for(int j=0; j<case_base.size(); j++){
                System.out.println(case_base.get(j).get(ii) + " ");
                
            }
            
         System.out.println();
         }
       
         System.out.println("New Cases");

         for(int ii1=0; ii1<new_case.get(0).size();ii1++){
            for(int j=0; j<new_case.size(); j++){
                System.out.println(new_case.get(j).get(ii1) + " ");
                
            }
            System.out.println();
        }
         
        int n=0;   
        for(int j=0; j<new_case.get(0).size(); j++)
            for(int n1=0; n1<case_base.get(1).size(); n1++){
                for(int ii=0; ii<case_base.size()-1; ii++){
                    double ls=0.0;
                    
                    ls = 1- (Math.abs(Double.parseDouble(new_case.get(ii).get(j)) -Double.parseDouble(case_base.get(ii).get(n1))) 
                            /(maxvalue[ii] - minvalue[ii]));
                    
                   // Local_Sem.get(ii).add(n1,Double.toString(ls) );
                    // GS[i (0 to 14)] = Local_Sem.get(i).get(j) + Local_Sem.get(i).get(j)) /8;
                }n++;
            }
        int j =0;
        
        
        
    }
    
}
