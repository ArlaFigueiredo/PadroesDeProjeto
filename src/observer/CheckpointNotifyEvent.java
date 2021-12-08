package observer;

import java.util.List;
import model.Disciplina;

public class CheckpointNotifyEvent {
	
	private String tipoCheckpoint;
	private List<Disciplina> disciplinas;
	
	public CheckpointNotifyEvent(String tipoCheckpoint, List<Disciplina> disciplinas) {
		this.tipoCheckpoint = tipoCheckpoint;
		this.disciplinas = disciplinas;
	}

	public String getTipoCheckpoint() {
		return this.tipoCheckpoint;
	}

	public List<Disciplina> getCHDisciplinas() {
		return this.disciplinas;
	}

}
