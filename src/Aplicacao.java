
public class Aplicacao {
	
	public static TipoProduto PRODUTO = TipoProduto.LIVRO;
	public static String codigo = "50784";
	public static String nome = "Abstract Factory";
	private AbstractProdutoFactory produtoFactory;
	
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.produtoFactory = (AbstractProdutoFactory) (Class.forName(Aplicacao.PRODUTO.getFactoryName()).newInstance());
		this.produtoFactory.setCodigo(Aplicacao.codigo);
		this.produtoFactory.setNome(Aplicacao.nome);
	}
	
	public void comprar() throws InterruptedException {
		
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		(new Aplicacao()).comprar();
	}

}
