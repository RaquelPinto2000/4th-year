package ex4;
import java.util.*;


public class ex4 {     

    public static void main (String[] args){
    	
    	boolean b;
    	Scanner in = new Scanner(System.in);
    	System.out.print("Complex number? (Y/N): ");
    	String bool = in.nextLine();
    	if(bool.equals("Y") || bool.equals("y")){
    		b=true;	
    	}else {
    		b=false;
    	}
    	
    	System.out.println("First operator: ");
		String soperator1 = in.nextLine();
		System.out.println("Second operator: ");
		String soperator2 = in.nextLine();
    	System.out.println("Operation: ");
    	String operation = in.nextLine();
    	Operations op  = new Operations(soperator1,soperator2,b); 
    	
    	String result = "";
    	if(!b) {
    		if(operation.equals("+")) {
        		result = ""+op.add();
        	}else if(operation.equals("*")) {
        		result = ""+op.mult();
        	}else if(operation.equals("-")) {
        		result = ""+op.sub();
        	}
    	}else {
    		if(operation.equals("+")) {
        		result = op.addComp();
        	}else if(operation.equals("*")) {
        		result = op.multComp();
        	}else if(operation.equals("-")) {
        		result = op.subComp();
        	}
    	}
    	
    	
    	System.out.println("Result = " + result);
    	in.close();
    }
    
    
    
}