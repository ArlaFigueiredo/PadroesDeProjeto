
public class Disciplina extends Produto implements ProdutoIF{
	
	private int chTotal;
	private double pctCumprido;
	
	public Disciplina() {}
	
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
	
	public void setCargaHoraria(int chTotal) {
		this.chTotal = chTotal;
	}
	
	public void setPercentualCumprido(double pctCumprido) {
		this.pctCumprido = pctCumprido;
	}
}
