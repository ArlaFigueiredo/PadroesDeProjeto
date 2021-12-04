
public abstract class Produto implements ProdutoIF, Prototipavel{
	
	private String codigo;
	private String nome;
	protected double preco;
	
	public Produto() {}
	
	public Produto(Produto produto) {
		this.codigo = produto.codigo;
		this.nome = produto.nome;
	}
	
	public abstract double getPreco();
	
	public abstract void ajustarProduto(String codigo, String nome);
	
	public abstract String getDetalhes();
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
