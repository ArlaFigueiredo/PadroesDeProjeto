import java.util.List;

public class Ementa {
	
	private String nomeCurso;
	private String codigoCurso;
	private List<Disciplina> disciplinas;
	private int chTotal;

	
	public Ementa(String nome, String codigo, List<Disciplina>disciplinas) {
		this.nomeCurso = nome;
		this.codigoCurso = codigo;
		this.disciplinas = disciplinas;
		this.chTotal = 0;
		for(Disciplina disciplina : this.disciplinas) {
			this.chTotal += disciplina.getCargaHoraria();
		}
	}
	
	public void print() {
		System.out.println(
				"Nome do curso : " + this.nomeCurso + "\n"
				"Codigo do curso : " + this.codigoCurso + "\n");
	}
}
