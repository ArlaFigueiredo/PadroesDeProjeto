package factory;

import model.Produto;
import model.Disciplina;


public class DisciplinaFactory extends ProdutoFactory {
	
	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
