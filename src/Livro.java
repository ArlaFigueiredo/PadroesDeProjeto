
public class Livro extends Produto implements ProdutoIF{
	
	private String isbn;
	
	public Livro() {}
	
	public Livro(String codigo, String nome) {
		this.setNome(nome);
		this.setCodigo(codigo);
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
