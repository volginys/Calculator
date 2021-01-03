/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import java.util.Scanner;
/**
 *
 * @author User
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        do{
            try{
                Computer comp = new Computer();
                comp.inputNums();
                comp.outputResult();
            }catch(Exception ex){
                System.out.println("Incorrect input ("+ex.getMessage()+")\n");
            }
        }while(true); 
    }    
}



