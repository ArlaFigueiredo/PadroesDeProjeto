import java.util.ArrayList;
import java.util.List;

public class CursoBuilder implements BuilderIF{

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
	
	public void setLivros(List<Livro> livros){
		this.livros = livros;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas){
		this.disciplinas = disciplinas;
	}

	
	public Curso build() {
		return new Curso(this.codigo, this.nome, this.livros, this.disciplinas);
	}
	
}
