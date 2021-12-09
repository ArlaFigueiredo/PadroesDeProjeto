package state;

import java.lang.reflect.InvocationTargetException;

import memento.Situacao;
import model.Curso;


public interface CursoState {
	
	public void restore(Situacao checkpoint, Curso curso) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;
	public void emitirCertificado();
	public CursoState avancar(String nomeDisciplina, double percentual, Curso curso);
	public Situacao getCheckpoint(Curso curso);
	public CursoState ativar();
	public CursoState suspender();
	public CursoState cancelar();
	public String getStatus();
}
