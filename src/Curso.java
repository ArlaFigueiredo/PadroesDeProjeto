import java.util.List;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.livros = livros;
		this.disciplinas = disciplinas;
	}
	
	public int getChTotal() {
		int CHTotal = 0;
		for(Disciplina disciplina : disciplinas)
			CHTotal += disciplina.getCargaHoraria();
		
		return CHTotal;
	}
	
	public double getChCumprida() {
		int pctCumprido = 0;
		int iCount = 0;
		for(Disciplina disciplina : disciplinas)
            pctCumprido += disciplina.getPercentualCumprido();
			iCount += 1;
		
		return pctCumprido/iCount;
	}

	@Override
	public Prototipavel prototipar() {
		Curso novoCurso = this;
		for(Disciplina disciplina : novoCurso.disciplinas)
            disciplina.reset();
		return novoCurso;
	}

	public Ementa buildEmenta() {
		
		EmentaBuilder builder = new EmentaBuilder();
		for(Disciplina disciplina : this.disciplinas)
			builder.addDisciplinas(disciplina);
		for(Livro livro : this.livros)
			builder.addLivros(livro);
		builder.setCodigo(this.getCodigo());
		builder.setNome(this.getNome());
		Ementa ementa = builder.build();
		return ementa;
	}
	
	@Override
	public double getPreco() {
		return this.preco;
	}

	@Override
	public void ajustarProduto(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	
	@Override
	public String getDetalhes() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo();
		return detalhes;
	}
}
