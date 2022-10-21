package ex1;

public class StackChar_1 <T>{
    private int size;
    private Object stk[];
    private int position;
    public StackChar_1(int size){
        this.size = size;
        position=0;
        stk= new Object[size];
    }

    public void push(char letter){
        if(position<size){
            stk[position] = letter;
            position++;
        }else{
            System.out.println("Stack is full");
        }
    }

    public Object pop(){
        if(size<=0){
            System.out.println("FIfo is empty");
            return ' ';
        }
        position--;
        Object read = stk[position];
        return read;
    }

    public int size(){
        return stk.length;
    }
}