package model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import prototype.Prototipavel;
import java.util.List;
import java.util.Map;

import factory.NotificacaoFactory;
import factory.TipoNotificacao;
import memento.Situacao;
import observer.CheckpointNotifyEvent;
import observer.CheckpointObserver;
import state.AtivoState;
import state.CursoState;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	private Map<TipoNotificacao,CheckpointObserver> observers = new HashMap<TipoNotificacao,CheckpointObserver>();
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
		this.observers = new HashMap<TipoNotificacao,CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new ArrayList<Disciplina>();
		this.livros = new ArrayList<Livro>();
		this.observers = new HashMap<TipoNotificacao,CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		super(codigo, nome);
		this.setLivros(livros);
		this.setDisciplinas(disciplinas);
		this.observers = new HashMap<TipoNotificacao,CheckpointObserver>();
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
		double pctCumprido = 0;
		int iCount = 0;
		for(Disciplina disciplina : disciplinas) {
            pctCumprido += disciplina.getPercentualCumprido();
			iCount += 1;
		}
		
		return pctCumprido/iCount;
	}
	
	public boolean isCHCompleta() {
		return this.getChCumprida() == 1.0;
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
	
	public String getPercentualCumpridoDisciplinas() {
		StringBuilder pctCumpridoDisciplinas = new StringBuilder();
		for(Disciplina disciplina : this.disciplinas) {
			pctCumpridoDisciplinas.append(" Nome: ");
			pctCumpridoDisciplinas.append(disciplina.getNome());
			pctCumpridoDisciplinas.append(" Carga Horaria Cumprida: ");
			pctCumpridoDisciplinas.append(disciplina.getPercentualCumprido());
			pctCumpridoDisciplinas.append('\n');
			}
		return pctCumpridoDisciplinas.toString();
	}
	
	public void avancar(String nomeDisciplina, double percentual) {
		this.state = this.state.avancar(nomeDisciplina, percentual, this);
	}
	
	public Situacao getCheckpoint() {
		return this.state.getCheckpoint(this);
	}
	
	public void restore(Situacao snapshot) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.state.restore(snapshot, this);
	}
	
	public void ativar() {
		this.state = this.state.ativar();
	}

	public void cancelar() {
		this.state = this.state.cancelar();
	}
	
	public void suspender() {
		this.state = this.state.suspender();
	}

	public void emitirCertificado() {
		this.state.emitirCertificado();
	}
	
	public String getStatus() {
		return this.state.getStatus();
	}
	
	public Map<TipoNotificacao,CheckpointObserver> getNotificacoesAtivas() {
		return this.observers;
	}
	
	public void addNotificacao(TipoNotificacao tipoNotificacao) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		CheckpointObserver observer = NotificacaoFactory.getNotificacao(tipoNotificacao);
		this.observers.put(tipoNotificacao, observer); 
	}
	
	public void removeNotificacao(TipoNotificacao tipoNotificacao) {
		this.observers.remove(tipoNotificacao);
	}
	
	public void fireCheckpointEvent(String tipoCheckpoint, String disciplinas){
		for(TipoNotificacao key : this.observers.keySet()) {
			CheckpointObserver observer = this.observers.get(key);
			observer.notifyCheckpoint(new CheckpointNotifyEvent(tipoCheckpoint, disciplinas));
		}
	}
	
}
