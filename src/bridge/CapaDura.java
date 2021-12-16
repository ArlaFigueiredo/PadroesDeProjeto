package bridge;

public class CapaDura implements VersaoIF {
	
	@Override
	public double calculaPreco(double preco) {
		return preco += preco * 0.2;
	}

}
