package bridge;

public class Colorido implements VersaoIF {
	
	private final static double percentualReajuste = 1.05;
	
	@Override
	public double calculaPreco(double preco) {
		return preco *= percentualReajuste;
	}
	
	public String toString() {
		return "COLORIDO";
	}
	
}
