package factory;

import model.ProdutoIF;
import model.Disciplina;


public class DisciplinaFactory extends ProdutoFactory {
	
	@Override
	public ProdutoIF createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}