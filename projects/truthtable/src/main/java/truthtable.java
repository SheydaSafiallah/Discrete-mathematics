import java.util.*;
/**
 *
 * @author Sheyda
 */
public class truthtable {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input1, input2, input3;
        int amalvandCount = 0;
        char amalvandha[] = new char[3];
        //faqat 3 amalvand
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //faqat p/q/r qabele qabol ast
        //check input(Operands)
        if(input.contains("p")){
            amalvandha[amalvandCount++]='p';
        }
        if(input.contains("q")){
            amalvandha[amalvandCount++]='q';
        }
        if(input.contains("r")){
            amalvandha[amalvandCount++]='r';
        }
        
        //ba tavajoh be tedade amalvandha, print jadval+arzeshe har gozare
        switch(amalvandCount){
            
            
            case 0:
                System.out.println("Hich amalgari vared nashode...");
                break;
                
                
            case 1:
                System.out.println(amalvandha[0]+"     ||     "+input);
                for(int i=0;i<2;i++){
                    input1=input.replaceAll(String.valueOf(amalvandha[0]),String.valueOf(i));
                    System.out.println("============================");
                    System.out.println(i+"     ||     "+checkInput(input1));
                }
                break;
                
                
            case 2:
                System.out.println(amalvandha[0]+"     ||     "+amalvandha[1]+"     ||     "+input);
                for(int i=0;i<2;i++){
                    input1=input.replaceAll(String.valueOf(amalvandha[0]),String.valueOf(i));
                    for(int j=0;j<2;j++){
                        input2=input1.replaceAll(String.valueOf(amalvandha[1]),String.valueOf(j));
                        System.out.println("=======================================");
                        System.out.println(i+"     ||     "+j+"     ||     "+checkInput(input2));
                    }
                }
                break;
                
                
            case 3:
                System.out.println(amalvandha[0]+"     ||     "+amalvandha[1]+"     ||     "+amalvandha[2]+"     ||     "+input);
                for(int i=0;i<2;i++){
                    input1=input.replaceAll(String.valueOf(amalvandha[0]),String.valueOf(i));
                    for(int j=0;j<2;j++){
                        input2=input1.replaceAll(String.valueOf(amalvandha[1]),String.valueOf(j));
                        for(int k=0;k<2;k++){
                            input3=input2.replaceAll(String.valueOf(amalvandha[2]),String.valueOf(k));
                            System.out.println("===============================================");
                            System.out.println(i+"     ||     "+j+"     ||     "+k+"     ||     "+checkInput(input3));
                        }
                    }
                }
                break;
                
            default:
                break;
        }
    }
    
    
    
    public static int checkInput(String input) {
        
        int arzeshGozare=1;
        int naqiz=0;
        int operation=0;//0=and 1=or 2=xor
        int expected=0;//0=num 1=oprand
        
        for(int i=0;i<input.length();i++) {
            if(expected==0) {
                switch(input.charAt(i)){
                    case '~':
                        naqiz=1;
                        break;
                        
                    case '0':
                    case '1':
                        if (naqiz == 1) {
                            arzeshGozare = LogicalOperation(arzeshGozare, ~Integer.parseInt(String.valueOf(input.charAt(i))), operation);
                        } else {
                            arzeshGozare = LogicalOperation(arzeshGozare, Integer.parseInt(String.valueOf(input.charAt(i))), operation);
                        }   naqiz = 0;
                        expected = 1;
                        break;
                        
                    case '(':
                        if (naqiz == 1) {
                            arzeshGozare = LogicalOperation(arzeshGozare, ~checkInput(input.substring(i + 1, input.lastIndexOf(")"))), operation);
                        } else {
                            arzeshGozare = LogicalOperation(arzeshGozare, checkInput(input.substring(i + 1, input.lastIndexOf(")"))), operation);
                        }
                        i = input.lastIndexOf(")");
                        naqiz = 0;
                        expected = 1;
                        break;
                        
                    default:
                        return -1;
                }
                
            } else if(expected==1){
                switch(input.charAt(i)){
                    case '&':
                        operation=0;
                        expected=0;
                        break;
                        
                    case '|':
                        operation=1;
                        expected=0;
                        break;
                        
                    case '^':
                        operation=2;
                        expected=0;
                        break;
                        
                    default:
                        return -1;
                }
            }
        }
        return arzeshGozare;
    }
    
    
    
    public static int LogicalOperation(int x,int y,int operation) {//anjam amaliate manteqi
        switch(operation){
            case 0://0=and
                return x&y;
                
            case 1://1=or
                return x|y;
                
            case 2://2=xor
                return (x|y)&(~x|~y);
                
            default:
                break;
        }
        return -1;
    }
}
