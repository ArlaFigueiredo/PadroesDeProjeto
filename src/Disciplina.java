
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

	@Override
	public void ajustarProduto(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCargaHoraria(0);
		this.setPercentualCumprido(0);
	}
	
	public void reset() {
		this.setPercentualCumprido(0);
	}
	
	@Override
	public String getDetalhes() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo()
						+ "/ CH.Total: "+ this.getCargaHoraria()
						+ "/ %CH.Cumprida: "+ this.getPercentualCumprido();
		return detalhes;
	}
	
	public String toString() {
		StringBuilder dadosDisciplinas = new StringBuilder();
			dadosDisciplinas.append("Codigo: ");
			dadosDisciplinas.append(this.getCodigo());
			dadosDisciplinas.append(" Nome: ");
			dadosDisciplinas.append(this.getNome());
			dadosDisciplinas.append(" Carga Horaria: ");
			dadosDisciplinas.append(this.getCargaHoraria());
			dadosDisciplinas.append('\n');
		return dadosDisciplinas.toString();
	}
}
