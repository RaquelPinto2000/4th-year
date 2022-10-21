package ex1;
import java.util.*;

public class ex1 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("String: ");
        String a = input.nextLine();
        StackChar sn = new StackChar(a.length());
        Fifo f = new Fifo(a.length());
        
        for (int i =0;i<a.length();i++){
            sn.push(a.charAt(i));
            f.insert(a.charAt(i));
        }      
        boolean b = true;
        for(int i = 0;i<sn.size();i++){
            char ch = sn.pop();
            char ch1 = f.remove();
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
