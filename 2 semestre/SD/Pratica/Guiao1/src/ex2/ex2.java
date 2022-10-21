package ex2;
import java.util.*;

import ex2.StackChar_abs1;
import ex2.StackChar_abstrac1;

public class ex2 {     
	public static int N;
	
	public static StackChar_abstrac1<Object>[] tower = new StackChar_abs1[4];
    public static void main (String[] args){
    	int n = 4; // Number of disks
    	// 3 torres
    	tower[1] = new StackChar_abs1<Object>(n);
    	tower[2] = new StackChar_abs1<Object>(n);
    	tower[3] = new StackChar_abs1<Object>(n);
    	
    	
    	//inicializacao
    	for(int d = n; d > 0; d--) {
    		tower[1].push(d);
    	}
    	System.out.println("Inicial state");
    	N=n;
    	display(); 
    	
    	System.out.println("Game");
    	move(n,1,2,3);
        //towerOfHanoi(n, \'A\', \'C\', \'B\');  
    }
    
    //recursivo para mover
    public static void move(int n, int a, int b, int c ) {
        
        if (n > 0)

        {

            move(n-1, a, c, b);     

            Object d = tower[a].pop();                                             

            tower[c].push(d);

            display();                   

            move(n-1, b, a, c);     

        }             
    }
    
   
   public static void display(){

        System.out.println("  A	|	B	|	C");
        System.out.println("--------------------------------------");

        for(int i = N - 1; i >= 0; i--){
        	System.out.println("  "+tower[1].get(i)+"	|	"+tower[2].get(i)+"	|	"+tower[3].get(i));
        }

        System.out.println("\n");         

    }
    
    
    
}