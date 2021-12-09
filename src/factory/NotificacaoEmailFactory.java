package factory;

import observer.CheckpointNotifyEmail;
import observer.CheckpointObserver;

public class NotificacaoEmailFactory extends NotificacaoFactory{
	
	@Override
	public CheckpointObserver createProduto() {
		return new CheckpointNotifyEmail();
	}

}
