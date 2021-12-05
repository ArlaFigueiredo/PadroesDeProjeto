
public class AbstractCursoState implements CursoState{
	

	@Override
	public void restore(Curso.Situacao checkpoint) {
		return;
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
	public void avancar() {
		return;
	}

}
