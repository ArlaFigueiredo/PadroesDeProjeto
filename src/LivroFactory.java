
public class LivroFactory extends AbstractProdutoFactory implements ProdutoFactoryIF{
	public LivroFactory() {
		super();
	}
	
	
	public LivroFactory(String codigo, String nome) {
		super(codigo, nome);
	}
	
	
	@Override
	public ProdutoIF getProduto() {
		return new Livro(this.codigo, this.nome);
	}
}
