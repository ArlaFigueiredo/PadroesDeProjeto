import java.util.ArrayList;

public class GerentePrototipos {
	
	
	private static GerentePrototipos gerente;
	
	public static GerentePrototipos getGerente() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(GerentePrototipos.gerente == null)
			GerentePrototipos.gerente = new GerentePrototipos();
		return GerentePrototipos.gerente; 
	}
	
	private ArrayList<Curso> cursos;
	
	public GerentePrototipos() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.cursos = new ArrayList<Curso>();
		
	}

}
