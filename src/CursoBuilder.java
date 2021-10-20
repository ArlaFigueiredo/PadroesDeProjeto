import java.util.Map;

public class CursoBuilder {

	private Map<TipoProduto, ProdutoIF> produtos;  

	
	public CursoBuilder() {
	}
	
	public void put(TipoProduto tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		DisciplinaFactory factory = (DisciplinaFactory) (Class.forName(tipo.getFactoryName()).newInstance());
		ProdutoIF produto = factory.getProduto();
		this.produtos.put(tipo, produto);
	}
	
	public ProdutoIF get(TipoProduto tipo) {
		ProdutoIF produto = this.produtos.get(tipo);
		return (ProdutoIF) produto;
	}
	
}
