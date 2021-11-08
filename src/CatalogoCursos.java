import java.util.ArrayList;
import java.util.List;

public class CatalogoCursos {
	
	
	private static CatalogoCursos catalogo;
	
	public static CatalogoCursos getGerente() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(CatalogoCursos.catalogo == null)
			CatalogoCursos.catalogo = new CatalogoCursos();
		return CatalogoCursos.catalogo; 
	}
	
	private List<Prototipavel> cursos;
	
	public CatalogoCursos() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.cursos = new ArrayList<Prototipavel>();
	}
	
	public void addCurso(Prototipavel curso) {
		this.cursos.add(curso);
	}
	
	public Prototipavel getCurso(String nome) {
		
		for(Prototipavel curso: this.cursos) {
			Curso c = (Curso) curso;
			if(nome.equalsIgnoreCase(c.getNome())){
				return c;
			}
		}
		return null;
	}
}
