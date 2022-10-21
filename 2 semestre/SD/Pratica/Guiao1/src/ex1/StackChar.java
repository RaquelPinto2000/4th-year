package ex1;

public class StackChar {
    private int size;
    private char stk[];
    private int position;
    public StackChar(int size){
        this.size = size;
        position=0;
        stk= new char[size];
    }

    public void push(char letter){
        if(position<size){
            stk[position] = letter;
            position++;
        }else{
            System.out.println("Stack is full");
        }
    }

    public char pop(){
        if(size<=0){
            System.out.println("FIfo is empty");
            return ' ';
        }
        position--;
        char read = stk[position];
        return read;
    }

    public int size(){
        return stk.length;
    }
}