
public class Disciplina implements ProdutoIF{
	
	private String codigo;
	private String nome;
	private double preco;
	private int chTotal;
	private double pctCumprido;
	
	public Disciplina(String codigo, String nome) {
		this.setNome(nome);
		this.setCodigo(codigo);
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public int getCargaHoraria() {
		return this.chTotal;
	}
	
	public double getPercentualCumprido() {
		return this.pctCumprido;
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
