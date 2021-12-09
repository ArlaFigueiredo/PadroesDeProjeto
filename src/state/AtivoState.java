package state;

import java.lang.reflect.InvocationTargetException;

import memento.Situacao;
import model.Curso;
import model.Disciplina;

public class AtivoState extends AbstractCursoState implements CursoState{
	
	@Override
	public CursoState avancar(String nomeDisciplina, double percentual, Curso curso) {
		for(Disciplina disciplina : curso.getDisciplinas()) {
			if(nomeDisciplina.equalsIgnoreCase(disciplina.getNome())){
				disciplina.registraAvanco(percentual);
			}
		}
		if(curso.isCHCompleta())
			return new ConcluidoState();
		
		return this;
	}
	
	public Situacao getCheckpoint(Curso curso) {
		
		Situacao checkpoint = new Situacao(curso, curso.getLivros(), curso.getDisciplinas(), curso.getNotificacoesAtivas());
		curso.fireCheckpointEvent("OCORRENCIA", curso.getPercentualCumpridoDisciplinas());
		return checkpoint;
	}
	
	public void restore(Situacao snapshot, Curso curso) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		snapshot.restore();
		curso.fireCheckpointEvent("RESTAURAÇÃO", curso.getPercentualCumpridoDisciplinas());
	}
	
	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}

	@Override
	public CursoState suspender() {
		return new SuspensoState();
	}
	
	public String getStatus(){
		return "EM ANDAMENTO";
	}

}
