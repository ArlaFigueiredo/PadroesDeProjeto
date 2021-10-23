import java.util.List;

public class Curso {
	
	private List<ProdutoIF> livros;
	private List<ProdutoIF> disciplinas;
	private String codigo;
	private String nome;
	private Ementa ementa;
	
	public Curso(String codigo, String nome, List<ProdutoIF> livros,List<ProdutoIF> disciplinas) {
		this.codigo = codigo;
		this.nome = nome;
		this.livros = livros;
		this.disciplinas = disciplinas;
		
		
	}
	
	public Ementa setEmenta() {
		Ementa ementa = new Ementa(this.nome,this.codigo,this.disciplinas);
		
	}
}
