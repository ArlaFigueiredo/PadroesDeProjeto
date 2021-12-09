package factory;

public enum TipoNotificacao {
	LOGGER("factory.NotificacaoLoggerFactory"), 
	EMAIL("factory.NotificacaoEmailFactory"),
	SMS("factory.NotificacaoSMSFactory");
	
	String className;
	
	private TipoNotificacao(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
}
