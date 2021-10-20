
public abstract class AbstractProdutoFactory implements ProdutoFactoryIF{
	
	protected String codigo;
	protected String nome;
	
	public AbstractProdutoFactory() {
		super();
	}

	public AbstractProdutoFactory(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
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
