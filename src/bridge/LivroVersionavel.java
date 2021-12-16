package bridge;

import model.Livro;

public class LivroVersionavel extends Livro{
	
	public LivroVersionavel(String codigo, String nome, String isbn, double preco, VersaoIF versao) {
		super(codigo, nome, isbn, preco, versao);
	}
	
	public double calculaPrecoVersao() {
		return this.getVersao().calculaPreco(this.getPreco());
	}

}
