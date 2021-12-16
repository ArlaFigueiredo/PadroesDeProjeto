package model;

import composite.ComponenteIF;
import prototype.Prototipavel;


public class Disciplina extends Produto implements Prototipavel, ComponenteIF{
	
	private double preco;
	private int chTotal;
	private double pctCumprido;
	
	public Disciplina(Disciplina disciplina) {
		super(disciplina);
		this.setCargaHoraria(disciplina.getCargaHoraria());
		this.setPercentualCumprido(disciplina.getPercentualCumprido());
		this.setPreco(disciplina.getPreco());
	}
	
	public Disciplina(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public Disciplina(String codigo, String nome, 
					  int chTotal,
					  double pctCumprido, double preco) {
		super(codigo, nome);
		this.setCargaHoraria(chTotal);
		this.setPercentualCumprido(pctCumprido);
		this.setPreco(preco);
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public int getCargaHoraria() {
		return this.chTotal;
	}
	
	public double getPercentualCumprido() {
		return this.pctCumprido;
	}
	
	public void setCargaHoraria(int chTotal) {
		this.chTotal = chTotal;
	}
	
	public void setPercentualCumprido(double pctCumprido) {
		this.pctCumprido = pctCumprido;
	}
	
	public void registraAvanco(double pct) {
		if(pct + this.getPercentualCumprido() <= 1)
			this.setPercentualCumprido(pct + this.getPercentualCumprido());
	}
	
	public void reset() {
		this.setPercentualCumprido(0);
	}
	
	public String toString() {
		StringBuilder dadosDisciplinas = new StringBuilder();
			dadosDisciplinas.append("Codigo: ");
			dadosDisciplinas.append(this.getCodigo());
			dadosDisciplinas.append(" Nome: ");
			dadosDisciplinas.append(this.getNome());
			dadosDisciplinas.append(" Carga Horaria: ");
			dadosDisciplinas.append(this.getCargaHoraria());
			dadosDisciplinas.append(" Carga Horaria Cumprida: ");
			dadosDisciplinas.append(this.getPercentualCumprido());
			dadosDisciplinas.append('\n');
		return dadosDisciplinas.toString();
	}
	
	public Prototipavel prototipar() {
		return new Disciplina(this);
	}
}
