package bridge;

public class Digital implements VersaoIF {
	
	private final static double percentualReajuste = 0.85;
	
	public double calculaPreco(double preco) {
		return preco *= percentualReajuste;
	}
	
	public String toString() {
		return "DIGITAL";
	}

}
