import java.util.List;

public class Ementa {
	
	private String nomeCurso;
	private String codigoCurso;
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	private int chTotal;

	
	public Ementa(String codigo, String nome,  List<Disciplina>disciplinas, List<Livro>livros) {
		this.nomeCurso = nome;
		this.codigoCurso = codigo;
		this.disciplinas = disciplinas;
		this.livros = livros;
		this.chTotal = 0;
		for(Disciplina disciplina : this.disciplinas) {
			this.chTotal += disciplina.getCargaHoraria();
		}
	}
	
	public void print() {
		System.out.println(
				"Nome do curso : " + this.nomeCurso + "\n" +
				"Codigo do curso : " + this.codigoCurso + "\n" +
				"Disciplinas : " + this.printDisciplinas() +
				"Livros : " + this.printLivros() +
				"CH Total : "+ this.chTotal);
	}
	
	public String printDisciplinas() {
		StringBuilder dadosDisciplinas = new StringBuilder();
		for(Disciplina disciplina : this.disciplinas) {
			dadosDisciplinas.append(disciplina.getCodigo());
			dadosDisciplinas.append(disciplina.getNome());
			dadosDisciplinas.append(disciplina.getCargaHoraria());
			dadosDisciplinas.append('\n');
		}
		return dadosDisciplinas.toString();
	}
	
	public String printLivros() {
		StringBuilder dadosLivros = new StringBuilder();
		for(Livro livro : this.livros) {
			dadosLivros.append(livro.getCodigo());
			dadosLivros.append(livro.getNome());
			dadosLivros.append('\n');
		}
		return dadosLivros.toString();
	}
}
