package state;


public class ConcluidoState extends AbstractCursoState implements CursoState{
	
	@Override
	public void emitirCertificado() {
		System.out.println("Certificado de conclusao do this.curso ");
	}
	
	public String getStatus(){
		return "CONCLUIDO";
	}
}
