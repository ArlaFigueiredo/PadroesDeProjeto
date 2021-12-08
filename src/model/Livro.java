package model;

import prototype.Prototipavel;

public class Livro extends Produto implements ProdutoIF, Prototipavel{
	
	private String isbn;
	
	public Livro(Livro livro) {
		super(livro);
		this.isbn = livro.isbn;
		this.preco = livro.preco;
	}	
	
	public Livro() {}
	
	public Livro(String codigo, String nome) {
		this.setNome(nome);
		this.setCodigo(codigo);
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

	@Override
	public void ajustarProduto(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setIsbn(null);
	}

	@Override
	public String getDetalhes() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo()
						+ "/ ISBN: "+ this.getIsbn();
		return detalhes;
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
	
	@Override
	public Prototipavel prototipar() {
		return new Livro(this);
	}

}
