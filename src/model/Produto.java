package model;

import prototype.Prototipavel;

public abstract class Produto implements ProdutoIF, Prototipavel{
	
	private String codigo;
	private String nome;
	
	public Produto(Produto produto) {
		this.codigo = produto.codigo;
		this.nome = produto.nome;
	}
	
	public Produto(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public abstract double getPreco();
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "[" + this.getCodigo() + "] - " + this.getNome(); 
	}
}
