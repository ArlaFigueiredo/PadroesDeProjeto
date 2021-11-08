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
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public void addLivro(Livro livro) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.livros.add(livro);
	}
	
	public void addDisciplina(Disciplina disciplina) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.disciplinas.add(disciplina);
	}

	private Ementa buildEmenta(){
		// TODO
	}
	
	public Curso build() {
		Ementa ementa = this.buildEmenta();
		return new Curso(this.codigo, this.nome, this.livros, this.disciplinas);
	}
	
}
