package state;

import memento.Situacao;
import model.Curso;


public interface CursoState {
	
	public void restore(Situacao checkpoint, Curso curso);
	public void emitirCertificado();
	public CursoState avancar(String nomeDisciplina, double percentual, Curso curso);
	public Situacao getCheckpoint(Curso curso);
	public CursoState ativar();
	public CursoState suspender();
	public CursoState cancelar();
	public String getStatus();
}
