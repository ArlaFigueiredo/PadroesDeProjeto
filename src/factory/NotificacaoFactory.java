package factory;

import java.lang.reflect.InvocationTargetException;

import observer.CheckpointObserver;

public abstract class NotificacaoFactory {
	
	public static CheckpointObserver getNotificacao(TipoNotificacao tipo) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		NotificacaoFactory factory = 
				(NotificacaoFactory) Class.forName(tipo.getFactoryName()).getConstructor().newInstance();
		return factory.createProduto();
	}
	
	public abstract CheckpointObserver createProduto();

}
