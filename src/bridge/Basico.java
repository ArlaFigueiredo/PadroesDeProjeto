package bridge;

public class Basico implements VersaoIF{
	
	private final static double percentualReajuste = 1;
	
	public double calculaPreco(double preco) {
		return preco *= percentualReajuste;
	}
	
	public String toString() {
		return "BASICO";
	}
	
}
