package builder;

import java.util.ArrayList;
import java.util.List;
import model.Disciplina;
import model.Livro;
import model.Ementa;

public class EmentaBuilder implements BuilderIF{

	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private String codigo;
	private String nome;
	
	public EmentaBuilder() {
		this.livros = new ArrayList<Livro>();
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public void addLivros(Livro livro) {
		this.livros.add(livro);
	}
	
	public void addDisciplinas(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public Ementa build() {
		return new Ementa(this.codigo, this.nome,  this.disciplinas, this.livros);
	}
	
}

