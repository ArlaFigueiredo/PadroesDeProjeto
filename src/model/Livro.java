package model;

import bridge.VersaoIF;
import prototype.Prototipavel;


public class Livro extends Produto implements ProdutoIF, Prototipavel{
	
	private double preco;
	private String isbn;
	private VersaoIF versao;
	
	public Livro(Livro livro) {
		super(livro);
		this.setIsbn(livro.getIsbn());
		this.setPreco(livro.getPreco());
	}
	
	public Livro(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public Livro(String codigo, String nome, 
					  String isbn,
					  double preco, VersaoIF versao) {
		super(codigo, nome);
		this.setIsbn(isbn);
		this.setPreco(preco);
	}	
	
	public VersaoIF getVersao() {
		return versao;
	}

	public void setVersao(VersaoIF versao) {
		this.versao = versao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String toString() {
		StringBuilder dadosLivros = new StringBuilder();	
		dadosLivros.append("Codigo: ");
		dadosLivros.append(this.getCodigo());
		dadosLivros.append(" Nome: ");
		dadosLivros.append(this.getNome());
		dadosLivros.append('\n');
		return dadosLivros.toString();
	}
	
	public Prototipavel prototipar() {
		return new Livro(this);
	}
	
	
}
