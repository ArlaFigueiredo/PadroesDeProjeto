
public class DisciplinaFactory extends ProdutoFactory {

	public DisciplinaFactory() {
		super();
	}
	
	public DisciplinaFactory(String codigo, String nome) {
		super(codigo, nome);
	}

	public ProdutoIF createProduto() {
		return new Disciplina(this.codigo, this.nome);
	}

}
