import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	public class Situacao {
			
			private Curso curso;
			
			private List<Livro> livros;
			private List<Disciplina> disciplinas;
			
			//MEMENTO em um Memento
			private Situacao(Curso curso, 
							 List<Livro> livros,
							 List<Disciplina> disciplinas) {
				
				this.curso = curso;
				
				this.disciplinas = new ArrayList<Disciplina>();
				for(Disciplina d : disciplinas)
					this.disciplinas.add((Disciplina)d.prototipar());
				this.livros = new ArrayList<Livro>();
				for(Livro l : curso.livros)
					this.livros.add((Livro)l.prototipar());
			}
			
			private void restore() {
				this.curso.setLivros(livros);
				this.curso.setDisciplinas(disciplinas);
			}
			
			public String toString() {
				StringBuilder dadosDisciplinas = new StringBuilder();
					dadosDisciplinas.append("Disciplina: ");
					dadosDisciplinas.append(this.disciplinas);
					dadosDisciplinas.append('\n');
				return dadosDisciplinas.toString();
			}
		}	
	
	
	private List<CheckpointObserver> observers;
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setLivros(livros);
		this.setDisciplinas(disciplinas);
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
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
	
	public double getPreco() {
		return this.preco;
	}

	public void ajustarProduto(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setLivros(null);
		this.setDisciplinas(null);
	}
	
	public String getDetalhes() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo();
		return detalhes;
	}
	
	public void avancar(String nomeDisciplina, double percentual) {
		for(Disciplina disciplina : this.disciplinas) {
			if(nomeDisciplina.equalsIgnoreCase(disciplina.getNome())){
				disciplina.setPercentualCumprido(percentual + disciplina.getPercentualCumprido());
			}
		}
	}
	
	public Situacao getCheckpoint() {
		return new Situacao(this, this.livros, 
							this.disciplinas);
	}
	
	public void restore(Situacao snapshot) {
		snapshot.restore();
	}
	
	public void attachStateChangedObserver(CheckpointObserver observer) {
		this.observers.add(observer); 
	}
	
	public void detachStateChangedObserver(CheckpointObserver observer) {
		this.observers.remove(observer); 
	}
	
	public void fireStateChangedEvent(String tipoCheckpoint, List<Disciplina> disciplinas) {
		for(CheckpointObserver observer : this.observers)
			observer.notifyStateChanged(new CheckpointChangedEvent(tipoCheckpoint, disciplinas));
	}
}
