
public class DisciplinaFactory extends ProdutoFactory {

	public DisciplinaFactory() {
		super();
	}

	public ProdutoIF createProduto() {
		return new Disciplina();
	}

}
