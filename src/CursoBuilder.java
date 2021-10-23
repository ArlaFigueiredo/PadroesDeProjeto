import java.util.ArrayList;
import java.util.List;

public class CursoBuilder {

	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private String codigo;
	private String nome;
	
	public CursoBuilder() {
		this.livros = new ArrayList<Livro>();
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public void addLivro(Livro livro) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.livros.add(livro);
	}
	
	public void addDisciplina(Disciplina disciplina) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.disciplinas.add(disciplina);
	}
	
	public Curso build() {
		return new Curso(codigo,nome,livros,disciplinas);
	}
	
}
