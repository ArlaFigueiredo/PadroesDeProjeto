
public class LivroFactory extends ProdutoFactory {
	
	public LivroFactory() {
		super();
	}
		
	public ProdutoIF createProduto() {
		return new Livro();
	}
}
