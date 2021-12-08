package model;

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
				"Disciplinas : \n" + this.printListaDisciplinas() +
				"Livros : \n" + this.printListaLivros() +
				"CH Total : "+ this.chTotal);
	}
	
	public String printListaDisciplinas() {
		StringBuilder dadosDisciplinas = new StringBuilder();
		for(Disciplina disciplina : this.disciplinas) {
			dadosDisciplinas.append(disciplina.toString());
		}
		return dadosDisciplinas.toString();
	}
	
	public String printListaLivros() {
		StringBuilder dadosLivros = new StringBuilder();
		for(Livro livro : this.livros) {
			dadosLivros.append(livro.toString());
		}
		return dadosLivros.toString();
	}
}
