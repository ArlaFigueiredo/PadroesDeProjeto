package factory;

import java.lang.reflect.InvocationTargetException;

import model.Produto;


public abstract class ProdutoFactory {
	
	public static Produto getProduto(TipoProduto tipo, String codigo, String nome) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		ProdutoFactory factory = 
				(ProdutoFactory) Class.forName(tipo.getFactoryName()).getConstructor().newInstance();
		return factory.createProduto(codigo, nome);
	}
	
	public abstract Produto createProduto(String codigo, String nome);

}
