package observer;

public class CheckpointNotifyEvent {
	
	private String tipoCheckpoint;
	private String disciplinas;
	
	public CheckpointNotifyEvent(String tipoCheckpoint, String disciplinas) {
		this.tipoCheckpoint = tipoCheckpoint;
		this.disciplinas = disciplinas;
	}

	public String getTipoCheckpoint() {
		return this.tipoCheckpoint;
	}

	public String getCHDisciplinas() {
		return this.disciplinas;
	}

}
