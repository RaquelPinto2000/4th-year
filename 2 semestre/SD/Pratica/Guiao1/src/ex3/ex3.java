package ex3;
import java.util.*;


public class ex3 {     

    public static void main (String[] args){
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.print("First operator: ");
    	double operator1 = in.nextDouble();
    	System.out.print("Second operator: ");
    	double operator2 = in.nextDouble();
    	System.out.print("Operation: ");
    	String operation = in.next();
    	
    	Operations op  =new Operations(operator1,operator2);
    	
    	double result = 0;
    	if(operation.equals("+")) {
    		result = op.add();
    	}else if(operation.equals("*")) {
    		result = op.mult();
    	}else if(operation.equals("-")) {
    		result = op.sub();
    	}
    	
    	System.out.println("Result = " + result);
    	in.close();
    }
    
    
    
}