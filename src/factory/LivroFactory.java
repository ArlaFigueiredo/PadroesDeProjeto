package factory;

import model.ProdutoIF;
import model.Livro;

public class LivroFactory extends ProdutoFactory {
	
	public LivroFactory() {
		super();
	}
		
	public ProdutoIF createProduto() {
		return new Livro();
	}
}
