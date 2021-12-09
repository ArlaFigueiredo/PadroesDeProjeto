package memento;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factory.TipoNotificacao;
import model.Curso;
import model.Disciplina;
import model.Livro;
import observer.CheckpointObserver;

public class Situacao {
	
	private Curso curso;
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	HashMap<TipoNotificacao,CheckpointObserver> observers;
	
	public Situacao(Curso curso, 
					 List<Livro> livros,
					 List<Disciplina> disciplinas,
					 Map<TipoNotificacao,CheckpointObserver> observers) {
		
		this.curso = curso;
		
		this.disciplinas = new ArrayList<Disciplina>();
		for(Disciplina d : disciplinas)
			this.disciplinas.add((Disciplina)d.prototipar());
		this.livros = new ArrayList<Livro>();
		for(Livro l : livros)
			this.livros.add((Livro)l.prototipar());
		this.observers = new HashMap<TipoNotificacao,CheckpointObserver>();
		for(TipoNotificacao key : observers.keySet()) {
			CheckpointObserver observer = this.observers.get(key);
			this.observers.put(key, observer); 
		}
	}
	
	public void restore() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.curso.setLivros(livros);
		this.curso.setDisciplinas(disciplinas);
		for(TipoNotificacao key : observers.keySet())
			this.curso.addNotificacao(key);
	}

}
