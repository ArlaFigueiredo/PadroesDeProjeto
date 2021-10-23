import java.util.ArrayList;
import java.util.List;

public class CursoBuilder {

	private List<ProdutoIF> livros;
	private List<ProdutoIF> disciplinas;
	private String codigo;
	private String nome;
	
	public CursoBuilder() {
		this.livros = new ArrayList<ProdutoIF>();
		this.disciplinas = new ArrayList<ProdutoIF>();
	}
	
	public void addLivro(ProdutoIF livro) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.livros.add(livro);
	}
	
	public void addDisciplina(ProdutoIF disciplina) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.disciplinas.add(disciplina);
	}
	
	public Curso build() {
		return new Curso(codigo,nome,livros,disciplinas)
	}
	
}
