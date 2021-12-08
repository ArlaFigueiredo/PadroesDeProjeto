package model;

import java.util.ArrayList;
import prototype.Prototipavel;
import java.util.List;
import observer.CheckpointNotifyEvent;
import observer.CheckpointObserver;
import state.AtivoState;
import state.CursoState;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	public class Situacao {
			
		private Curso curso;
		private List<Livro> livros;
		private List<Disciplina> disciplinas;
		
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
	}	
	
	
	private List<CheckpointObserver> observers;
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private CursoState state;
	
	private Curso(Curso curso) {
		super(curso);
		this.disciplinas = new ArrayList<Disciplina>();
		for(Disciplina d : curso.disciplinas)
			this.disciplinas.add((Disciplina)d.prototipar());
		this.livros = new ArrayList<Livro>();
		for(Livro l : curso.livros)
			this.livros.add((Livro)l.prototipar());
		this.observers = new ArrayList<CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new ArrayList<Disciplina>();
		this.livros = new ArrayList<Livro>();
		this.observers = new ArrayList<CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		super(codigo, nome);
		this.setLivros(livros);
		this.setDisciplinas(disciplinas);
		this.observers = new ArrayList<CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = new ArrayList<Livro>(livros);
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = new ArrayList<Disciplina>(disciplinas);
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
	
	public double getPreco() {
		return 0;
	}

	public Prototipavel prototipar() {
		Curso novoCurso = new Curso(this);
		for(Disciplina disciplina : novoCurso.disciplinas)
            disciplina.reset();
		return novoCurso;
	}
	
	public String toString() {
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
		Situacao checkpoint = new Situacao(this, this.livros, this.disciplinas);
		this.fireCheckpointEvent("OCORRENCIA", this.disciplinas);
		return checkpoint;
		//this.state.getCheckpoint(this);
	}
	
	public void restore(Situacao snapshot) {
		snapshot.restore();
		this.fireCheckpointEvent("RESTAURAÇÃO", this.disciplinas);
		//this.state.restore(snapshot);
	}
	
	public void addObserver(CheckpointObserver observer) {
		this.observers.add(observer); 
	}
	
	public void removeObserver(CheckpointObserver observer) {
		this.observers.remove(observer);
	}
	
	public void fireCheckpointEvent(String tipoCheckpoint, List<Disciplina> disciplinas) {
		for(CheckpointObserver observer : this.observers)
			observer.notifyCheckpoint(new CheckpointNotifyEvent(tipoCheckpoint, disciplinas));
	}
}
