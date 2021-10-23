
public abstract class ProdutoFactory {
	
	protected String codigo;
	protected String nome;
	
	public ProdutoFactory() {
		super();
	}

	public ProdutoFactory(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public abstract void speak();
	
	public abstract ProdutoIF createProduto();
	
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
