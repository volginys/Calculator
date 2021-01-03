/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import java.io.IOException;
/**
 *
 * @author User
 */
public class Computer{
    private CalcData calcData;
    
    public Computer(){

    }

    public Computer(CalcData calcData){
        this.calcData = calcData;
    }

    public void inputNums() throws IOException,Exception{      
        String[] parsedInput;
        Inputer inputer = new Inputer();
        inputer.setLine();
        if(inputer.getLine().equals("exit")) System.exit(0);
        String[] num = inputer.getOper(inputer.getLine());
        this.calcData = inputer.analizeNums(num);

    }
    

    public int calculate() {
        int num1=this.calcData.getNum1();
        int num2=this.calcData.getNum2();
        String oper = this.calcData.getOper();

        switch(oper){
            case"+": return num1+num2;
            case"-": return num1-num2;
            case"*": return num1*num2;
            case"/": return num1/num2;
        }
    return 0;           
    }

    public String arabToRome(int arab){
        int dozens; 
        String rome = "";
        
        dozens = arab/10;        
        if(dozens>0){
            for(RomeNumb num: RomeNumb.values()) if (num.getArab()==dozens*10) rome+=num.name();
            arab = arab - dozens*10;
        }        
        for(RomeNumb num: RomeNumb.values()) if (num.getArab()==arab) rome+=num.name();
        return rome;
    }    

    public void outputResult() throws Exception{
        if(this.calcData.getNumSys() == "rome"){
            if(this.calcData.calculate()<=0){
                throw new Exception("Римское число не может быть меньше 'I', первое число должно быть больше второго ");
            }else{
                System.out.println("Result: "+arabToRome(calculate())); 
            }
        } else{
            System.out.println("Result: "+calculate());
        }
    } 
}