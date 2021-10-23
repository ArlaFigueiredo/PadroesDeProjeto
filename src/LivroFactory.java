
public class LivroFactory extends ProdutoFactory {
		
	public LivroFactory(String codigo, String nome) {
		super(codigo, nome);
	}
		
	public ProdutoIF createProduto() {
		return new Livro(this.codigo, this.nome);
	}
}
