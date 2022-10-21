package ex3;

//realizar operacoes de + - e * nao negativos
public class Operations {
    private double operation1;
    private double operation2;
    
    public Operations(double operation1, double operation2){
    	if(operation1<0) {
    		operation1 = -operation1;
    		System.out.println("Operator 1 must be positive-> " + operation1);
    	}
    	if (operation2<0) {
    		operation2 = -operation2;
    		System.out.println("Operator 2 must be positive-> " + operation2);
    	}
    	
    	this.operation1 = operation1;
    	this.operation2=operation2;
    	
    }

    public double add(){
    	return operation1+operation2;
    }
    
    public double sub(){
    	return operation1-operation2;
    }
    
    public double mult(){
    	return operation1*operation2;
    }
    
	public double getOperation1() {
		return operation1;
	}

	public void setOperation1(double operation1) {
		this.operation1 = operation1;
	}

	public double getOperation2() {
		return operation2;
	}

	public void setOperation2(double operation2) {
		this.operation2 = operation2;
	}

	@Override
	public String toString() {
		return "operations [operation1=" + operation1 + ", operation2=" + operation2 + "]";
	}
	
	
	
    
}