package observer;

import java.util.List;
import model.Disciplina;

public class CheckpointChangedEvent {
	
	private String tipoCheckpoint;
	private List<Disciplina> disciplinas;
	
	public CheckpointChangedEvent(String tipoCheckpoint, List<Disciplina> disciplinas) {
		this.tipoCheckpoint = tipoCheckpoint;
		this.disciplinas = disciplinas;
	}

	public String getTipoCheckpoint() {
		return this.tipoCheckpoint;
	}

	public String getCHDisciplinas() {
		return "Disciplinas";
	}

}