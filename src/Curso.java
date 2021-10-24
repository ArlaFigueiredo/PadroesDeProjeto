import java.util.List;

public class Curso extends Produto implements ProdutoIF, Prototipavel{
	
	private List<Livro> livros;
	private List<Disciplina> disciplinas;
	private Ementa ementa;
	private int chTotal;
	private int chCumprida;
	
	public Curso(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.livros = livros;
		this.disciplinas = disciplinas;
	}
	
	public void setEmenta() {
		this.ementa = new Ementa(this.getNome(),this.getCodigo(),this.disciplinas);
	}
	
	public Ementa getEmenta() {
		return this.ementa;
	}
	
	public int getChTotal() {
		return this.chTotal;
	}
	
	public int getChCumprida() {
		return this.chCumprida;
	}

	@Override
	public Prototipavel prototipar() {
		Curso novoCurso = this;
		novoCurso.chCumprida = 0;
		return novoCurso;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
}
