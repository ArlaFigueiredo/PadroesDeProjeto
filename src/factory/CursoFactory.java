package factory;

import model.Produto;
import model.Curso;


public class CursoFactory extends ProdutoFactory{
	
	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
