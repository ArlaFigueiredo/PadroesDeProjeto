import java.util.List;

public class Diretor {
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private String codigo;
	private String nome;
	
	
	public Diretor(String codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public Diretor(String codigo, String nome,  List<Disciplina>disciplinas, List<Livro>livros) {
		this.nome = nome;
		this.codigo = codigo;
		this.disciplinas = disciplinas;
		this.livros = livros;
	}
	
	public void addLivro(Livro livro) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.livros.add(livro);
	}
	
	public void addDisciplina(Disciplina disciplina) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.disciplinas.add(disciplina);
	}
	
	public void construct(BuilderIF builder) {
        builder.setNome(this.nome);
        builder.setCodigo(this.codigo);
        builder.setLivros(this.livros);
        builder.setDisciplinas(this.disciplinas);
    }

}
