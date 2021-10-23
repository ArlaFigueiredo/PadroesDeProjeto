import java.util.List;

public class Curso {
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private String codigo;
	private String nome;
	private Ementa ementa;
	
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
}
