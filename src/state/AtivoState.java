package state;


public class AtivoState extends AbstractCursoState implements CursoState{
	
	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}

	@Override
	public CursoState suspender() {
		return new SuspensoState();
	}

}
