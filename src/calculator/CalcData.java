package calculator;

public class CalcData {

    private int arab1;
    private int arab2;
    private String oper;
    private String numSys;
    private int result;

    public CalcData(){

    }

    public CalcData(int arab1, int arab2, String oper, String numSys){
        this.arab1=arab1;
        this.arab2=arab2;
        this.oper=oper;
        this.numSys=numSys;
    }
    public int getNum1(){
        return this.arab1;
    }

    public int getNum2(){
        return this.arab2;
    }

    public String getOper(){
        return this.oper;
    }

    public String getNumSys(){
        return this.numSys;
    }

    public int getResult(){
        return this.result;
    }

    public int calculate() {
        int num1=this.arab1;
        int num2=this.arab2;
        String oper = this.oper;

        switch(oper){
            case"+": return num1+num2;
            case"-": return num1-num2;
            case"*": return num1*num2;
            case"/": return num1/num2;
        }
    return 0;    
    }
}
