
public abstract class ProdutoFactory {
	
	public ProdutoFactory() {}
	
	public abstract ProdutoIF createProduto();
	
	public ProdutoIF getProduto(String codigo, String nome) {
		ProdutoIF produto = this.createProduto();
		produto.ajustarProduto(codigo, nome);
		return produto;
	}

}
