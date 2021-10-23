
public abstract class ProdutoFactory {
	
	protected String codigo;
	protected String nome;
	
	public ProdutoFactory() {}

	public ProdutoFactory(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	
	public abstract ProdutoIF createProduto();
	
	public ProdutoIF getProduto(String codigo, String nome) {
		ProdutoIF produto = this.createProduto();
		produto.setProduto(codigo, nome);
		return produto;
	}
	
	public ProdutoIF getProduto() {
		ProdutoIF produto = this.createProduto();
		produto.setProduto(this.getCodigo(),this.getNome());
		return produto;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
