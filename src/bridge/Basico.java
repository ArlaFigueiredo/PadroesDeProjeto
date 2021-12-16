package bridge;

public class Basico implements VersaoIF{
	
	@Override
	public double calculaPreco(double preco) {
		return preco;
	}
	
	public String toString() {
		return "BASICO";
	}
	
}
