package bridge;

public class CapaDura implements VersaoIF {
	
	private final static double percentualReajuste = 1.2;
	
	public double calculaPreco(double preco) {
		return preco *= percentualReajuste;
	}

	public String toString() {
		return "CAPA DURA";
	}
}
