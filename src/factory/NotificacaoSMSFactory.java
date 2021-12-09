package factory;

import observer.CheckpointNotifySMS;
import observer.CheckpointObserver;

public class NotificacaoSMSFactory extends NotificacaoFactory{
	
	@Override
	public CheckpointObserver createProduto() {
		return new CheckpointNotifySMS();
	}

}
