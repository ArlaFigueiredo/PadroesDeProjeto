package factory;

import model.Produto;
import model.Livro;


public class LivroFactory extends ProdutoFactory {
	
	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}
}
