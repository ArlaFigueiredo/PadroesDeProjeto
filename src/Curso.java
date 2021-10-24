import java.util.List;

public class Curso implements Prototipavel{
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private String codigo;
	private String nome;
	private Ementa ementa;
	private int chTotal;
	private int chCumprida;
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		this.codigo = codigo;
		this.nome = nome;
		this.livros = livros;
		this.disciplinas = disciplinas;
	}
	
	public Ementa setEmenta() {
		Ementa ementa = new Ementa(this.nome,this.codigo,this.disciplinas);
		return ementa;
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public Prototipavel prototipar() {
		Curso novoCurso = this;
		novoCurso.chCumprida = 0;
		return novoCurso;
	}
}
