package ex1;
import java.util.*;

public class ex1_1 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("String: ");
        String a = input.nextLine();
        StackChar_1<Object> sn = new StackChar_1<Object>(a.length());
        Fifo_1<Object> f = new Fifo_1<Object>(a.length());
        
        for (int i =0;i<a.length();i++){
            sn.push(a.charAt(i));
            f.insert(a.charAt(i));
        }      
        boolean b = true;
        for(int i = 0;i<sn.size();i++){
        	Object ch = sn.pop();
            Object ch1 = f.remove();
            if(ch != ch1){
                System.out.println("This string is not palindrome");
                b=false;
                break;
            }           
        }
        
        if(b==true) {
        	System.out.println("This string is palindrome");
        }
        input.close();
    }
}
