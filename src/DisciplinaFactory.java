
public class DisciplinaFactory extends AbstractProdutoFactory implements ProdutoFactoryIF{

	public DisciplinaFactory() {
		super();
	}
	
	
	public DisciplinaFactory(String codigo, String nome) {
		super(codigo, nome);
	}
	
	
	@Override
	public ProdutoIF getProduto() {
		return new Disciplina(this.codigo, this.nome);
	}

}
