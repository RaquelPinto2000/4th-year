package ex1;

public class Fifo_1 <T>{
    private int size;
    private Object stk[];
    private int position;


    public Fifo_1(int size){
        this.size = size;
        position=0;
        stk= new Object[size];
    }

    public void insert(char letter){
        if(position<size){
            stk[position++] = letter;
        }else{
            System.out.println("FIFO is full");
            return;
        }
    }

    public Object remove(){
        if(size<=0){
            System.out.println("FIFO is empty");
            return ' ';
        }

        Object read = stk[0];
        for (int i = 0;i<size-1;i++){
            stk[i]= stk[i+1];
        }
        position--;
        return read;
    }
}