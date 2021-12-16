package bridge;

public class Digital implements VersaoIF {
	
	@Override
	public double calculaPreco(double preco) {
		return preco -= preco * 0.15;
	}

}
