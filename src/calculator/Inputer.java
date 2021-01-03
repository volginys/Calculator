/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author User
 */
public class Inputer {
    private String line;
    private char oper;


    public void setLine() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Input : ");
        this.line = in.nextLine();
    }
    public String getLine(){
        return this.line;
    }

    public String[] getOper(String line) throws Exception{
        String[] array ={"","",""};
        String oper;
        String line1 = line.trim();

        for(int i=0; i<line1.length(); i++){
            oper = line1.substring(i,i+1);
            if (oper.matches("[+-/*]{1}")) {
                if ((i==0)&&(oper.matches("[-]{1}"))){
                    throw new Exception("Выход числа за диапозон (используйте числа от 1 до 10), либо отсутствие первого числа");
                }
                array[0] = line1.substring(0,i);
                array[1] = oper;
                array[2] = line1.substring(i+1);
                if (i==(line1.length()-1)){
                    throw new Exception("Отсутствие второго числа");
                }
                break;
            }
        }
        array[0] = array[0].trim();
        array[2] = array[2].trim();
        return array;
    }

    public CalcData analizeNums (String[] array) throws Exception{
        int arab1=0;
        int arab2=0;
        String numSys="";

        if(!array[1].matches("[+-/*]{1}")){
            throw new Exception("Для расчета введите два числа и операцию + - / или *");
        }
        for(RomeNumb num: RomeNumb.values()){
            if(array[0].equalsIgnoreCase(num.name())){
                arab1=num.getArab();
            }
            if(array[2].equalsIgnoreCase(num.name())){
                arab2=num.getArab();
            }
            if(arab1!=0 && arab2!=0 && !numSys.equals("rome")){
                numSys="rome";
            }
        }
        System.out.println(array[0]);
        System.out.println(array[2]);
        
        
        if(!numSys.equals("rome")){
            arab1=Integer.parseInt(array[0]);
            arab2=Integer.parseInt(array[2]);
            numSys="arab";
        }

        if((arab1<1 | arab1>10)|(arab2<1 | arab2>10)) {
            throw new Exception("Выход числа за диапозон (используйте числа от 1 до 10)");
        }
        return new CalcData(arab1, arab2, array[1], numSys);
    }
}
