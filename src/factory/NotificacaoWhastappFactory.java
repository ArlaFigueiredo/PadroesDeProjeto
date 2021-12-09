package factory;


import observer.CheckpointNotifyWhastapp;
import observer.CheckpointObserver;

public class NotificacaoWhastappFactory extends NotificacaoFactory{
	
	@Override
	public CheckpointObserver createProduto() {
		return new CheckpointNotifyWhastapp();
	}

}
