package state;

import memento.Situacao;
import model.Curso;


public class SuspensoState extends AbstractCursoState implements CursoState{
	
	public Situacao getCheckpoint(Curso curso) {
		Situacao checkpoint = new Situacao(curso, curso.getLivros(), curso.getDisciplinas(), curso.getNotificacoesAtivas());
		curso.fireCheckpointEvent("OCORRENCIA", curso.getPercentualCumpridoDisciplinas());
		return checkpoint;
	}
	
	@Override
	public CursoState ativar() {
		return new AtivoState();
	}
	
	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}
	
	public String getStatus(){
		return "SUSPENSO";
	}
}
