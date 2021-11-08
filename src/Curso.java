import java.util.List;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private Ementa ementa;
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.livros = livros;
		this.disciplinas = disciplinas;
	}
	
	public void setEmenta() {
		this.ementa = new Ementa(this.getNome(),this.getCodigo(),this.disciplinas);
	}
	
	public Ementa getEmenta() {
		return this.ementa;
	}
	
	public int getChTotal() {
		int CHTotal = 0;
		for(Disciplina disciplina : disciplinas)
			CHTotal += disciplina.getCargaHoraria();
		
		return CHTotal;
	}
	
	public int getChCumprida() {
		int pctCumprido = 0;
		for(Disciplina disciplina : disciplinas)
            pctCumprido += disciplina.getPercentualCumprido();
		
		return pctCumprido;
	}

	@Override
	public Prototipavel prototipar() {
		Curso novoCurso = this;
		for(Disciplina disciplina : novoCurso.disciplinas)
            disciplina.reset();
		return novoCurso;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}

	@Override
	public void ajustarProduto(String codigo, String nome) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getDetalhes() {
		// TODO Auto-generated method stub
		return null;
	}
}
