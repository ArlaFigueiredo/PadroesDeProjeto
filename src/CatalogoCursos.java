import java.util.ArrayList;
import java.util.List;

public class CatalogoCursos {
	
	
	private static CatalogoCursos catalogo;
	
	public static CatalogoCursos getGerente() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(CatalogoCursos.catalogo == null)
			CatalogoCursos.catalogo = new CatalogoCursos();
		return CatalogoCursos.catalogo; 
	}
	
	private List<Curso> cursos;
	
	public CatalogoCursos() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.cursos = new ArrayList<Curso>();
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	
	public Prototipavel getCurso(String nome) {
		
		for(Curso curso: cursos) {
			if(nome.equalsIgnoreCase(curso.getNome())){
				return curso.prototipar();
			}
		}
		return null;
	}
}