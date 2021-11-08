
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

	@Override
	public void ajustarProduto(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setIsbn(null);
	}

	@Override
	public String getDetalhes() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo()
						+ "/ ISBN: "+ this.getIsbn();
		return detalhes;
	}

}
