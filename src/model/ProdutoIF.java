package model;

public interface ProdutoIF {
	public double getPreco();
	public String getDetalhes();
	public void ajustarProduto(String codigo, String nome);
}
