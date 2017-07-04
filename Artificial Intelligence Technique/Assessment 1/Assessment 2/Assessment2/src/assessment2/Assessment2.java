/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * NUR SYUHAIDAH BINTI ISMAIL
 * CB13006
 */

package assessment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assessment2 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<ArrayList<String>> case_base= new ArrayList<ArrayList<String>>();
        static ArrayList<ArrayList<String>> new_case= new ArrayList<ArrayList<String>>();
        static double[] maxvalue=new double[8];
        static double[] minvalue=new double[8];
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        for(int i=0;i<9;i++){
        case_base.add(new ArrayList<String>());
        }
        File file=new File("case-base(A&B).txt");
        Scanner data=new Scanner(file);
        while(data.hasNextLine()){
            for(int i=0;i<9;i++){
            case_base.get(i).add(data.next());
            }
        }
        
        for(int jj=0;jj<case_base.size()-1;jj++){
            double max=0.0;
            for(int ii=0;ii<case_base.get(jj).size();ii++){
                if(Double.parseDouble(case_base.get(jj).get(ii))>=max){
                    maxvalue[jj]=Double.parseDouble(case_base.get(jj).get(ii));
                max=maxvalue[jj];
                }
            }
        }
        
        for(int j=0;j<case_base.size()-1;j++){
            double min=10000.0;
            for(int ii=0;ii<case_base.get(j).size();ii++){
                if(Double.parseDouble(case_base.get(j).get(ii))<=min){
                    minvalue[j]=Double.parseDouble(case_base.get(j).get(ii));
                    min=minvalue[j];
                }
            }
        }
        
        //for new problem class
        for(int k=0;k<9;k++){
        new_case.add(new ArrayList<String>());
        }
        File prob=new File("clarify new-case.txt");
        Scanner newprob=new Scanner(prob);
        while(newprob.hasNextLine()){
            for(int k=0;k<9;k++){
            new_case.get(k).add(newprob.next());
            }   
        }
        
        
        //declare for local and global similarity
        double[][][] localsim=new double[4][16][8];
        double[][] globalsim=new double[4][16];
        double[] weight=new double[16];
        
        //set the weight attribute
        for(int a=0;a<case_base.size()-1;a++){
        weight[a]=1;
        }

        //count local similarity
        System.out.println("---------------------------LOCAL SIMILARITY------------------------------");
        for(int j=0;j<4;j++){
            for(int ii=0;ii<16;ii++){
                System.out.println("\n-------------------New Problem "+j+" compare with CaseBase "+ii+"-------------------");
                    for(int i=0;i<8;i++){
                        localsim[j][ii][i]=1-(Math.abs(Double.parseDouble(new_case.get(i).get(j))-Double.parseDouble(case_base.get(i).get(ii)))/(maxvalue[i]-minvalue[i]));
                        // System.out.println("Max value " + maxvalue[i] + "  " +  "Min value " + minvalue[i]);
                        System.out.println("1 - (" + new_case.get(i).get(j)+"-"+ case_base.get(i).get(ii)+")"+ "\t divide by "+(maxvalue[i]-minvalue[i])+" \t= "+localsim[j][ii][i]);
                    }
            }
        System.out.println();
        System.out.println();
        }

        //count global similarity
        System.out.println("---------------------------GLOBAL SIMILARITY------------------------------");
        for(int j=0;j<4;j++){
            System.out.println("-------------------New Problem "+j+"-------------------");
            for(int ii=0;ii<16;ii++){
                double total=0;
                    for(int i=0;i<8;i++){
                        total=total+(weight[i]*localsim[j][ii][i]);
                    }
                    globalsim[j][ii]=total*1/8;
                    System.out.println(globalsim[j][ii]);
            }
        System.out.println();
        System.out.println();
        }

        //find out the class for new problem
        int[] index=new int[8];
        String[] casebase = new String[100];
        String[] newclass = new String[100];
        
        //take the maximum value
        for(int j=0;j<4;j++){
        maxvalue[j]=globalsim[j][0];
            for(int ii=0;ii<16;ii++){
                if(globalsim[j][ii]>maxvalue[j]){
                maxvalue[j]=globalsim[j][ii];
                index[j]=ii;
                casebase[index[j]]=case_base.get(8).get(ii);
                }
            }
        newclass[j]=casebase[index[j]];
        }
        
        //print out result
        for(int a=0;a<new_case.get(a).size();a++){
            System.out.println("The class for new problem "+a+" is "+newclass[a]);
        }
    }
}