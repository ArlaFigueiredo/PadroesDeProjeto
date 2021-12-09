package state;

import memento.Situacao;
import model.Curso;


public class AbstractCursoState implements CursoState{
	

	@Override
	public void restore(Situacao checkpoint, Curso curso) {
		return;
	}
	
	@Override
	public Situacao getCheckpoint(Curso curso) {
		return null;
	}

	@Override
	public CursoState ativar() {
		return this;
	}

	@Override
	public CursoState cancelar() {
		return this;
	}
	
	@Override
	public CursoState suspender() {
		return this;
	}

	@Override
	public void emitirCertificado() {
		return;
	}
	
	@Override
	public CursoState avancar(String nomeDisciplina, double percentual, Curso curso) {
		return this;
	}
	
	@Override
	public String getStatus(){
		return "";
	}

}
