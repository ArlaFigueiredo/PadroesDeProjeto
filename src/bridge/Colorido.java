package bridge;

public class Colorido implements VersaoIF {

	@Override
	public double calculaPreco(double preco) {
		return preco += preco*0.05;
	}
	
}
