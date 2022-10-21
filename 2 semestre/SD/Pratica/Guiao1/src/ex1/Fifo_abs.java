package ex1;

public class Fifo_abs extends Fifo_abstract {
    
	private int size;
    private char stk[];
    private int position;
    public Fifo_abs(int size) {
		
		this.size = size;
        position=0;
        stk= new char[size];
	}
    @Override
    public void insert(char letter){
        if(position<size){
            stk[position++] = letter;
        }else{
            System.out.println("FIFO is full");
            return;
        }
    }
    @Override
    public char remove(){
        if(size<=0){
            System.out.println("FIFO is empty");
            return ' ';
        }

        char read = stk[0];
        for (int i = 0;i<size-1;i++){
            stk[i]= stk[i+1];
        }
        position--;
        return read;
    }
}