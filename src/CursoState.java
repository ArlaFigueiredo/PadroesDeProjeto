
public interface CursoState {
	
	public void restore(Curso.Situacao checkpoint);
	public void emitirCertificado();
	public void avancar(String nomeDisciplina, double percentual);
	public CursoState ativar();
	public CursoState suspender();
	public CursoState cancelar();
}
