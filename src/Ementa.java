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
				"Nome do curso : " + this.nomeCurso + "\n" +
				"Codigo do curso : " + this.codigoCurso + "\n" +
				"Disciplinas : " + this.printCH() +
				"CH Total : "+ this.chTotal);
	}
	
	public String printCH() {
		StringBuilder dadosDisciplinas = new StringBuilder();
		for(Disciplina disciplina : this.disciplinas) {
			dadosDisciplinas.append(disciplina.getCodigo());
			dadosDisciplinas.append(disciplina.getNome());
			dadosDisciplinas.append(disciplina.getCargaHoraria());
			dadosDisciplinas.append('\n');
		}
		return dadosDisciplinas.toString();
	}
}
