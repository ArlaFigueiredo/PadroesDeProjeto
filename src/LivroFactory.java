
public class LivroFactory extends ProdutoFactory {
	public LivroFactory() {
		super();
	}
	
	
	public LivroFactory(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public void speak() {
		System.out.println("EU AMO LIVROS");
	}
	
	
	public ProdutoIF createProduto() {
		return new Livro(this.codigo, this.nome);
	}
}
