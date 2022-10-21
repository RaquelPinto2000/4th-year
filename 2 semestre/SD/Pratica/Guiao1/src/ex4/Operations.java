package ex4;

//realizar operacoes de + - e * em virgula flutuante com dupla precisao, reais e complexos (negativos ou positivos)
public class Operations {
    private double operation1;
    private double operation2;
    private String[] ncomp1; //numero do n complexo - posicao 0 , numero do i do complexo - posicao 1
    private String[] ncomp2; //numero do n complexo - posicao 0 , numero do i do complexo - posicao 1
    
  //b diz se e complexo (true) ou nao (false) -> se complexo n1 n2 
    public Operations(String operation1, String operation2, boolean b){ 
    	ncomp1 = new String [2];
    	ncomp2 = new String [2];
    	
    	if(b){
    		complex(operation1,operation2,b);
    	}else{
    		this.operation1 = Double.parseDouble(operation1);
            this.operation2 = Double.parseDouble(operation2);        	
    	} 	
    	
    }
    
    private void complex(String operation1, String operation2,boolean b) {
    	for (int i = 0;i<operation1.length();i++) {
			for( int j = 0;j<2;j++) {
    			char a  =operation1.charAt(i);
    			if(Character.isDigit(a) && ncomp1[j]==null) {
    				ncomp1[j] = "" +a;
    				break;
    				
    			}
			}
		}
		
		
		for (int i = 0;i<operation2.length();i++) {
			for( int j = 0;j<2;j++) {
    			char a  =operation2.charAt(i);
    			if(Character.isDigit(a) && ncomp2[j]==null) {
    				ncomp2[j] = "" +a;
    				break;
    			}
			}
		}
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
    
    
    public String addComp() {
    	double ope1Aux1 = Double.parseDouble(ncomp1[0]);
    	double ope2Aux1 = Double.parseDouble(ncomp1[1]);
    	double ope1Aux2 = Double.parseDouble(ncomp2[0]);
    	double ope2Aux2 = Double.parseDouble(ncomp2[1]);
    	
    	double result1 = ope1Aux1 + ope1Aux2;
    	double result2 = ope2Aux1 + ope2Aux2;
    	return result1 + " + " + result2;
    }
    public String subComp(){
    	double ope1Aux1 = Double.parseDouble(ncomp1[0]);
    	double ope2Aux1 = Double.parseDouble(ncomp1[1]);
    	double ope1Aux2 = Double.parseDouble(ncomp2[0]);
    	double ope2Aux2 = Double.parseDouble(ncomp2[1]);
    	
    	double result1 = ope1Aux1 - ope1Aux2;
    	double result2 = ope2Aux1 - ope2Aux2;
    	return result1 + " - " + result2;
    }
    
    public String multComp(){
    	double ope1Aux1 = Double.parseDouble(ncomp1[0]);
    	double ope2Aux1 = Double.parseDouble(ncomp1[1]);
    	double ope1Aux2 = Double.parseDouble(ncomp2[0]);
    	double ope2Aux2 = Double.parseDouble(ncomp2[1]);
    	
    	double result1 = ope1Aux1 * ope1Aux2;
    	double result2 = ope2Aux1 * ope2Aux2;
    	return result1 + " * " + result2;
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