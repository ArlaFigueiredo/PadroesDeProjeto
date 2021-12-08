package factory;

import model.ProdutoIF;
import model.Livro;


public class LivroFactory extends ProdutoFactory {
	
	@Override
	public ProdutoIF createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}
}
