package memento;

import java.util.ArrayList;
import java.util.List;

import model.Curso;
import model.Disciplina;
import model.Livro;

public class Situacao {
	
	private Curso curso;
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	
	public Situacao(Curso curso, 
					 List<Livro> livros,
					 List<Disciplina> disciplinas) {
		
		this.curso = curso;
		
		this.disciplinas = new ArrayList<Disciplina>();
		for(Disciplina d : disciplinas)
			this.disciplinas.add((Disciplina)d.prototipar());
		this.livros = new ArrayList<Livro>();
		for(Livro l : this.livros)
			this.livros.add((Livro)l.prototipar());
	}
	
	public void restore() {
		this.curso.setLivros(livros);
		this.curso.setDisciplinas(disciplinas);
	}

}
