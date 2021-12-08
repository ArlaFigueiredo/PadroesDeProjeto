package factory;

import model.ProdutoIF;
import model.Curso;


public class CursoFactory extends ProdutoFactory{
	
	@Override
	public ProdutoIF createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
