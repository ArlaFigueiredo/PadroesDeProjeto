package factory;


import observer.CheckpointNotifyLogger;
import observer.CheckpointObserver;

public class NotificacaoLoggerFactory extends NotificacaoFactory{
	
	@Override
	public CheckpointObserver createProduto() {
		return new CheckpointNotifyLogger();
	}

}
